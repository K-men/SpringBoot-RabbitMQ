package mq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 特别说明：如果在配置文件中声明了 Queue 对象，就不用在控制台创建队列了
 * Created by wch on 17/12/12.
 */
@Configuration
public class MqConfig {
    /**
     * 声明接收字符串的队列
     *
     * @return
     */
    @Bean
    public Queue stringQueue() {
        return new Queue("my-queue");
    }

    /**
     * 声明接收 User 对象的队列
     *
     * @return
     */
    @Bean
    public Queue userQueue() {
        return new Queue("my-user");
    }
}
