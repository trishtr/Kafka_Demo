package parsedHL7;

import java.util.Map;

public class realPayload {

    private String name;
    private Map payload;


    public realPayload() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public Map getPayload() {
        return payload;
    }

    public void setPayload(Map payload) {
        this.payload = payload;

    }
}
