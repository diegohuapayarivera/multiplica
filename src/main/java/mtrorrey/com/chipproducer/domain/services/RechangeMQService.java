package mtrorrey.com.chipproducer.domain.services;
import mtrorrey.com.chipproducer.domain.util.LoggerTopic;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Qualifier("rechange")
public class RechangeMQService implements QueueStrategy{


  @Value("${spring.rabbitmq.queue_rechange.name}")
  private String queue;


  @Value("${spring.rabbitmq.exchange.name}")
  private String exchange;

  @Value("${spring.rabbitmq.queue_rechange.routing.key}")
  private String routingKey;

  @Autowired
  private RabbitTemplate rabbitTemplate;


  @LoggerTopic(topicName="rechangeMQ")
  public void sendMessage(String message){
    rabbitTemplate.convertAndSend(exchange,routingKey, message);
  }


}