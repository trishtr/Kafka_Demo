package kafka_producers;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmailListProducer {

    final Logger logger = LogManager.getLogger();
    public EmailListProducer() {

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        KafkaProducer<String, EmailList> producer = new KafkaProducer<>(properties);

        List<EmailList> emailList = new ArrayList<>();
        EmailList emailList1 = new EmailList("123@gmail.com", "abc");
        EmailList emailList2 = new EmailList("1234@gmail.com", "abc1");
        EmailList emailList3 = new EmailList("12345@gmail.com", "abc2");
        emailList.add(emailList1);
        emailList.add(emailList2);
        emailList.add(emailList3);

        /*ProducerRecord<String, EmailList> record =
                new ProducerRecord<>("kafka_producers.EmailList", emailList1.getEmail(), emailList1);
        producer.send(record); */

        for(Object email : emailList){
            //patient object
            EmailList emailRecord = (EmailList) email;

            ProducerRecord<String, EmailList> record = new ProducerRecord<String,EmailList>
                    ("superSimpleTopic", emailRecord.getEmail(), emailRecord);

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
                        logger.info("Checking metadata");
                        logger.info("Topic: " + recordMetadata.topic());//topic record is written
                        logger.info("Partition: " + recordMetadata.partition());//number of partition
                        logger.info("Offset: " + recordMetadata.offset());//offset
                        logger.info("Timestamp: " + recordMetadata.timestamp());

                    } else {
                       logger.error("Error Occured" , e );
                    }
                }
            });


       }

        producer.flush();
        producer.close();
    }

}
