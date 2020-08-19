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

  public CellState getNextState() {
    return CellState.DEAD;
  }

}
