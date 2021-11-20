package student.fit.bstu.pms_12;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiClient {

    @GET("things/")
    Call<List<Thing>> getAllThings();
}
