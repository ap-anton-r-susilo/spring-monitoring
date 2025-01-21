package programmerzamannow.monitoring;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class CustomMetricsService {

    private final Counter customMetricCounter;

    public CustomMetricsService(MeterRegistry meterRegistry) {
        customMetricCounter = Counter.builder("custom_metric_name")
                .description("Penjelasan dari Metrics")
                .baseUnit("jumlah")
                .tags("environment", "development", "data", "fake")
                .register(meterRegistry);
    }

    public void incrementCustomMetric() {
        customMetricCounter.increment();
    }

    @Scheduled(fixedRate = 10L, timeUnit = TimeUnit.SECONDS)
    public void scheduledIncrementCustomMetric() {
        customMetricCounter.increment();
    }
}