package com.mvcflow.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/v1/test")
public class TestContronller {

  private final static Logger logger = LoggerFactory.getLogger(TestContronller.class);

  @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
  @ResponseBody
  public String init() {
    logger.info("-----init------");
    System.out.println("-----------------------------");
    return "ok";
  }
}
