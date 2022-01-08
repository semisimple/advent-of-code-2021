package de.semisimple.aoc.day1;

public class IncreaseIndicator implements IncreaseMeasure {

  private Integer lastInput;

  @Override
  public Change evaluate(int measurement) {
    Change result;
    if (lastInput == null) {
      setLastInput(measurement);
      result = Change.NONE;
    } else {
      result = compareLastInputTo(measurement);
    }
    setLastInput(measurement);
    return result;
  }

  private Change compareLastInputTo(int measurement) {
    final int i = lastInput - measurement;
    Change output;
    if(i==0) {
      output = Change.NONE;
    }else if(i<0) {
      output = Change.INCREASE;
    }else {
      output = Change.DECREASE;
    }
    return output;
  }

  private void setLastInput(Integer measurement) {
    this.lastInput = measurement;
  }

}
