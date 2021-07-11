package org.example.model;

import java.util.Objects;

/**
 * == カード1枚分を表現するクラス
 *
 * カードに描かれているマークをフィールドで表す。
 *
 * インスタンス化されてからフィールドが変化しない（イミュータブル）。
 *
 * === 悩みどころ
 *
 * テストコード（YamaTest#カードの山に全種類のカードが入っている）用に、ゲーム内では使わない equals/hashCode をオーバーライドしている。
 * うまく equals/hashCode をオーバーライドする意味を持たせたい...
 */
public final class Card {

  private final Mark mark;

  public Card(Mark mark) {
    this.mark = Objects.requireNonNull(mark);
  }

  public Mark getMark() {
    return mark;
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
