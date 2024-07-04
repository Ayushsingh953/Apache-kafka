import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.util.Arrays;
import java.util.Properties;

public class ConsumerWithPartitionAssignment {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers","172.25.238.254:9092, 172.25.238.254:9093, 172.25.238.254:9094");
        props.put("group.id","third-group");
        props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        props.put("enable.auto.commit","true");
        props.put("auto.commit.interval.ms", "1000");

        try(KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            String topic = "numbers";
            TopicPartition partitions[] = {
                    new TopicPartition(topic,2),
                    new TopicPartition(topic,4)
            };
            consumer.assign(Arrays.asList(partitions));

            while (true) {
                ConsumerRecords<String,String> records = consumer.poll(100);
                for(ConsumerRecord<String,String> record : records){
                    String message = String.format("offset = %d, key = %s, value = %s, partition = %s", record.offset(), record.key(), record.value(),record.partition());
                    System.out.println(message);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
