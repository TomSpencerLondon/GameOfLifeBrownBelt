package com.codurance;

import static com.codurance.Cell.CellState.ALIVE;
import static com.codurance.Cell.CellState.DEAD;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

  @Test
  void update_cells() {
    Universe universe = new Universe(new CellState[][]{{X}});

    universe.update();

    CellState[][] result = universe.getState();
    assertEquals(DEAD, result[0][0]);
  }

  @Test
  void update_several_cells() {
    Universe universe = new Universe(new CellState[][]{
        {O, X, X},
        {X, O, X},
        {O, O, X},
    });

    CellState[][] expected = new CellState[][] {
        {O, X, X},
        {O, O, X},
        {O, X, O}
    };

    universe.update();

    CellState[][] result = universe.getState();
    assertArrayEquals(expected, result);
  }
}
