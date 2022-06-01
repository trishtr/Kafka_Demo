package models.CensusObject;

public class CENSUS_INFERENCE_EVENT {
    public CENSUS_INFERENCE_EVENT() {
    }

    String event_type;
    String version;
    String event_id;
    long event_time_ms;
    String client_id;
    String location_id;
    String event_source;

    Payload payload;

    public String getEvent_type() {
        return event_type;
    }

    public CENSUS_INFERENCE_EVENT setEvent_type(String event_type) {
        this.event_type = event_type;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public CENSUS_INFERENCE_EVENT setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getEvent_id() {
        return event_id;
    }

    public CENSUS_INFERENCE_EVENT setEvent_id(String event_id) {
        this.event_id = event_id;
        return this;
    }

    public long getEvent_time_ms() {
        return event_time_ms;
    }

    public CENSUS_INFERENCE_EVENT setEvent_time_ms(long event_time_ms) {
        this.event_time_ms = event_time_ms;
        return this;
    }

    public String getClient_id() {
        return client_id;
    }

    public CENSUS_INFERENCE_EVENT setClient_id(String client_id) {
        this.client_id = client_id;
        return this;
    }

    public String getLocation_id() {
        return location_id;
    }

    public CENSUS_INFERENCE_EVENT setLocation_id(String location_id) {
        this.location_id = location_id;
        return this;
    }

    public String getEvent_source() {
        return event_source;
    }

    public CENSUS_INFERENCE_EVENT setEvent_source(String event_source) {
        this.event_source = event_source;
        return this;
    }

    public Payload getPayload() {
        return payload;
    }

    public CENSUS_INFERENCE_EVENT setPayload(Payload payload) {
        this.payload = payload;
        return this;
    }

    public CENSUS_INFERENCE_EVENT(String event_type, String version, String event_id, long event_time_ms, String client_id, String location_id, String event_source, Payload payload) {
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


