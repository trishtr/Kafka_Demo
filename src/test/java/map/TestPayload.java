package map;

import java.util.List;
import java.util.Map;

public class TestPayload {
    String name;
    private List<Map> payload;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Map> getPayload() {
        return payload;
    }

    public void setPayload(List<Map> payload) {
        this.payload = payload;
    }
}
