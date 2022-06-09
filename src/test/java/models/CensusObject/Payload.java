package models.CensusObject;

import java.util.List;

public class Payload {

    String deparment_code;
    String forecast_datetime;
    float predicted_census;

    public String getDeparment_code() {
        return deparment_code;
    }

    public Payload setDeparment_code(String deparment_code) {
        this.deparment_code = deparment_code;
        return this;
    }

    public String getForecast_datetime() {
        return forecast_datetime;
    }

    public Payload setForecast_datetime(String forecast_datetime) {
        this.forecast_datetime = forecast_datetime;
        return this;
    }

    public float getPredicted_census() {
        return predicted_census;
    }

    public Payload setPredicted_census(float predicted_census) {
        this.predicted_census = predicted_census;
        return this;
    }

    public Payload() {
    }

    public Payload(String deparment_code, String forecast_datetime, float predicted_census) {
        this.deparment_code = deparment_code;
        this.forecast_datetime = forecast_datetime;
        this.predicted_census = predicted_census;
    }
}
