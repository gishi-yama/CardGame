package org.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * == カードの山を表現するクラス。
 *
 * 山として積み重ねられたカードの束をフィールドに設定している。
 *
 * インスタンス化されてから、山からカードを引くと残りカードが変わる（ミュータブル）ので注意。
 */
public final class Yama {

  private final List<Card> cards;

  public Yama() {
    var marks = EnumSet.allOf(Mark.class);
    cards = marks.stream()
      .map(Card::new)
      .collect(Collectors.toList());

//    上の marks.stream... はこのfor文と同じ処理
//    List<Card> cards = new ArrayList<>();
//    for(Mark mark : marks) {
//      Card card = new Card(mark);
//      cards.add(card);
//    }

    Collections.shuffle(cards);
  }

  public int getMaisu() {
    return cards.size();
  }

  public List<Card> copyCards() {
    return new ArrayList<>(cards);
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
