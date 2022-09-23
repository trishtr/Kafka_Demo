
import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class testProducer {
	
public static void main(String[] args) throws InterruptedException {
		

        // create a Properties instance with the required Kafka configuration
        //logger.info("Defining Kafka properties");
        Properties kafkaProps = new Properties();
        // kafkaProps.setProperty("bootstrap.servers", config.getBootstrapServer());
        //logger.info("Setting up bootstrap server's url");
         kafkaProps.setProperty("url1, url2, url3");
        //logger.info("Setting up bootstrap server's url");
    
        //logger.info("Setting secutiry protool to SSL");
        kafkaProps.setProperty("security.protocol", "SASL_SSL");

        //logger.info("Setting serializer to be org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        //logger.info("Setting value serializer to be org.apache.kafka.common.serialization.StringSerializer ");
        kafkaProps.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        //logger.info("Setting sasl mechanism to use IAM");
        kafkaProps.setProperty("sasl.mechanism", "AWS_MSK_IAM");

        //logger.info("Setting sasl jass to use Iam module");
        kafkaProps.setProperty("sasl.jaas.config", "software.amazon.msk.auth.iam.IAMLoginModule required;");

        //logger.info("setting call back handler provided by amazon");
        kafkaProps.setProperty("sasl.client.callback.handler.class",
                "software.amazon.msk.auth.iam.IAMClientCallbackHandler");

        kafkaProps.setProperty("ssl.truststore.location", "./kafka.client.truststore.jks");
        //kafkaProps.setProperty("ssl.trustore.password", null);


        KafkaProducer<String, String> producer = new KafkaProducer<String,String>(kafkaProps);
        
        String msg = "";
        ProducerRecord<String,String> record = new ProducerRecord<String, String>
                    ("test", "testing", msg );
        
        producer.send(record, new Callback() {
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if (e == null) {//check the data was successfully written or not
                    //return metadata
                    System.out.println("topic: " + recordMetadata.topic() + "   "
                    + recordMetadata.partition() + "  "
                    + recordMetadata.offset()+ "  "
                    + recordMetadata.timestamp());
                    

                } else {
                  System.out.println("Error Occured" + e );
                }
            }
        });
        Thread.sleep(10000);
        
        System.out.println("Message was sent");
		

	}

}
