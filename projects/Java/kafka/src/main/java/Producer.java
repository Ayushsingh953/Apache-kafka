import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Date;
import java.util.Properties;

public class Producer {
    public static void main(String[] args) {
        String clientId = "my-producer";
        Properties props = new Properties();
        props.put("bootstrap.servers","172.25.238.254:9092, 172.25.238.254:9093, 172.25.238.254:9094");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("acks", "1");
        props.put("client.id", clientId);

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(props)) {
            int numRecords = 100;
            for (int i = 0; i < numRecords; i++) {
                String message = String.format("Producer %s has sent message %s at %s.", clientId, i, new Date());
                System.out.println(message);
                producer.send(new ProducerRecord<>("numbers", Integer.toString(i), message));
//                Thread.sleep(300);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
