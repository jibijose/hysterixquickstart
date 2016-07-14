package com.jibi.hysterix.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jibi.hysterix.CommonUtil;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class HelloWorldCommand extends HystrixCommand<String> {

  private static Logger LOGGER = LoggerFactory.getLogger(HelloWorldCommand.class);

  public HelloWorldCommand() {
    super(HystrixCommandGroupKey.Factory.asKey("HelloWorld"), 10000);
    LOGGER.debug("HelloWorldCommand constructed");
  }

  @Override
  protected String run() throws Exception {
    LOGGER.debug("Run invoked");
     CommonUtil.sleep(15000);
     LOGGER.debug("Run returning");
     return "Hello World";

//    CommonUtil.sleep(15000);
//    LOGGER.debug("Throwing IllegalArgumentException");
//    throw new IllegalArgumentException();
  }

  @Override
  protected String getFallback() {
    LOGGER.debug("Fallback invoked");
    CommonUtil.sleep(15000);
    LOGGER.debug("Fallback returning");
    return "Good Bye";
  }

}
