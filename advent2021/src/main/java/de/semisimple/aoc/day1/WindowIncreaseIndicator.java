package de.semisimple.aoc.day1;

public class WindowIncreaseIndicator implements IncreaseMeasure {

  private final IncreaseIndicator increasometer = new IncreaseIndicator();
  private Window lastWindow = new Window(null,null,null);

  public Change evaluate(int input){
    final Window next = lastWindow.next(input);
    setLastWindow(next);
    if(next.isUsable()) {
      return increasometer.evaluate(next.sum());
    }else {
      return Change.NONE;
    }
  }

  public void setLastWindow(Window lastWindow) {
    this.lastWindow = lastWindow;
  }
}
