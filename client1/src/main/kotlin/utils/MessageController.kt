package utils

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component("messageController")
class MessageController() {

    @Autowired
    lateinit var kafkaTemplate: KafkaTemplate<String, String>

    fun sendMessage(message: String){
        kafkaTemplate.send("123", message)
    }
}