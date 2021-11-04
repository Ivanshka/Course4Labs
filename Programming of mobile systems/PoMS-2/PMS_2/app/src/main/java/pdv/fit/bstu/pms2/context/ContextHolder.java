package znp.fit.bstu.pms2.context;

import lombok.Getter;
import znp.fit.bstu.pms2.listener.AgeTextChangedListener;
import znp.fit.bstu.pms2.listener.HeightTextChangedListener;
import znp.fit.bstu.pms2.listener.SexRadioGroupListener;
import znp.fit.bstu.pms2.listener.SportActivitySelectedListener;
import znp.fit.bstu.pms2.listener.WeightTextChangedListener;
import znp.fit.bstu.pms2.model.Human;
import znp.fit.bstu.pms2.service.CaloriesService;
import znp.fit.bstu.pms2.util.InputValidator;

@Getter
public class ContextHolder {

    private static ContextHolder context;

    private final SportActivitySelectedListener sportActivitySelectedListener;
    private final WeightTextChangedListener weightTextChangedListener;
    private final HeightTextChangedListener heightTextChangedListener;
    private final AgeTextChangedListener ageTextChangedListener;
    private final SexRadioGroupListener sexRadioGroupListener;
    private final CaloriesService caloriesService;
    private final InputValidator inputValidator;
    private final Human human;

    private ContextHolder(){
        caloriesService = new CaloriesService();
        inputValidator = new InputValidator();
        human = new Human();

        sportActivitySelectedListener = new SportActivitySelectedListener(human);
        weightTextChangedListener = new WeightTextChangedListener(inputValidator, human);
        heightTextChangedListener = new HeightTextChangedListener(inputValidator, human);
        ageTextChangedListener = new AgeTextChangedListener(inputValidator, human);
        sexRadioGroupListener = new SexRadioGroupListener(human);
    }

    public static ContextHolder getContext(){
        if(context == null) {
            synchronized (ContextHolder.class) {
                if (context == null) {
                    context = new ContextHolder();
                }
            }
        }

        return context;
    }
}
