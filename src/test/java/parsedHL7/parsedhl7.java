package parsedHL7;

import java.util.Map;

public class parsedhl7 {

    private String id;
    private String eventType;
    private String eventSubType;
    private String clientId;
    private String eventSource;
    private String timestamp;

    private Map payload;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventSubType() {
        return eventSubType;
    }

    public void setEventSubType(String eventSubType) {
        this.eventSubType = eventSubType;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getEventSource() {
        return eventSource;
    }

    public void setEventSource(String eventSource) {
        this.eventSource = eventSource;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Map getRealPayload() {
        return payload;
    }

    public void setRealPayload(Map realPayload) {
        this.payload = realPayload;
    }

    public parsedhl7(String id, String eventType, String eventSubType, String clientId, String eventSource, String timestamp, Map payload) {
        this.id = id;
        this.eventType = eventType;
        this.eventSubType = eventSubType;
        this.clientId = clientId;
        this.eventSource = eventSource;
        this.timestamp = timestamp;
        this.payload = payload;
    }

}
