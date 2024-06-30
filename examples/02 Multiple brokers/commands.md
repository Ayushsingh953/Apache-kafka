# KAFKA Commands

**Note:** Run all the commands in kafka directory.

**START ZOOKEEPER**
```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
```

**START MULTIPLE KAFKA BROKER**
```bash
bin/kafka-server-start.sh config/server0.properties
bin/kafka-server-start.sh config/server1.properties
bin/kafka-server-start.sh config/server2.properties
```

**GET INFORMATION FROM ZOOKEEPER ABOUT ACTIVE BROKER IDS**
```bash
bin/zookeeper-shell.sh localhost:2181 ls /brokers/ids
```

**GET INFORMATION FROM ZOOKEEPER ABOUT SPECIFIC BROKER BY ID**
```bash
bin/zookeeper-shell.sh localhost:2181 get /brokers/ids/0
```

**CREATE TOPIC**
```bash
bin/kafka-topics.sh \
--bootstrap-server localhost:9092,localhost:9093,localhost:9094 \
--create \
--replication-factor 3 \
--partitions 5 \
--topic test
```

**LIST TOPICS**
```bash
bin/kafka-topics.sh \
--bootstrap-server localhost:9092,localhost:9093,localhost:9094 \
--list
```

**TOPIC DETAILS**
```bash
bin/kafka-topics.sh \
--bootstrap-server localhost:9092,localhost:9093,localhost:9094 \
--describe \
--topic test
```

**START CONSOLE PRODUCER**
```bash
bin/kafka-console-producer.sh \
--broker-list localhost:9092,localhost:9093,localhost:9094 \
--topic test
```

**START CONSOLE CONSUMER**
```bash
bin/kafka-console-consumer.sh \
--bootstrap-server localhost:9092,localhost:9093,localhost:9094 \
--topic test
```

**START CONSOLE CONSUMER AND READ MESSAGES FROM BEGINNING**
```bash
bin/kafka-console-consumer.sh \
--bootstrap-server localhost:9092,localhost:9093,localhost:9094 \
--topic test \
--from-beginning
```
