package utils

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody


class MessageController(workKafkaTemplate: KafkaTemplate<String, String>) {

    val kafkaTemplate: KafkaTemplate<String, String>

    init {
        kafkaTemplate=workKafkaTemplate
    }

    @PostMapping("/messages")
    fun sendMessage(@RequestBody message:String){
        kafkaTemplate.send("123", message)
    }
}