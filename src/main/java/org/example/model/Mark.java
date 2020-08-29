package org.example.model;

/**
 * == カードのマークの種類を表現する列挙型クラス。
 *
 * マークの名前に対し、強さ数値をフィールドで表す。
 *
 * インスタンス化されてからフィールドが変化しない（イミュータブル）。
 */
public enum Mark {
  SPADE(1),
  HART(2),
  DIA(3),
  CLOVER(4),
  JOKER(5);

  private final int strength;

  private Mark(int strength) {
    this.strength = strength;
  }

  public int getStrength() {
    return strength;
  }
}
