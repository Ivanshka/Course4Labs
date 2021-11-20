package student.fit.bstu.pms_12;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller implements Callback<List<Thing>> {

    static final String BASE_URL = "https://c5f9dff0-42af-420a-8b73-bb98ff76b399.mock.pstmn.io/";
    public static ApiClient apiClient;

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        apiClient = retrofit.create(ApiClient.class);

        Call<List<Thing>> call = apiClient.getAllThings();
        call.enqueue(this);

    }

    public void poll(){
        Call<List<Thing>> call = apiClient.getAllThings();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Thing>> call, Response<List<Thing>> response) {
        ThingsHolder.get().getThings().clear();
        if(response.isSuccessful()) {
            List<Thing> things = response.body();
            things.forEach(thing -> System.out.println(thing.getName()));

            ThingsHolder.get().getThings().addAll(things);

        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Thing>> call, Throwable t) {
        t.printStackTrace();
    }
}
