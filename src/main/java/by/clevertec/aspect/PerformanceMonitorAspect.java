package by.clevertec.aspect;

import by.clevertec.config.PerformanceMonitorProperties;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class PerformanceMonitorAspect {

    private final Logger logger = Logger.getLogger(PerformanceMonitorAspect.class.getName());
    private final PerformanceMonitorProperties  properties;

    public PerformanceMonitorAspect(PerformanceMonitorProperties properties) {
        this.properties = properties;
    }

    @Around("@annotation(by.clevertec.annotation.MonitorPerformance)")
    public Object lohExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        if(!properties.isEnabled()){
            return joinPoint.proceed();
        }

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        if(executionTime >= properties.getTimeThreshold()){
            String methodName = joinPoint.getSignature().toLongString();
            logger.info(String.format("Method [%s] executed in [%d] ms", methodName, executionTime));
            System.out.printf("Method [%s] executed in [%d] ms.%n", methodName, executionTime);
        }

        return result;
    }
}
