import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class ConsumerWithAutoCommit {
    public static void main(String[] args)throws IOException {
        Properties props = new Properties();
        props.put("bootstrap.servers","172.25.238.254:9092, 172.25.238.254:9093, 172.25.238.254:9094");
        props.put("group.id","first-group");
        props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");


        try( KafkaConsumer<String,String> consumer = new KafkaConsumer<>(props)){
            String[] topics = new String[]{"numbers"};
            consumer.subscribe(Arrays.asList(topics));
            while(true){
                ConsumerRecords<String, String> records = consumer.poll(100);
                for(ConsumerRecord<String, String> record : records){
                    String message = String.format("offset = %d, key = %s, value = %s, partition = %s%n", record.offset(), record.key(), record.value(),record.partition());
                    System.out.println(message);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
