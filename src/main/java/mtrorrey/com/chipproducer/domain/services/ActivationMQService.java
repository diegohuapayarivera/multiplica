package mtrorrey.com.chipproducer.domain.services;
import mtrorrey.com.chipproducer.domain.util.LoggerTopic;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Qualifier("activation")
public class ActivationMQService implements QueueStrategy{


  @Value("${spring.rabbitmq.queue_activation.name}")
  private String queue;


  @Value("${spring.rabbitmq.exchange.name}")
  private String exchange;

  @Value("${spring.rabbitmq.queue_activation.routing.key}")
  private String routingKey;

  @Autowired
  private RabbitTemplate rabbitTemplate;


  @LoggerTopic(topicName="activationMQ")
  public void sendMessage(String message){
    rabbitTemplate.convertAndSend(exchange,routingKey, message);
  }


}