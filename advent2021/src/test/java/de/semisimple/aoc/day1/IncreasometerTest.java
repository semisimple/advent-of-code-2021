package de.semisimple.aoc.day1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IncreasometerTest {

  private final Increasometer increasometer = new Increasometer();

  @Test
  public void nextInput_firstInput_createsNone() {
    final Change output = increasometer.nextInput(1);

    assertEquals(Change.NONE,output);
  }
  @Test
  public void nextInput_secondInputIncreased_createsIncrease() {
    final int input = 3;
    increasometer.nextInput(input);

    final Change output = increasometer.nextInput(input+1);

    assertEquals(Change.INCREASE,output);
  }
  @Test
  public void nextInput_secondInputDecreased_createsDecrease() {
    final int input = 5;
    increasometer.nextInput(input);

    final Change output = increasometer.nextInput(input-2);

    assertEquals(Change.DECREASE,output);
  }


}