package com.practice.springboot.model;

import lombok.Data;

/**
 * Service class for SpringBootModel.java
 * receives and shows message from POST and GET call
 */
public @Data class SpringBootModelService
{
  private String message;
  SpringBootModel model = new SpringBootModel();
  private boolean status;

  /**
   * Receives message sent from POST call
   *
   * @param message string to save message received
   */
  public void addMessage(String message)
  {
    if (message == "")
    {
      throw new IllegalArgumentException();
    }
    this.message = message;
    model.setMessage(message);
    this.status = true;
  }

  /**
   * Returns message received from POST call in GET call
   *
   * @return returns message string
   */
  public String getMessage()
  {
    return message;
  }

}
