import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.support.ClassPathXmlApplicationContext
import utils.KafkaConfiguration
import utils.MessageController
@SpringBootApplication
class MyApplication{
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<KafkaConfiguration>()
            val context= ClassPathXmlApplicationContext("applicationContext.xml")
            val messageController = context.getBean("messageController", MessageController::class.java)
            messageController.sendMessage("123")
            context.close()
        }
    }
}

