package mq.listener;

import mq.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by wch on 17/3/12.
 */
@Component
public class Receiver {

    @RabbitListener(queues = "my-queue")
    public void receiveMessage(String message){
        System.out.println("接收到的字符串消息是 => " + message);
    }


    @RabbitListener(queues = "my-user")
    public void receiveObject(User user){
        System.out.println("------ 接收实体对象 ------");
        System.out.println("接收到的实体对象是 => " + user);
    }
}
