package cloud.nativ.nerd;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component(value = "readinessCheck")
public class AppCDSReadinessProbe implements HealthIndicator {
    @Override
    public Health health() {
        return Health.up().withDetail("readiness", true).build();
    }
}
