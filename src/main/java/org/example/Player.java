package org.example;

public class Player {

  // カード交換ありならfinalは駄目（ミュータブルにする）
  private final Card card;

  public Player(Card card) {
    this.card = card;
  }

  public Mark getCardMark() {
    return card.getMark();
  }
}
