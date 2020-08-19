package com.codurance;

import static com.codurance.Cell.CellState.ALIVE;
import static com.codurance.Cell.CellState.DEAD;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.codurance.Cell.CellState;
import org.junit.jupiter.api.Test;

public class UniverseShould {

  public static final CellState X = ALIVE;
  public static final CellState O = DEAD;

  @Test
  void store_initial_state() {
    CellState[][] input = {
        {X, O, X},
        {O, O, O},
        {O, X, X}
    };

    Universe universe = new Universe(input);

    CellState[][] result = universe.getState();

    assertArrayEquals(input, result);
  }
}
