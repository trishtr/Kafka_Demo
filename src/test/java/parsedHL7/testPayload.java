package parsedHL7;

import com.google.gson.Gson;

public class testPayload {

    public static void main(String[] args) {

        String payload = "{\"payload\":{\"eventData\":{\"ADT\":{\"type\":\"ADT\",\"fields\":{\"MessageControlID\":\"1255\",\"ObservationId\":\"tt-0005-05\",\"ObservationUnit\":\"MDC_DIM_MMHG\",\"PatientID\":\"2266346720\",\"ObservationValue\":\"147.93\",\"MessageType\":\"ORU_R01\",\"AdministrativeSex\":\"F\"}}}}}";

        Gson gson = new Gson();

        realPayload test = gson.fromJson(payload, realPayload.class);
        System.out.println(gson.toJson(test));

    }
}
