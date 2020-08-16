package org.example.service;

import org.example.model.Card;
import org.example.model.Mark;
import org.example.model.Player;
import org.example.model.Yama;
import org.example.rule.DrawRule;
import org.example.rule.WinLoseRule;

import java.util.EnumSet;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * ゲームの進行を表現するクラス。
 *
 * ゲームの進行に必要なサービスを順に実行する。
 */
public class GameService {

  public void run() {
    Yama yama = マークの種類からカードの山を作る();
    Player player1 = プレイヤー1が山からカードをひく(yama);
    Player player2 = プレイヤー2が山からカードをひく(yama);
    カードの数字が大きい方を勝利にする(player1, player2);
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

  Player プレイヤー1が山からカードをひく(Yama yama) {
    System.out.println("Player1の操作です");
    return カードをひく(yama);
  }

  Player プレイヤー2が山からカードをひく(Yama yama) {
    System.out.println("Player2の操作です");
    return カードをひく(yama);
  }

  Player カードをひく(Yama yama) {
    System.out.println("何枚目のカードをひきますか？");
    while (true) {
      var scanner = new Scanner(System.in);
      var inputted = scanner.nextLine();
      var drawRule = new DrawRule(yama, inputted);
      if (drawRule.isOK()) {
        var n = Integer.parseInt(inputted);
        var drawnCard = yama.drawCard(n);
        return new Player(drawnCard);
      }
    }
  }

  void カードの数字が大きい方を勝利にする(Player p1, Player p2) {
    var p1Mark = p1.getCardMark();
    var p2Mark = p2.getCardMark();
    System.out.println(String.format("Player1 : %s, Player2 : %s", p1Mark, p2Mark));
    var winLoseRule = new WinLoseRule(p1Mark, p2Mark);
    if (winLoseRule.isLeftWon()) {
      System.out.println("Player1の勝利");
      return;
    }
    System.out.println("Player2の勝利");
  }

}
