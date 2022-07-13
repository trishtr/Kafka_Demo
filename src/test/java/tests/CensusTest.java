package tests;

import com.google.gson.Gson;
import models.CensusObject.Metadata;
import models.CensusObject.Payload;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CensusConsumer;
import utils.Log;
import utils.CensusProducer;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class CensusTest {

    @Test
    public void testProducer() throws IOException {

            String censusTopic = "census-event-2";
            //payload
            Payload payload = new Payload();
            //"payload"
            payload.setName("payload");
            //List<Map>: k: block_size, k : census_data
            List payloadList = new ArrayList();

            //census_data: List of map
            List<Map<String, Object>> censusList;
            censusList = new ArrayList<>();

            Map censusMap = new HashMap<>();
            censusMap.put("unit_code", "2W");
            censusMap.put("forecast_datetime", "2022-12-31T23:00:00.000-05:00");
            censusMap.put("predicted_census", 8.3900003433f);
            censusList.add(censusMap);

            Map<String, Object> payloadMap = new HashMap<>();
            payloadMap.put("block_size", 4);
            payloadMap.put("census_data", censusList);

            payloadList.add(payloadMap);

            Metadata newcensusEvent = new Metadata(
                    "CENSUS_INFERENCE_EVENT", "1.0", "ec5bc5ed-4b69-4150-a7e9-7c9ea4d2e83d", 1637434057158l,
                    "11d16135-8b71-46b0-bfa2-1d5f3d4f63e8", "9fec9a2a-e652-485b-9d90-f673b69ffcd6", "ML_LAMBDA_CENSUS", payloadList);

            Log.info("Print metadata in Json format");
            Gson gson = new Gson();
            String newcensusEventJson = gson.toJson(newcensusEvent);
            System.out.println(newcensusEventJson);

            Log.info("Produce newcensusEvent ");

            CensusProducer.produceOnTopic(censusTopic, newcensusEvent);
            System.out.println("Topic is successfully produced");


            ConsumerRecord<String, Metadata> record = CensusConsumer.consumeEventFromTopic(censusTopic);

            Log.info("Verifying client_id is correctly produced");
            Assert.assertEquals(record.value().getClient_id(), newcensusEvent.getClient_id());

            Log.info("Verifying event_id is correctly produced");
            Assert.assertEquals(record.value().getEvent_id(), newcensusEvent.getEvent_id());

            Log.info("Convert Epoch Time to date for future reference");
            //if location_id is unique, we can convert the timezone based on location_id
            //assume the location_id is for US/Central time zone
            if (record.value().getLocation_id().equals("9fec9a2a-e652-485b-9d90-f673b69ffcd6")) {
                Date date = new Date(record.value().getEvent_time_ms());
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                format.setTimeZone(TimeZone.getTimeZone("US/Central"));
                String formatted = format.format(date);
                System.out.println(formatted);
            }

            Log.info("Check event type");
            if (record.value().getEvent_type().equalsIgnoreCase("CENSUS_INFERENCE_EVENT")) {
                Log.info("if event_type = CENSUS, parse payload in consumer to json");

                gson.toJson(record.value().getPayload(), new FileWriter(System.getProperty("user.dir") + "/data.json"));
                String jsonObj = gson.toJson(record.value().getPayload());
                System.out.println(jsonObj);

            }
        }
    }
