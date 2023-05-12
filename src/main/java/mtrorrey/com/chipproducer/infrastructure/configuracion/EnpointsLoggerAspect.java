package mtrorrey.com.chipproducer.infrastructure.configuracion;

import mtrorrey.com.chipproducer.domain.util.EndpointLogger;
import mtrorrey.com.chipproducer.infrastructure.util.TimeStampUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class EnpointsLoggerAspect {


  private static final Logger LOGGER = LoggerFactory.getLogger(EnpointsLoggerAspect.class);



  @Around("@annotation(mtrorrey.com.chipproducer.domain.util.EndpointLogger)")
  public Object logMessage(ProceedingJoinPoint joinPoint) throws Throwable {
    String methodName = joinPoint.getSignature().getName();
    MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
    Method method = methodSignature.getMethod();
    EndpointLogger logger = method.getAnnotation(EndpointLogger.class);
    Object[] args = joinPoint.getArgs();
    LOGGER.info("[{}]  Send with message to endpoint {} with payload: {}", TimeStampUtil.dateLogger(), logger.endpointName(), args);
    return joinPoint.proceed();
  }
}
