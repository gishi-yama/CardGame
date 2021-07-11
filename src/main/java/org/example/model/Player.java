package org.example.model;

import org.example.rule.DrawRule;

import java.util.Objects;
import java.util.Scanner;

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

  public static Player drawCard(Yama yama) {
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
  
}
