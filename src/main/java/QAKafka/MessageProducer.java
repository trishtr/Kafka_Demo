package QAKafka;


import com.google.gson.Gson;
import kafka_producers.EmailList;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MessageProducer {

    public MessageProducer() {

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        KafkaProducer<String, MessageEnvelop> producer = new KafkaProducer<String, MessageEnvelop>(properties);

        String mess1Str = "{\"eventType\":\"\",\"eventSubType\":\"\",\"eventId\":\"\",\"clientId\":\"\",\"eventSource\":\"\",\"locationId\":\"\",\"timestamp\":\"\",\"payload\":{\"\":{\"\":\"\"}},\"log\":[{\"function\":\"\",\"timestamp\":\"\",\"result\":\"\"}]}";
        String mess2Str = "{\"eventType\":\"\",\"eventSubType\":\"\",\"eventId\":\"\",\"clientId\":\"\",\"eventSource\":\"\",\"locationId\":\"\",\"timestamp\":\"\",\"payload\":{\"\":{\"\":\"\"}},\"log\":[{\"function\":\"\",\"timestamp\":\"\",\"result\":\"\"}]}";
        Gson gson = new Gson();
        MessageEnvelop mess1 = gson.fromJson(mess1Str, MessageEnvelop.class);
        MessageEnvelop mess2 = gson.fromJson(mess2Str, MessageEnvelop.class);
        //System.out.println(mess1.getPayload());
        List<MessageEnvelop> messageList = new ArrayList<>();
        messageList.add(mess1);
        messageList.add(mess2);

        for(MessageEnvelop mess : messageList) {

            ProducerRecord<String, MessageEnvelop> record = new ProducerRecord<String, MessageEnvelop>
                    ("superSimpleTopic", mess.getClientId(), mess);
            producer.send(record);
        }

        producer.flush();
        producer.close();
    }
}
