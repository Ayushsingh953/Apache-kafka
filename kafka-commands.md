# Basic KAFKA Commands

**START ZOOKEEPER**
```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
```
**START KAFKA BROKER**
```bash
bin/kafka-server-start.sh config/server.properties
```

**CREATE TOPIC**
```bash
bin/kafka-topics.sh --bootstrap-server 
localhost:9092 --create 
--replication-factor 1 
--partitions 3 
--topic test
```
**LIST TOPICS**
```bash
bin/kafka-topics.sh 
--bootstrap-server localhost:9092 
--list
```

**TOPIC DETAILS**
```bash
bin/kafka-topics.sh 
--bootstrap-server localhost:9092 
--describe 
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
bin/kafka-console-consumer.sh 
--bootstrap-server localhost:9092 
--topic test
```
**START CONSOLE CONSUMER AND READ MESSAGES FROM BEGINNING**
```bash
bin/kafka-console-consumer.sh 
--bootstrap-server localhost:9092 
--topic test 
--from-beginning
```

**START CONSOLE CONSUMER WITH SPECIFIC CONSUMER GROUP**
```bash
bin/kafka-console-consumer.sh 
--bootstrap-server localhost:9092 
--topic test 
--group test 
--from-beginning
```

**LIST CONSUMER GROUPS**
```bash
bin/kafka-consumer-groups.sh 
--bootstrap-server localhost:9092 
--list
```

**CONSUMER GROUP DETAILS**
```bash
bin/kafka-consumer-groups.sh 
--bootstrap-server localhost:9092 
--group test 
--describe
```