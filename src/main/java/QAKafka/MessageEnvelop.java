package QAKafka;

import com.opencsv.bean.CsvBindByName;

import java.util.List;
import java.util.Map;

public class MessageEnvelop {
    @CsvBindByName
    private String eventType;
    @CsvBindByName
    private String eventSubType;
    @CsvBindByName
    private String eventId;
    @CsvBindByName
    private String clientId;
    @CsvBindByName
    private String eventSource;
    @CsvBindByName
    private String locationId;
    @CsvBindByName
    private String timestamp;
    @CsvBindByName (column = "payload" )

    private Map<String, Object> payload;
    @CsvBindByName
    private List<Log> log;

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

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
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

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, Object> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, Object> payload) {
        this.payload = payload;
    }

    public List<Log> getLog() {
        return log;
    }

    public void setLog(List<Log> log) {
        this.log = log;
    }

    public MessageEnvelop(String eventType, String eventSubType, String eventId, String clientId, String eventSource, String locationId, String timestamp, Map<String, Object> payload, List<Log> log) {
        this.eventType = eventType;
        this.eventSubType = eventSubType;
        this.eventId = eventId;
        this.clientId = clientId;
        this.eventSource = eventSource;
        this.locationId = locationId;
        this.timestamp = timestamp;
        this.payload = payload;
        this.log = log;
    }
}
