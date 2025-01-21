package programmerzamannow.monitoring;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class CustomMeterRegistry {

  @Autowired
  private MeterRegistry meterRegistry;

  @Scheduled(fixedRate = 10L, timeUnit = TimeUnit.SECONDS)
  public void incrementCounter(){
    meterRegistry.counter("num_transactions").increment();
    meterRegistry.counter("num_success").increment();
    System.out.println("Increase Counter");
  }

  @Scheduled(fixedRate = 10L, timeUnit = TimeUnit.SECONDS)
  public void updateGauge(){
    int transactions = (int) (Math.random() * 1000);
    int successPercentage = 80 + (int) (Math.random() * 20);
    int successfulTransactions = (int) (transactions * successPercentage / 100.0);

    meterRegistry.gauge("gauge_transaction_num", transactions);
    meterRegistry.gauge("gauge_transaction_success", successfulTransactions);
    System.out.println("Update Gauge");
  }

  @Scheduled(fixedRate = 10L, timeUnit = TimeUnit.SECONDS)
  public void updateTimer(){
    meterRegistry.timer("timer_transaction").record(new Random().nextInt(1000), TimeUnit.MILLISECONDS);
    System.out.println("Update Timer");
  }
}
