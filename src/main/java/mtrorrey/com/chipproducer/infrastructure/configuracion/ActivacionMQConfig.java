package mtrorrey.com.chipproducer.infrastructure.configuracion;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class ActivacionMQConfig {

  @Value("${spring.rabbitmq.queue_activation.name}")
  private String queue;


  @Value("${spring.rabbitmq.exchange.name}")
  private String exchange;

  @Value("${spring.rabbitmq.queue_activation.routing.key}")
  private String routingKey;

  @Bean
  public Queue queueActivation() {
    Map<String, Object> args = new HashMap<>();
 //   args.put("x-dead-letter-exchange", "metrorrey_dead-letter-exchange"); // Exchange para enviar mensajes muertos
  //  args.put("x-dead-letter-routing-key", "activacion_dead-letter-routing-key"); // Key para enviar mensajes muertos
    args.put("x-message-ttl", 60000); // Tiempo de vida de los mensajes en la cola (en milisegundos)
    args.put("x-max-retries", 3); // Número máximo de reintentos
    return new Queue(queue, true, false, false, args);
  }

  @Bean
  public TopicExchange exchangeActivation(){
    return new TopicExchange(exchange);
  }


  @Bean
  public Binding bindingActivation(){
    return BindingBuilder.bind(queueActivation())
      .to(exchangeActivation())
      .with(routingKey);
  }




}
