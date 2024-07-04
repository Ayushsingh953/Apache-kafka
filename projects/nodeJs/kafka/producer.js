const { Kafka } = require('kafkajs')
const Chance = require("chance");

const chance = new Chance();
const kafka = new Kafka({
  clientId: 'my-producer',
  brokers: ['172.25.238.254:9092', '172.25.238.254:9093', '172.25.238.254:9094']
})

const producer = kafka.producer()
const topic = "animals";

const produceMessage = async() =>{
    const value = chance.animal();
    try{
        console.log(value);
        await producer.send({
            topic,
            messages: [
              { value },
            ],
          })
    }catch(e){
        console.log("error",e);
    }
}

const run = async () => {
  await producer.connect()
  setInterval(produceMessage,1000);
}

run().catch(console.error)