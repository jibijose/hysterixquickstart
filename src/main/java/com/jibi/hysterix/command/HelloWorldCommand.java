package com.jibi.hysterix.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class HelloWorldCommand extends HystrixCommand<String> {

  public HelloWorldCommand() {
    super(HystrixCommandGroupKey.Factory.asKey("HelloWorld"));
  }

  @Override
  protected String run() throws Exception {
    return "Hello World";
  }

}
