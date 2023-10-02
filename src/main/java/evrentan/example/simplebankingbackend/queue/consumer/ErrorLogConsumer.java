package evrentan.example.simplebankingbackend.queue.consumer;

import evrentan.example.simplebankingbackend.constant.ErrorLogQueue;
import evrentan.example.simplebankingbackend.dto.model.ErrorLog;
import evrentan.example.simplebankingbackend.mapper.ErrorLogMapper;
import evrentan.example.simplebankingbackend.repository.ErrorLogRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ErrorLogConsumer {

    private final ErrorLogRepository errorLogRepository;

    public ErrorLogConsumer(ErrorLogRepository errorLogRepository) {
        this.errorLogRepository = errorLogRepository;
    }

    @RabbitListener(queues = {ErrorLogQueue.ERROR_LOG_QUEUE_NAME}, containerFactory = "rabbitListenerContainerFactory")
    public void consumeErrorLog(@Payload ErrorLog errorLog){
        this.errorLogRepository.save(ErrorLogMapper.toEntity(errorLog));
    }
}
