import sys
import six
if sys.version_info >= (3, 12, 1): sys.modules['kafka.vendor.six.moves'] = six.moves

from kafka import KafkaProducer
import time
from faker import Faker

fake = Faker()

producer = KafkaProducer(bootstrap_servers=['172.25.238.254:9092', '172.25.238.254:9093', '172.25.238.254:9094'])
for _ in range(100):
    name = fake.name()
    producer.send("names",name.encode("utf-8"))
    print(name)
    time.sleep(1)