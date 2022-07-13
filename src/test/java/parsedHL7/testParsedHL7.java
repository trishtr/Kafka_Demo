package parsedHL7;

import com.google.gson.Gson;
import parsedHL7.parsedhl7;
import utils.Log;

import java.util.Map;

public class testParsedHL7 {

    public static void main(String[] args) {

        String hl7json = "{\"_id\":{\"$oid\":\"61fc798f1f54495c1ff02a2e\"},\"eventType\":\"INTERNAL\",\"eventSubType\":\"PARSEDHL7\",\"eventId\":\"bc7a5714-9fe0-4b2c-9073-e6445210b8ac\",\"clientId\":\"CLIENTID\",\"eventSource\":\"RHAPSODY\",\"timestamp\":\"2022-02-04T00:55:43Z\",\"payload\":{\"eventData\":{\"ADT\":{\"type\":\"ADT\",\"fields\":{\"MessageControlID\":\"1255\",\"ObservationId\":\"tt-0005-05\",\"ObservationUnit\":\"MDC_DIM_MMHG\",\"PatientID\":\"2266346720\",\"ObservationValue\":\"147.93\",\"MessageType\":\"ORU_R01\",\"AdministrativeSex\":\"F\"}}}},\"devTestDoc\":true}";
        Gson gson = new Gson();

        parsedhl7 test = gson.fromJson(hl7json, parsedhl7.class);
        System.out.println(gson.toJson(test));


        System.out.println(test.getRealPayload());

        //Cast value of eventData to Map
        Log.info("Cast value of eventData to Map");
        Map eventData = (Map) test.getRealPayload().get("eventData");
        System.out.println(eventData.get("ADT"));

        //Cast value of ADT  to Map
        Log.info("Cast value of ADT  to Map");
        Map ADT = (Map) eventData.get("ADT");

        //print out type inside ADT
        Log.info("print out value of 'type' inside ADT");
        System.out.println(ADT.get("type"));

        //Cast value of fields to Map
        Log.info("Cast value of fields to Map");
        Map fields = (Map) ADT.get("fields");

        Log.info("print out value of MessageControlID");
        System.out.println(fields.get("MessageControlID"));


    }
}
