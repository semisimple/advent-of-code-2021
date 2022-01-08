package de.semisimple.aoc.day1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WindowIncreaseIndicatorTest {

  WindowIncreaseIndicator windowIncreaseIndicator = new WindowIncreaseIndicator();

  @Test
  void evaluate_windowTooSmall_returnsNone() {
    final Change result0 = windowIncreaseIndicator.evaluate(1);
    final Change result1 = windowIncreaseIndicator.evaluate(2);

    assertEquals(        Change.NONE, result0);
    assertEquals(        Change.NONE, result1);
  }
  @Test
  void evaluate_firstWindow_returnsNone() {
    windowIncreaseIndicator.evaluate(2);
    windowIncreaseIndicator.evaluate(1);
    final Change result = windowIncreaseIndicator.evaluate(1);

    assertEquals(        Change.NONE, result);
  }
  @Test
  void evaluate_secondWindowGreater_returnsIncrease() {
    windowIncreaseIndicator.evaluate(2);
    windowIncreaseIndicator.evaluate(1);
    windowIncreaseIndicator.evaluate(1);

    final Change result = windowIncreaseIndicator.evaluate(3);

    assertEquals(        Change.INCREASE, result);
  }
  @Test
  void evaluate_secondWindowSmaller_returnsDecrease() {
    windowIncreaseIndicator.evaluate(2);
    windowIncreaseIndicator.evaluate(1);
    windowIncreaseIndicator.evaluate(1);

    final Change result = windowIncreaseIndicator.evaluate(1);

    assertEquals(        Change.DECREASE, result);
  }
  @Test
  void evaluate_secondWindowEqual_returnsNone() {
    windowIncreaseIndicator.evaluate(2);
    windowIncreaseIndicator.evaluate(1);
    windowIncreaseIndicator.evaluate(1);

    final Change result = windowIncreaseIndicator.evaluate(2);

    assertEquals(        Change.NONE, result);
  }
}