package mtrorrey.com.chipproducer.infrastructure.configuracion;

import mtrorrey.com.chipproducer.domain.util.LoggerTopic;
import mtrorrey.com.chipproducer.infrastructure.util.TimeStampUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class RabbitMqLoggingAspect {

  private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqLoggingAspect.class);

  @Around("@annotation(mtrorrey.com.chipproducer.domain.util.LoggerTopic)")
  public Object logMessage(ProceedingJoinPoint joinPoint) throws Throwable {
    String methodName = joinPoint.getSignature().getName();
    MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
    Method method = methodSignature.getMethod();
    LoggerTopic logger = method.getAnnotation(LoggerTopic.class);

    Object[] args = joinPoint.getArgs();
    LOGGER.info("[{}]  Sending message to topic {} with message: {}", TimeStampUtil.dateLogger(), logger.topicName(), args);
    return joinPoint.proceed();
  }


}
