package com.jibi.hysterix;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jibi.hysterix.command.HelloWorldCommand;

import rx.Observable;

public class RunMe {

  private static Logger LOGGER = LoggerFactory.getLogger(RunMe.class);

  public static void main(String[] args) throws Exception {

    String executionResult = new HelloWorldCommand().execute();
    LOGGER.debug(executionResult);

//    Future<String> helloWorldResult = new HelloWorldCommand().queue();
//    String message = helloWorldResult.get();
//    LOGGER.debug(message);

//    Observable<String> observable = new HelloWorldCommand().observe();
//    CommonUtil.sleep(5000);
//    observable.subscribe((msg) -> {
//      LOGGER.debug(msg);
//    });
//    CommonUtil.sleep(5000);
    
    
//    Observable<String> toObservable = new HelloWorldCommand().toObservable();
//    toObservable.subscribe();
//    CommonUtil.sleep(10000);
//    toObservable.subscribe((msg) -> {
//      LOGGER.debug(msg);
//    });
  }

}
