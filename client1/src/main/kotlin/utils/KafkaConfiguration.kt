package utils

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.boot.SpringBootConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

@SpringBootConfiguration
open class KafkaConfiguration {

    @Bean
    open fun producerFactory(): ProducerFactory<String, String>{
        val configProps= HashMap<String, Any>()
        configProps[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG]="localhost:8000"
        configProps[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG]=StringSerializer::class.java
        configProps[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG]=StringSerializer::class.java
        return DefaultKafkaProducerFactory(configProps)
    }

    @Bean
    open fun kafkaTemplate(): KafkaTemplate<String, String>{
        return KafkaTemplate(producerFactory())
    }

}