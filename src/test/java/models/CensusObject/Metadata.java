package models.CensusObject;

import java.util.List;
import java.util.Map;

public class Metadata {
    public Metadata() {
    }

    String event_type;
    String version;
    String event_id;
    long event_time_ms;
    String client_id;
    String location_id;
    String event_source;

    //List payload;
    List<Map> payload;
    //Map<String,?> payload;

    /*
    boolean rightObject = false;
    try {
        Metadata data = (Metadata) payload.get("key");
        rightObject = true;
    } catch (Exception e) {
        //Ko dung object class
        rightObject = false;
    }
    if (rightObject) return;
 */
    //

    public String getEvent_type() {
        return event_type;
    }

    public Metadata setEvent_type(String event_type) {
        this.event_type = event_type;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public Metadata setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getEvent_id() {
        return event_id;
    }

    public Metadata setEvent_id(String event_id) {
        this.event_id = event_id;
        return this;
    }

    public long getEvent_time_ms() {
        return event_time_ms;
    }

    public Metadata setEvent_time_ms(long event_time_ms) {
        this.event_time_ms = event_time_ms;
        return this;
    }

    public String getClient_id() {
        return client_id;
    }

    public Metadata setClient_id(String client_id) {
        this.client_id = client_id;
        return this;
    }

    public String getLocation_id() {
        return location_id;
    }

    public Metadata setLocation_id(String location_id) {
        this.location_id = location_id;
        return this;
    }

    public String getEvent_source() {
        return event_source;
    }

    public Metadata setEvent_source(String event_source) {
        this.event_source = event_source;
        return this;
    }

    public List<Map> getPayload() {
        return payload;
    }

    public void setPayload(List<Map> payload) {
        this.payload = payload;
    }

    public Metadata(String event_type, String version, String event_id, long event_time_ms, String client_id, String location_id, String event_source, List payload) {
        this.event_type = event_type;
        this.version = version;
        this.event_id = event_id;
        this.event_time_ms = event_time_ms;
        this.client_id = client_id;
        this.location_id = location_id;
        this.event_source = event_source;
        this.payload = payload;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


