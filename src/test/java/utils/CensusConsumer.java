package utils;

import kafka_consumers.JsonDeserializer;
import models.CensusObject.Metadata;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class CensusConsumer {

    public static ConsumerRecord<String, Metadata> consumeEventFromTopic (String topicName) throws IOException {

            KafkaConsumer<String, Metadata> consumer = new KafkaConsumer<>(createConsumerProperties());
            consumer.subscribe(Arrays.asList(topicName));

            while (true) {
                ConsumerRecords<String, Metadata> records = consumer.poll(Duration.ofMillis(2000));
                for (ConsumerRecord<String, Metadata> record : records) {
                    System.out.println("Key: " + record.key()
                            + " , Event_id : " + record.value().getEvent_id()
                            + " , Client_id : " + record.value().getClient_id());
                    return record;
                }

            }

        }



    public static Properties createConsumerProperties(){
        String consumerGroup = "ConsumerGroup";
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroup);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName());
        props.put(JsonDeserializer.VALUE_CLASS_NAME_CONFIG, Metadata.class);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return props;
    }

}
