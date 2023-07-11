import org.springframework.context.support.ClassPathXmlApplicationContext
import utils.MessageController

class MyApplication{
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val context= ClassPathXmlApplicationContext("applicationContext.xml")
            context.getBean("messageController", MessageController::class.java).sendMessage("123")
            context.close()
        }
    }
}

