package com.codurance;

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
    return neighbours > 1 && neighbours < 4 ? CellState.ALIVE : CellState.DEAD;
  }

}
