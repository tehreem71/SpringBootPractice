package com.practice.springboot.model;

import org.mockito.Mock;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpringBootModelServiceTest
{
  private SpringBootModelServiceTest.Fixture fixture = new SpringBootModelServiceTest.Fixture();

  @Test
  public void testPostMessage_postsMessage()
  {
    fixture.givenMessageIsEntered("This is a test message");
    fixture.whenMessageIsPosted();
    fixture.thenMessagePostedStatusReturns(true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPostMessage_messageIsEmpty_doesNotPostMessage_ThrowsException()
  {
    fixture.givenMessageIsEntered("");
    fixture.whenMessageIsPosted(); //when
    fixture.thenMessagePostedStatusReturns(false); //then
    fixture.thenServiceModelThrewIllegalArgumentException();
  }

  @Test
  public void testGetMessage_getsMessage()
  {
    fixture.givenMessageIsEntered("This is a test message");
    fixture.whenMessageIsPosted();
    fixture.thenMessagePostedAndReceivedAreSame("This is a test message");
  }

  private class Fixture
  {
    @Mock SpringBootModelService serviceModel = new SpringBootModelService();
    @Mock
    private String mockedMessage;
    private Exception exception = new Exception();

    public void givenMessageIsEntered(String testMessage)
    {
      this.mockedMessage = testMessage;
    }

    public void whenMessageIsPosted()
    {
      try
      {
        this.serviceModel.addMessage(mockedMessage);
      }
      catch (IllegalArgumentException e)
      {
        this.exception = e;
      }

    }

    public void thenMessagePostedStatusReturns(boolean check)
    {
      boolean expectedStatus = check;
      assertEquals(check, serviceModel.isStatus()); //then
    }

    public void thenServiceModelThrewIllegalArgumentException()
    {
      assertEquals(IllegalArgumentException.class, exception.getClass());    //check if exception thrown is same as given
      throw new IllegalArgumentException();
    }

    public void thenMessagePostedAndReceivedAreSame(String postedMessage)
    {
      assertEquals(postedMessage, this.serviceModel.getMessage());
    }
  }
}