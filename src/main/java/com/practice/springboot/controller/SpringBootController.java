package com.practice.springboot.controller;

import com.practice.springboot.model.SpringBootModelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for SpringBootModel class for REST API calls
 */
@RestController
public class SpringBootController
{
  private SpringBootModelService serviceModel = new SpringBootModelService();
  private String clientMessage;

  /**
   * POST a string message on the SpringBootServiceModel class
   *
   * @param inputMessage takes a string message from URL request body
   * @return the message received in POST call
   */
  @PostMapping("/postWelcomeMessage")
  public String postMessage(@RequestBody String inputMessage)
  {
    this.clientMessage = inputMessage;
    serviceModel.addMessage(clientMessage);
    return clientMessage;
  }

  /**
   * GET the message posted on server
   *
   * @return the message received from GET call
   */
  @GetMapping("/getWelcomeMessage")
  public String getMessage()
  {
    return serviceModel.getMessage();
  }

}
