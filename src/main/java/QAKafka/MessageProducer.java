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

        String mess1Str = "{\"eventType\":\"INTAKE1\",\"eventSubType\":\"HL7_1\",\"eventId\":\"0017e8a81bc57c3145204ca603e2227b3cfe8871\",\"clientId\":\"APPRHS\",\"eventSource\":\"RHAPSODY\",\"locationId\":\"APPRHS\",\"timestamp\":\"2022-09-16T04:09:01Z\",\"payload\":{\"eventData\":{\"HL7\":\"MSH|^~\\\\&|AFFINITY|WMC|SHIFTWIZARD|WMC|20220916000124||ADT^A03|51606578|P|2.3|\\rEVN|A03|20220916000124|\\rPV1||O|ASPA^^^WMC|3||||||ASPA||||1||||OPD|1002485451|||||||||||||||||01||||||||20220915162253|20220915235959|\\r\"}},\"log\":[{\"function\":\"scm-pipeline-raw-hl7-lambda\",\"timestamp\":\"2022-09-16T04:09:06.658962Z\",\"result\":\"OK\"}]}";
        String mess2Str = "{\"eventType\":\"INTAKE2\",\"eventSubType\":\"HL7_2\",\"eventId\":\"0017e8a81bc57c3145204ca603e2227b3cfe8871\",\"clientId\":\"APPRHS\",\"eventSource\":\"RHAPSODY\",\"locationId\":\"APPRHS\",\"timestamp\":\"2022-09-16T04:09:01Z\",\"payload\":{\"eventData\":{\"HL7\":\"MSH|^~\\\\&|AFFINITY|WMC|SHIFTWIZARD|WMC|20220916000124||ADT^A03|51606578|P|2.3|\\rEVN|A03|20220916000124|\\rPV1||O|ASPA^^^WMC|3||||||ASPA||||1||||OPD|1002485451|||||||||||||||||01||||||||20220915162253|20220915235959|\\r\"}},\"log\":[{\"function\":\"scm-pipeline-raw-hl7-lambda\",\"timestamp\":\"2022-09-16T04:09:06.658962Z\",\"result\":\"OK\"}]}";
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