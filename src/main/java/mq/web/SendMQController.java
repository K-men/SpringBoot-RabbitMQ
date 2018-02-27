package mq.web;

import mq.model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用于测试的控制类
 * Created by wch on 17/12/12.
 */
@RestController
public class SendMQController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * http://localhost:8080/send?message=hello
     *
     * @param message
     * @return
     */
    @RequestMapping("/send")
    public String sendMQ(String message) {
        rabbitTemplate.convertAndSend("my-queue", message);
        return "ok";
    }

    /**
     * http://localhost:8080/send/user
     *
     * @return
     */
    @RequestMapping("/send/user")
    public String sendUser() {
        User user = new User();
        user.setId(1);
        user.setUsername("wangchunhui");
        user.setPassword("123456");
        rabbitTemplate.convertAndSend("my-user", user);
        return "OK";
    }

}
