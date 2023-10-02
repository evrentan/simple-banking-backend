package evrentan.example.simplebankingbackend.queue.producer;

import evrentan.example.simplebankingbackend.constant.ErrorLogQueue;
import evrentan.example.simplebankingbackend.dto.model.ErrorLog;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class ErrorLogProducer {

    private final RabbitTemplate rabbitTemplate;

    public ErrorLogProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendErrorLog(ErrorLog errorLog){
        this.rabbitTemplate.convertAndSend(ErrorLogQueue.ERROR_LOG_QUEUE_NAME, errorLog);
    }
}
