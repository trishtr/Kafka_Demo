package models.CensusObject;

import java.util.List;

public class Event_data {

    List inferenceData;

    public List<InferenceData> getInferenceData() {
        return inferenceData;
    }

    public Event_data setInferenceData(List<InferenceData> inferenceData) {
        this.inferenceData = inferenceData;
        return this;
    }

    public Event_data(List inferenceData) {
        this.inferenceData = inferenceData;
    }

    public Event_data() {
    }
}
