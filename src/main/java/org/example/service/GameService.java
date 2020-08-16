package org.example.service;

import org.example.model.Card;
import org.example.model.Mark;
import org.example.model.Player;
import org.example.model.Yama;

import java.util.Collections;
import java.util.EnumSet;
import java.util.stream.Collectors;

public class GameService {

  private Yama yama;
  private Player you;
  private Player cpu;

  public void run() {
    yama = マークの種類からカードの山を作る();
    you = あなたがカードをひく(yama);
    cpu = CPUがカードをひく(yama);
    カードの数字が大きい方を勝利にする(you, cpu);
  }

  Yama マークの種類からカードの山を作る() {
    var marks = EnumSet.allOf(Mark.class);
//
////    List<Card> cards = new ArrayList<>();
////    for(Mark mark : marks) {
////      Card card = new Card(mark);
////      cards.add(card);
////    }
//
    var cards = marks.stream()
      .map(Card::new)
      .collect(Collectors.toList());
    return new Yama(cards);
  }

  Player あなたがカードをひく(Yama yama) {
    return null;
  }

  Player CPUがカードをひく(Yama yama) {
    return null;
  }

  void カードの数字が大きい方を勝利にする(Player you, Player cpu) {

  }

}
