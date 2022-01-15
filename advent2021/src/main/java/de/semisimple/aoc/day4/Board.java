package de.semisimple.aoc.day4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Board {

  final Map<Integer, Field> valueToField;
  final Map<String, Set<Field>> flaggedRows = new HashMap<>();
  final Map<String, Set<Field>> flaggedColls = new HashMap<>();
  private static final int FIELD_SIZE = 5;
  public static final Predicate<Set<Field>> WINNING = it -> FIELD_SIZE == it.size();

  private boolean hasWon = false;
  private Integer lastFlag;

  public static Board parse(String[] rows) {
    final HashMap<Integer, Field> valueToField = new HashMap<>();
    for (int i = 0; i < rows.length; i++) {
      final String[] vals = rows[i].trim().replaceAll("  ", " ").split(" ");
      for (int j = 0; j < vals.length; j++) {
        final int value = Integer.parseInt(vals[j]);
        final Field field = new Field(value, i, j);

        valueToField.merge(value, field, (v1, v2) -> {
          throw new IllegalStateException("Multiple values in Board!: " + v1 + v2);
        });
      }
    }

    return new Board(valueToField);
  }

  public Board flagIfPresent(Integer value) {
    final Field field = valueToField.get(value);
    if (field != null && !hasWon) {
      flag(field);
      this.lastFlag = value;
    }
    return this;
  }

  private void flag(Field field) {
    field.setFlagged(true);
    final HashSet<Field> set = new HashSet<>();
    set.add(field);

    final String key1 = "" + field.getRow();
    flaggedRows.merge(key1, set,
        (v1, v0) -> {
          final HashSet<Field> objects = new HashSet<>();
          objects.addAll(v1);
          objects.addAll(v0);
          return objects;
        });

    final String key = "" + field.getCol();
    flaggedColls.merge(key, set,
        (v1, v0) -> {
          final HashSet<Field> objects = new HashSet<>();
          objects.addAll(v1);
          objects.addAll(v0);
          return objects;
        });
  }

  public boolean hasWon() {
    if (hasWon) {
      return hasWon;
    } else {
      final boolean hasRowWon = flaggedRows.values().stream().anyMatch(WINNING);
      final boolean hasColWon = flaggedColls.values().stream().anyMatch(WINNING);
      this.hasWon = hasRowWon || hasColWon;
      return this.hasWon;
    }
  }

  public Field getWinningField() {
    return valueToField.get(lastFlag);
  }

  public int calculateScore() {
    final int sum = valueToField.values().stream()
        .filter(Predicate.not(Field::isFlagged))
        .mapToInt(Field::getValue)
        .sum();

    return lastFlag * sum;
  }
}
