const { Kafka } = require('kafkajs')

const kafka = new Kafka({
  clientId: 'my-consumer',
  brokers: ['172.25.238.254:9092', '172.25.238.254:9093', '172.25.238.254:9094']
})

const consumer = kafka.consumer({groupId:"consumer-group"});
const topic = "animals";

const run = async () => {
    await consumer.connect()
    await consumer.subscribe({ topic })
  
    await consumer.run({
      eachMessage: async ({ topic, partition, message }) => {
        console.log({
          partition,
          offset: message.offset,
          value: message.value.toString(),
        })
      },
    })
}

run().catch(console.error)