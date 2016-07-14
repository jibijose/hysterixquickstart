package com.jibi.hysterix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonUtil {
  
  private static Logger LOGGER = LoggerFactory.getLogger(CommonUtil.class);

  public static void sleep(long milliSeconds) {
    try {
      LOGGER.debug("Sleeping {}", milliSeconds);
      Thread.sleep(milliSeconds);
      LOGGER.debug("Slept {}", milliSeconds);
    } catch (InterruptedException ie) {
      //ie.printStackTrace();
      LOGGER.debug("Sleep {} is interrupted with message {}", milliSeconds, ie.getMessage());
    }
  }
}
