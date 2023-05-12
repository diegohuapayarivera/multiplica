package mtrorrey.com.chipproducer.infrastructure.configuracion;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class ResilienceConfig {
  @Bean
  public CircuitBreaker circuitBreaker() {
    CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
      .failureRateThreshold(50)
      .waitDurationInOpenState(Duration.ofMillis(1000))
      .build();

    return CircuitBreaker.of("metrorreyCircuitBreaker", circuitBreakerConfig);
  }
}
