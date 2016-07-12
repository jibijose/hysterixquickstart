package com.jibi.hysterix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jibi.hysterix.command.HelloWorldCommand;

public class RunMe {
  
  private static Logger LOGGER = LoggerFactory.getLogger(RunMe.class);

  public static void main(String[] args) {
    HelloWorldCommand helloWorldCommand = new HelloWorldCommand();
    
    String executionResult = helloWorldCommand.execute();
    LOGGER.debug(executionResult);
  }

}
