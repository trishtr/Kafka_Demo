package kafka_producers;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.List;
import java.util.Properties;

public class CVSProducer {

    public CVSProducer(){

        Properties props = new Properties();

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        KafkaProducer<String, Patients> producer = new KafkaProducer<String, Patients>(props);

        ReadCSV readCSV = new ReadCSV("src/main/java/data/patients.cvs");
        List patientList = readCSV.ReadCSVFile();

        for(Object patient : patientList){
            //patient object
            Patients patientsRecord = (Patients) patient;

            ProducerRecord<String, Patients> record = new ProducerRecord<String,Patients>
                    ("simpletopicsample", patientsRecord.getDept(), patientsRecord );

            producer.send(record);
        }

        producer.close();
    }
}
