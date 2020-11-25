package com.vargas.PracticaJMSSensors;

import java.time.LocalDateTime;
import java.util.Random;

import javax.jms.Connection;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SendMessage {
	
	private static final Logger log = LoggerFactory.getLogger(SendMessage.class);
	
	@Autowired
	private Environment env;

	@Scheduled(fixedRate = 1000)
	public void send() {
		try {
			ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://webbroker:61616");
	        Connection connection = factory.createConnection("root","1234");
	        connection.start();
	
	        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	
	        Topic topic = session.createTopic("sensors_reports");
	        MessageProducer producer = session.createProducer(topic);
	
	        Message msg = new Message();
	        msg.setIdDevice(Integer.parseInt(env.getProperty("sensor.id")));
	        msg.setCreated_at(LocalDateTime.now());
	        
	        Random r = new Random();
	        msg.setHumidity(1 + r.nextFloat() * (100 - 1));
	        msg.setTemperature(1 + r.nextFloat() * (100 - 1));
	        
	        
	        log.info("Enviando Mensaje...");
	
	        TextMessage message = session.createTextMessage(msg.getJson());
	        producer.send(message);
	
	        producer.close();
	        session.close();
	        connection.stop();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
