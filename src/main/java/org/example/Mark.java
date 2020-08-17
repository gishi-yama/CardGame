package org.example;

public enum Mark {
  SPADE(10),
  HART(20),
  DIA(30),
  CLOVER(40),
  JOKER(50);

  private final int strength;

  private Mark(int strength) {
    this.strength = strength;
  }

  public int getStrength() {
    return strength;
  }
}
