package org.example.model;

import java.util.Objects;

/**
 * プレイヤーを表現するクラス。
 *
 * プレイヤーが持っているカードをフィールドで表す。
 * インスタンス化されてからフィールドが変化しない（イミュータブル）。
 */
public final class Player {

  private final Card card;

  public Player(Card card) {
    this.card = Objects.requireNonNull(card);
  }

  public Mark getCardMark() {
    return card.getMark();
  }
}
