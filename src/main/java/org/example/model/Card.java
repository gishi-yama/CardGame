package org.example.model;

import java.util.Objects;

public class Card {

  private final Mark mark;

  public Card(Mark mark) {
    this.mark = mark;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Card card = (Card) o;
    return mark == card.mark;
  }

  @Override
  public int hashCode() {
    return Objects.hash(mark);
  }
}
