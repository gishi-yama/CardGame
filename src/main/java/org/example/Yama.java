package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

public class Yama {

  private final List<Card> cards;

  public Yama() {
    // 5枚（♠、♥、♦、♣、Joker）のカードを作る
    var marks = EnumSet.allOf(Mark.class);
    cards = new ArrayList<>();
    for (Mark mark : marks) {
      Card card = new Card(mark);
      // 山にして
      cards.add(card);
    }
    // 点を切る（シャッフルする）
    Collections.shuffle(cards);
  }

//  例えば、フィールド（cards）のコピーを外部に渡す方法
//  public List<Card> getCardsCopy() {
//    List<Card> copied = new ArrayList<>(cards);
//    return copied;
//  }

  public Card drawCard(int n) {
    // n枚目⇒配列(List)のindexに変換
    int index = n - 1;
    Card card = cards.get(index);
    cards.remove(index);
    return card;
  }

  public int getMaisu() {
    return cards.size();
  }
}
