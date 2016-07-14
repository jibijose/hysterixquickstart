package com.jibi.hysterix;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.jibi.hysterix.command.HelloWorldCommand;
import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandMetrics;
import com.netflix.hystrix.HystrixRequestLog;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.netflix.hystrix.util.HystrixRollingNumberEvent;

public class RunMeTest {

  @Test
  public void should_execute_fallback_method_when_circuit_is_open() {
    
    // Initialize HystrixRequestContext to be able to get some metrics
    HystrixRequestContext context = HystrixRequestContext.initializeContext();
    
    
 // We use Archaius to set the circuit as closed.
    ConfigurationManager.getConfigInstance()
        .setProperty("hystrix.command.default.circuitBreaker.forceOpen", false);
    String successMessage = new HelloWorldCommand().execute();
    assertThat(successMessage, is("Hello World"));


    HystrixCommandMetrics creditCardMetrics = HystrixCommandMetrics
        .getInstance(HystrixCommandKey.Factory.asKey(HelloWorldCommand.class.getSimpleName()));

    

    // We use Archaius to open the circuit
    ConfigurationManager.getConfigInstance()
        .setProperty("hystrix.command.default.circuitBreaker.forceOpen", true);

    String failMessage = new HelloWorldCommand().execute();
    assertThat(failMessage, is("Good Bye"));

    // Prints Request => HelloWorldRestCommand[SUCCESS][19ms],
    // HelloWorldRestCommand[SHORT_CIRCUITED, FALLBACK_SUCCESS][0ms]
    System.out.println(
        "Request => " + HystrixRequestLog.getCurrentRequest().getExecutedCommandsAsString());

//    assertThat(creditCardMetrics.getCumulativeCount(HystrixRollingNumberEvent.FAILURE), is(1));
//    
//    assertThat(creditCardMetrics.getHealthCounts().getTotalRequests(), is(2));
//    assertThat(creditCardMetrics.getHealthCounts().getErrorCount(), is(1));

  }
}
