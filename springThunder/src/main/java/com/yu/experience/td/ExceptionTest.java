package com.yu.experience.td;

public class ExceptionTest extends Exception {

  private static final long serialVersionUID = 1L;

  public ExceptionTest() {
    super();
  }

  public ExceptionTest(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public ExceptionTest(String message, Throwable cause) {
    super(message, cause);
  }

  public ExceptionTest(String message) {
    super(message);
  }

  public ExceptionTest(Throwable cause) {
    super(cause);
  }

}
