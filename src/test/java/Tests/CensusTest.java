package Tests;

import com.google.gson.Gson;
import models.CensusObject.CENSUS_INFERENCE_EVENT;
import models.CensusObject.Event_data;
import models.CensusObject.InferenceData;
import models.CensusObject.Payload;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CensusConsumer;
import utils.Log;
import utils.CensusProducer;

import java.util.Arrays;

public class CensusTest {

    @Test
    public void producerTest() {

        String censusTopic = "census-event";

            InferenceData inferenceData = new InferenceData("2345");
            Event_data eventData = new Event_data(Arrays.asList(inferenceData));
            Payload payLoad = new Payload(eventData);
            CENSUS_INFERENCE_EVENT newcensusEvent = new CENSUS_INFERENCE_EVENT(
                    "CENSUS_INFERENCE_EVENT", "1.0", "ec5bc5ed-4b69-4150-a7e9-7c9ea4d2e83d", 1637434057158l,
                    "11d16135-8b71-46b0-bfa2-1d5f3d4f63e8", "9fec9a2a-e652-485b-9d90-f673b69ffcd6", "ML_LAMBDA_CENSUS",
                    payLoad);

            Log.info("Print Census inference event in Json format");
           Gson gson = new Gson();
           String newcensusEventJson = gson.toJson(newcensusEvent);
           System.out.println(newcensusEventJson);

            Log.info("Produce newcensusEvent ");
           CensusProducer.produceOnTopic(censusTopic, newcensusEvent);
           System.out.println("Topic is successfully produced");

           ConsumerRecord<String, CENSUS_INFERENCE_EVENT> record = CensusConsumer.consumeEventFromTopic(censusTopic);

           Log.info("Verifying client_id is correctly produced");
           Assert.assertEquals(record.value().getClient_id(), newcensusEvent.getClient_id());

           Log.info("Verifying event_id is correctly produced");
           Assert.assertEquals(record.value().getEvent_id(), newcensusEvent.getEvent_id());


        }
}
