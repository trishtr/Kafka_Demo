package utils;

import kafka_consumers.JsonDeserializer;
import models.CensusObject.Metadata;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class Consumers {

    public static ConsumerRecord<String, Object> consumeEventFromTopic (String topicName) {

        boolean consumed = false;
        //Object consumedObject = null;
        String objectName = null;
        try(
            KafkaConsumer<String, Object> consumer = new KafkaConsumer<>(createConsumerProperties(objectName)))
        {
            consumer.subscribe(Arrays.asList(topicName));
            while (true) {
                ConsumerRecords<String, Object> records = consumer.poll(Duration.ofMillis(1000));
                for (ConsumerRecord<String, Object> record : records) {
                    System.out.println("Key : " + record.key());
                    System.out.println("Value : " + record.value().toString());
                    return record;
                }
            }
        }
    }
        /*
        try {
            //string to json
            parsed = true;
        } catch (Exception e) {
            parsed = false;
        }
        if (parsed) return;
*/


    public static Properties createConsumerProperties(String objectName){
        String consumerGroup = "ConsumerGroup";

        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroup);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        if(objectName.equals(Metadata.class))
        {
            props.put(JsonDeserializer.VALUE_CLASS_NAME_CONFIG, Metadata.class);
        }
        else {
            System.out.println("Java Object is not yet created");
        }

        return props;
    }

}

