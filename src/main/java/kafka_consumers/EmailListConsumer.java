package kafka_consumers;

import kafka_producers.EmailList;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class EmailListConsumer {

    public EmailListConsumer() {

        final String bootstrapServer = "localhost:9092";
        final String consumerGroupId ="email-group-consumer";
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.VALUE_CLASS_NAME_CONFIG, EmailList.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        KafkaConsumer<String, EmailList> consumer = new KafkaConsumer<>(props);
        //topics: EmailList
        consumer.subscribe(Arrays.asList("EmailList"));
        while(true){
            ConsumerRecords<String, EmailList> records = consumer.poll(Duration.ofMillis(1000));
            for(ConsumerRecord<String, EmailList> record: records){
                System.out.println("Key: " + record.key()
                + " , Email : " +  record.value().getEmail()
                + " , Password : " +  record.value().getPassword());
            }
        }



    }
}
