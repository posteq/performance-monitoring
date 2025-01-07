package by.clevertec.config;

import by.clevertec.aspect.PerformanceMonitorAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(PerformanceMonitorProperties.class)
@ConditionalOnProperty(prefix = "monitor.performance", name = "enabled", havingValue = "true", matchIfMissing = true)
public class PerformanceMonitorAutoConfiguration {

    @Bean
    public PerformanceMonitorAspect performanceMonitorAspect(PerformanceMonitorProperties properties) {
        return new PerformanceMonitorAspect(properties);
    }
}
