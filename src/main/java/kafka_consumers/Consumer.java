package kafka_consumers;

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

public class Consumer {

    public Consumer() {

        final Logger logger = LogManager.getLogger(Consumer.class);

        final String bootstrapServer = "localhost:9092";
        final String consumerGroupId ="java-group-consumer";

        //create and populate properties object
        Properties prop = new Properties();
        prop.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServer);
        prop.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        prop.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        prop.setProperty(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId);
        prop.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        //create consumer

        final KafkaConsumer<String, String> consumer = new KafkaConsumer<String,String>(prop);

        //subscribe to topics

        consumer.subscribe(Arrays.asList("myfirsttopic"));

        //poll and consume records
        while(true) {
            ConsumerRecords<String, String> records  = consumer.poll(Duration.ofMillis(1000));
            for(ConsumerRecord record: records){
                System.out.println("Topic: " + record.topic());
                System.out.println("Key: " + record.key());
                System.out.println("Partition: " + record.partition());
                System.out.println("Timestamp: " + record.timestamp());
                System.out.println("Offset: " + record.offset());
            }
        }

    }
}
