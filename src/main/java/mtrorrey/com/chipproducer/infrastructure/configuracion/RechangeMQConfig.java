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
public class RechangeMQConfig {
  @Value("${spring.rabbitmq.queue_rechange.name}")
  private String queue;

  @Value("${spring.rabbitmq.exchange.name}")
  private String exchange;

  @Value("${spring.rabbitmq.queue_rechange.routing.key}")
  private String routingKey;

  @Bean
  public Queue queueRechange() {
    Map<String, Object> args = new HashMap<>();
    args.put("x-message-ttl", 60000); // Tiempo de vida de los mensajes en la cola (en milisegundos)
    args.put("x-max-retries", 3); // Número máximo de reintentos
    return new Queue(queue, true, false, false, args);
  }

  @Bean
  public TopicExchange exchangeRechange(){
    return new TopicExchange(exchange);
  }


  @Bean
  public Binding bindingRechange(){
    return BindingBuilder.bind(queueRechange())
      .to(exchangeRechange())
      .with(routingKey);
  }
}
