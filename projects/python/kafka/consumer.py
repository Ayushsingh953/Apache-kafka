import sys
import six
if sys.version_info >= (3, 12, 1): sys.modules['kafka.vendor.six.moves'] = six.moves

from kafka import KafkaConsumer

consumer = KafkaConsumer("names",
                         bootstrap_servers=['172.25.238.254:9092', '172.25.238.254:9093', '172.25.238.254:9094'],
                         group_id="test-group")

for message in consumer:
    print(message)