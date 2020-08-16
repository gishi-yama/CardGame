package org.example.model;

import java.util.List;
import java.util.Objects;

/**
 * カードの山を表現するクラス。
 *
 * 山として積み重ねられたカードの束をフィールドに設定している。
 * インスタンス化されてから、山からカードを引くと残りカードが変わる（ミュータブル）ので注意。
 */
public class Yama {

  private final List<Card> cards;

  public Yama(List<Card> cards) {
    this.cards = Objects.requireNonNull(cards);
  }

  public int getMaisu() {
    return cards.size();
  }

  public List<Card> getCards() {
    return cards;
  }

  // カードの山からn枚目を引き、引いたカードを減らす
  public Card drawCard(int n) {
    //n枚目 -> インデックスに変換
    var index = n - 1;
    var drawn = cards.get(index);
    cards.remove(index);
    return drawn;
  }

}
