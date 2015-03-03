package com.carrotsearch.debug;

import java.awt.AWTEvent;
import java.awt.event.PaintEvent;

import com.google.common.base.Throwables;

public class EventQueue extends java.awt.EventQueue {
  @Override
  public void push(java.awt.EventQueue newEventQueue) {
    super.push(newEventQueue);
    System.out.println("push()");
  }
  
  @Override
  public void postEvent(AWTEvent theEvent) {
    System.out.println("postEvent: " + theEvent);
    super.postEvent(theEvent);
  }
  
  @Override
  protected void dispatchEvent(AWTEvent event) {
    System.out.println("dispatchEvent: " + event);
    if (event instanceof PaintEvent) {
      Exception e = new Exception();
      e.fillInStackTrace();
      System.out.println(Throwables.getStackTraceAsString(e));
    }
    super.dispatchEvent(event);
  }
}
