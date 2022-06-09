package utils;

import kafka_producers.JsonSerializer;
import models.CensusObject.Metadata;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class CensusProducer {

    public static void produceOnTopic(String topicName, Metadata censusEvent){

        KafkaProducer<String, Metadata> producer = new KafkaProducer<>(producerProperties());

        ProducerRecord<String, Metadata> record = new ProducerRecord<String, Metadata>
                    (topicName, censusEvent );

            // Callback Producer
            //Using methods in RecordMetadata class to retrieve metadata

            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (e == null) {//check the data was successfully written or not
                        //return metadata
                        System.out.println(recordMetadata.topic() + "   "
                                + recordMetadata.partition() + "  "
                                + recordMetadata.offset()+ "  "
                                + recordMetadata.timestamp());
                        Log.info("Checking metadata");
                        Log.info("Topic: " + recordMetadata.topic());//topic record is written
                        Log.info("Partition: " + recordMetadata.partition());//number of partition
                        Log.info("Offset: " + recordMetadata.offset());//offset
                        Log.info("Timestamp: " + recordMetadata.timestamp());

                    } else {
                        Log.error("Error Occured" + e);
                    }
                }
            });
        producer.flush();
        producer.close();

        }


    public static Properties producerProperties(){
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());
        return properties;
    }


}
