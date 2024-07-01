# KAFKA Commands

**Note:** Run all the commands in kafka directory.

**START ZOOKEEPER**
```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
```

**START KAFKA BROKER**
```bash
bin/kafka-server-start.sh config/server0.properties
bin/kafka-server-start.sh config/server1.properties
bin/kafka-server-start.sh config/server2.properties
```

**CREATE TOPIC**
```bash
bin/kafka-topics.sh \
--bootstrap-server localhost:9092 \
--create \
--replication-factor 3 \
--partitions 100 \
--topic test
```

**LIST TOPICS**
```bash
bin/kafka-topics.sh \
--bootstrap-server localhost:9092 \
--list
```

**TOPIC DETAILS**
```bash
bin/kafka-topics.sh \
--bootstrap-server localhost:9092 \
--describe \
--topic test
```

**START CONSOLE PRODUCER**
```bash
bin/kafka-console-producer.sh \
--broker-list localhost:9092 \
--topic test
```

**START CONSOLE CONSUMER**
```bash
bin/kafka-console-consumer.sh \
--bootstrap-server localhost:9092 \
--topic test
```

**START CONSOLE CONSUMER AND READ FROM SPECIFIC PARTITION**
```bash
bin/kafka-console-consumer.sh \
--bootstrap-server localhost:9092 \
--partition 4 \
--from-beginning \
--topic test
```

**START CONSOLE CONSUMER AND READ MESSAGES FROM BEGINNING**
```bash
bin/kafka-console-consumer.sh \
--bootstrap-server localhost:9092 \
--topic test \
--from-beginning
```

**START CONSOLE CONSUMER WITH SPECIFIC CONSUMER GROUP**
```bash
bin/kafka-console-consumer.sh \
--bootstrap-server localhost:9092 \
--topic test \
--group test \
--from-beginning
```

**LIST CONSUMER GROUPS**
```bash
bin/kafka-consumer-groups.sh \
--bootstrap-server localhost:9092 \
--list
```

**CONSUMER GROUP DETAILS**
```bash
bin/kafka-consumer-groups.sh \
--bootstrap-server localhost:9092 \
--group test \
--describe
```

**PRODUCER PERFORMANCE TEST**
```bash
bin/kafka-producer-perf-test.sh \
--topic test \
--num-records 1000 \
--throughput 10 \
--record-size 1000 \
--producer-props \
bootstrap.servers=localhost:9092
```

**CONSUMER PERFORMANCE TEST**
```bash
bin/kafka-consumer-perf-test.sh \
--broker-list localhost:9092 \
--topic test \
--messages 1000000
```