import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class ConsumerWithManualCommit {
    public static void main(String[] args)throws IOException {
        Properties props = new Properties();
        props.put("bootstrap.servers","172.25.238.254:9092, 172.25.238.254:9093, 172.25.238.254:9094");
        props.put("group.id","second-group");
        props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

        try(KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
            FileWriter fileWriter = new FileWriter("numbers.txt",true)) {
            String[] topics = new String[]{"numbers"};
            consumer.subscribe(Arrays.asList(topics));

            final int batchSize = 200;
            ArrayList<ConsumerRecord<String, String>> buffer = new ArrayList<>();
            while(true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for(ConsumerRecord<String, String> record : records) {
                    buffer.add(record);
                    String message = String.format("offset = %s, key = %s, value = %s, partition = %s%n", record.offset(), record.key(), record.value(),record.partition());
                    System.out.println(message);
                }
                if(buffer.size()>=batchSize) {
                    fileWriter.append(buffer.toString())
                            .append("\n");
                    consumer.commitSync();
                    buffer.clear();
                }
            }
        }
    }
}
