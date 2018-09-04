package com.wenjin.zhu.controller;

import java.util.Arrays;
import java.util.Properties;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.TextMessage;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wenjin.zhu.service.activemq.ConsumerService;
import com.wenjin.zhu.service.activemq.ProducerService;
/**
 * 
 * 
 * @Title:  MessageController.java   
 * @Package com.wenjin.zhu.controller   
 * @Description:    ActiveMq 与 Kafka 操作   
 * @author: wenjin.zhu    
 * @date:   2018年9月3日 下午1:56:31   
 * @version V1.0
 */
@Controller
@RequestMapping("/message")
public class MessageController {
	public static Logger logger = (Logger) LoggerFactory.getLogger(MessageController.class);

	@Resource(name = "urlQueueDestination")
	private Destination destination;

	// 队列消息生产者
	@Resource(name = "producerService")
	private ProducerService producer;

	// 队列消息消费者
	@Resource(name = "consumerService")
	private ConsumerService consumer;

	@RequestMapping("/aa")
	@ResponseBody
	public String aa() {
		producer.sendMessage("qwerrty00000");
		System.err.println("----aa-->");
		return "aa";
	}

	@RequestMapping(value = "/send")
	public void send(String msg) {
		logger.info(Thread.currentThread().getName() + "------------send to jms Start");
		producer.sendMessage(msg);
		logger.info(Thread.currentThread().getName() + "------------send to jms End");
	}

	@RequestMapping(value = "/ReceiveMessage", method = RequestMethod.GET)
	@ResponseBody
	public Object receive() {
		logger.info(Thread.currentThread().getName() + "------------receive from jms Start");
		TextMessage tm = consumer.receive(destination);
		logger.info(Thread.currentThread().getName() + "------------receive from jms End");
		return tm;
	}

	@RequestMapping("/KafkaProductor")
	public void kafkaProduct() {
		Properties properties = kafkaProducerInit();
		@SuppressWarnings("resource")
		Producer<String, String> producer = new KafkaProducer<String, String>(properties);
		try {
			for (int i = 0; i < 10000; i++) {
				producer.send(new ProducerRecord<String, String>("AmyTopic", "msg" + i));
				System.out.println("send AmyTopic" + i);
			}

		} catch (Exception e) {
			logger.info("AmyTopic--" + e.getMessage());
		}

	}

	@RequestMapping("/KafkaConsumer")
	public void kafkaConsumer() {
		Properties properties = kafkaConsumerInit();
		StringBuffer temp = new StringBuffer();
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
				temp.append(record.value());
			}
		}

	}

	public Properties kafkaProducerInit() {

		Properties properties = new Properties();
		// bootstrap.servers是Kafka集群的IP地址，如果Broker数量超过1个，则使用逗号分隔，
		// 172.16.53.23:9092,172.16.53.29:9092,172.16.53.30:9092
		properties.put("bootstrap.servers", "127.0.0.1:9092");
		properties.put("acks", "all");
		properties.put("retries", 0);
		properties.put("batch.size", 16384);
		properties.put("linger.ms", 1);
		properties.put("buffer.memory", 33554432);
		/**
		 * 序列化类型。 Kafka消息是以键值对的形式发送到Kafka集群的，其中Key是可选的，
		 * Value可以是任意类型。但是在Message被发送到Kafka集群之前，
		 * Producer需要把不同类型的消息序列化为二进制类型。这里是发送文本消息到Kafka集群，所以使用的是StringSerializer
		 */
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		return properties;
	}

	public Properties kafkaConsumerInit() {

		Properties properties = new Properties();
		// properties.put("bootstrap.servers",
		// "172.16.53.23:9092,172.16.53.29:9092,172.16.53.30:9092");
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

		return properties;
	}

}