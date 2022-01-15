package de.semisimple.aoc.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class BoardTest {

  @Test
  void getWinningField_winningRowAndNotPresentField_lastFieldReturns() {
    final Board board = Board.parse(new String[]{
        "50 83  3 31 16",
        "47  9 94 10 86",
        "61 22 53 46 74",
        "77 41 79 55 62",
        "97 78 43 73 40"});

    board.flagIfPresent(22);
    board.flagIfPresent(61);
    board.flagIfPresent(46);
    board.flagIfPresent(74);
    board.flagIfPresent(53);
    board.flagIfPresent(1);

    final Field winningField = board.getWinningField();
    assertEquals(53, winningField.getValue());
    assertEquals(2, winningField.getRow());
    assertEquals(2, winningField.getCol());

  }

  @Test
  void calculateScore_winningRowAndNotPresentField_CorrectScore() {
    final Board board = Board.parse(new String[]{
        "50 83  3 31 16",
        "47  9 94 10 86",
        "61 22 53 46 74",
        "77 41 79 55 62",
        "97 78 43 73 40"});

    board.flagIfPresent(50);
    board.flagIfPresent(83);
    board.flagIfPresent(22);
    board.flagIfPresent(61);
    board.flagIfPresent(46);
    board.flagIfPresent(74);
    board.flagIfPresent(53);
    board.flagIfPresent(1);

    final int sumNonFlagged = IntStream.of(
        3, 31, 16,
        47, 9, 94, 10, 86,
        77, 41, 79, 55, 62,
        97, 78, 43, 73, 40).sum();
    assertEquals(sumNonFlagged * 53, board.calculateScore());

  }
}