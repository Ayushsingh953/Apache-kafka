import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers","172.25.238.254:9092, 172.25.238.254:9093, 172.25.238.254:9094");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String,String> producer = new KafkaProducer<>(props);

        int numRecords = 100;
        for (int i = 0; i < numRecords; i++) {
            System.out.println("Sending record " + i);
            producer.send(new ProducerRecord<>("numbers",Integer.toString(i),Integer.toString(i)));
        }

        producer.close();
    }
}
