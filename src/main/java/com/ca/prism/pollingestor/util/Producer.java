package com.ca.prism.pollingestor.util;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.io.IOException;
import java.util.Properties;

public class Producer {

    private static KafkaProducer<String, String> producer;
    private final static String brokers = "localhost:9092";

    public Producer() {
        // Set properties used to configure the producer
        Properties properties = new Properties();
        // Set the brokers (bootstrap servers)
        properties.setProperty("bootstrap.servers", brokers);
        // Set how to serialize key/value pairs
        properties.setProperty("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        if(producer == null) {
            producer = new KafkaProducer<>(properties);
        }


    }
    public static void postKafkaMessage(String topic, String message) throws IOException {
        producer.send(new ProducerRecord<String, String>(topic, message));
    }
}