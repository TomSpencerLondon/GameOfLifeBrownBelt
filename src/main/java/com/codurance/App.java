package com.codurance;

import static com.codurance.Cell.CellState.ALIVE;
import static com.codurance.Cell.CellState.DEAD;

import com.codurance.Cell.CellState;

public class App {
  public static final CellState X = ALIVE;
  public static final CellState O = DEAD;

  public static void main(String[] args) {
    CellState [][] cellState = {
        {O, O, O, O, O, O},
        {O, O, O, O, O, O},
        {O, O, X, X, X, O},
        {O, X, X, X, O, O},
        {O, O, O, O, O, O},
        {O, O, O, O, O, O}
    };
    Universe universe = new Universe(cellState);

    for (int i = 0; i < 20; i++) {
      universe.update();
      CellState[][] nextWorld = universe.getState();
      new BoardFormatter(nextWorld).invoke();
    }
  }
}
