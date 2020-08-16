package org.example.model;

import java.util.Objects;

/**
 * カード1枚分を表現するクラス。
 *
 * カードに描かれているマークをフィールドで表す。
 * インスタンス化されてからフィールドが変化しない（イミュータブル）。
 */
public class Card {

  private final Mark mark;

  public Card(Mark mark) {
    this.mark = Objects.requireNonNull(mark);
  }

  public Mark getMark() {
    return mark;
  }
}
