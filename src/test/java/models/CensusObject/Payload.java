package models.CensusObject;

public class Payload {

    Event_data eventData;

    public Event_data getEventData() {
        return eventData;
    }

    public Payload setEventData(Event_data eventData) {
        this.eventData = eventData;
        return this;
    }

    public Payload(Event_data eventData) {
        this.eventData = eventData;
    }

    public Payload() {
    }
}
