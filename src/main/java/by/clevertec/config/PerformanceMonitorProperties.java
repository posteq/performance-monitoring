package by.clevertec.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "monitor.performance")
public class PerformanceMonitorProperties {
    private boolean enabled;
    private long timeThreshold;
}
