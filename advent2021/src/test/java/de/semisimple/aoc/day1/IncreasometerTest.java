package de.semisimple.aoc.day1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IncreasometerTest {

  private final IncreaseIndicator increasometer = new IncreaseIndicator();

  @Test
  public void nextInput_firstInput_createsNone() {
    final Change output = increasometer.evaluate(1);

    assertEquals(Change.NONE,output);
  }
  @Test
  public void nextInput_secondInputIncreased_createsIncrease() {
    final int input = 3;
    increasometer.evaluate(input);

    final Change output = increasometer.evaluate(input+1);

    assertEquals(Change.INCREASE,output);
  }
  @Test
  public void nextInput_secondInputDecreased_createsDecrease() {
    final int input = 5;
    increasometer.evaluate(input);

    final Change output = increasometer.evaluate(input-2);

    assertEquals(Change.DECREASE,output);
  }


}