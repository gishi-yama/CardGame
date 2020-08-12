package org.example.model;

import java.util.List;

public class Yama {

  private final List<Card> cards;

  public Yama(List<Card> cards) {
    this.cards = cards;
  }

  public int getMaisu() {
    return cards.size();
  }

  public List<Card> getCards() {
    return cards;
  }
}
