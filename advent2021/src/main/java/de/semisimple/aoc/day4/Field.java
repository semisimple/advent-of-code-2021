package de.semisimple.aoc.day4;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Field {

  private final int value;
  private final int row;
  private final int col;

  private boolean flagged;

}
