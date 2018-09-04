package com.wenjin.zhu.kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class ConsumerDemo {
	public static void main(String[] args) {
		Properties properties = new Properties();
		//properties.put("bootstrap.servers", "172.16.53.23:9092,172.16.53.29:9092,172.16.53.30:9092");
		properties.put("bootstrap.servers", "127.0.0.1:9092");
		// group.id Consumer分组ID
		properties.put("group.id", "group-1");
		properties.put("enable.auto.commit", "true");
		properties.put("auto.commit.interval.ms", "1000");
		properties.put("auto.offset.reset", "earliest");
		properties.put("session.timeout.ms", "30000");
		// 。Consumer把来自Kafka集群的二进制消息反序列化为指定的类型。因本例中的Producer使用的是String类型，所以调用StringDeserializer来反序列化
		properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

		@SuppressWarnings("resource")
		KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(properties);
		// Consumer订阅了Topic为AmyTopic的消息，
		kafkaConsumer.subscribe(Arrays.asList("AmyTopic"));
		while (true) {
			// Consumer调用poll方法来轮循Kafka集群的消息，其中的参数100是超时时间（Consumer等待直到Kafka集群中没有消息为止）
			ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
			for (ConsumerRecord<String, String> record : records) {
				System.out.printf("offset = %d, value = %s", record.offset(), record.value());
				System.out.println();
			}
		}

	}
}
