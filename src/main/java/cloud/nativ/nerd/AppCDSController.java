package cloud.nativ.nerd;

import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@RestController
public class AppCDSController {

    @Value(value = "${sleep.bound:250}")
    private int sleepBound;

    @Value(value = "${appcds.enabled:false}")
    private boolean appcdsEnabled;

    @GetMapping("/api/appcds")
    @Timed
    public Map<String, Object> getAppCDS() {
        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextLong(sleepBound));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return Collections.singletonMap("appcds.enabled", appcdsEnabled);
    }

}
