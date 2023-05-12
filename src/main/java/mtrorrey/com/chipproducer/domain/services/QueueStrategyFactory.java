package mtrorrey.com.chipproducer.domain.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class QueueStrategyFactory {

  private Map<String, QueueStrategy> strategies;

  public QueueStrategyFactory(@Autowired List<QueueStrategy> strategyFactoryList){
    this.strategies=strategyFactoryList.stream().collect(Collectors.toMap(
       strategy-> strategy.getClass().getAnnotation(Qualifier.class).value(),
      strategy->strategy
    ));
  }

  public void sendMessage(String name,String message){
    QueueStrategy queueStrategy= this.strategies.get(name);
    queueStrategy.sendMessage(message);
  }

}
