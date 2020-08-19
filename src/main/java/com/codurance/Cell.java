package com.codurance;

import static com.codurance.Cell.CellState.ALIVE;
import static com.codurance.Cell.CellState.DEAD;

public class Cell {

  private final CellState state;

  public enum CellState {
    ALIVE,
    DEAD
  }

  public Cell(CellState state) {
    this.state = state;
  }

  public CellState getNextState(int neighbours) {
    return neighbours > 1 && neighbours < 4 ? ALIVE : DEAD;
  }

}
