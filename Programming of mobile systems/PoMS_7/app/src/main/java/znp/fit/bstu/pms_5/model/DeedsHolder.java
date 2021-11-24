package znp.fit.bstu.pms_5.model;

import java.util.ArrayList;
import java.util.List;

import lombok.ToString;

@ToString
public class DeedsHolder {
    private List<Deed> deeds;

    public DeedsHolder(){
        deeds = new ArrayList<>();
    }

    public List<Deed> getDeeds() {
        return deeds;
    }

    public void setDeeds(List<Deed> deeds) {
        this.deeds = deeds;
    }
}

