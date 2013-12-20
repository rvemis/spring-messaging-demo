package com.digiburo.spring.demo.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Write a JMS message for MessageListener
 */
public class MessageDriver {

  /**
   * Write a message for MessageListener
   */
  private void execute() {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext(CONTEXT_NAME);

    MessageWriter messageWriter = (MessageWriter) applicationContext.getBean("messageWriter");
    messageWriter.writePayload(new MessagePayload("test payload"));
  }

  /**
   * test log settings
   */
  private void logTest() {
    LOGGER.debug("debug message");
    LOGGER.error("error message");
    LOGGER.info("info message");
    LOGGER.trace("trace message");
    LOGGER.warn("warning message");
  }

  public static void main(String[] args) {
    System.out.println("begin");

    MessageDriver dw = new MessageDriver();
    dw.logTest();
    dw.execute();

    System.out.println("end");
  }

  //
  public static final String CONTEXT_NAME = "message-configuration.xml";

  //
  public static final Logger LOGGER = LoggerFactory.getLogger(MessageDriver.class);
}