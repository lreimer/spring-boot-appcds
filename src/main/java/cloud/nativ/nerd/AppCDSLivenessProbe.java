package cloud.nativ.nerd;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component(value = "livenessCheck")
public class AppCDSLivenessProbe implements HealthIndicator {
    @Override
    public Health health() {
        return Health.up().withDetail("liveness", true).build();
    }
}
