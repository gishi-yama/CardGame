package org.example.service;

import org.example.model.Player;
import org.example.model.Yama;
import org.example.rule.DrawRule;
import org.example.rule.WinLoseRule;

import java.util.Scanner;

/**
 * == ゲームの進行を表現するクラス。
 *
 * ゲームの進行に必要なサービスを順に実行する。
 *
 *
 * === 悩みどころ
 *
 * . ここでは、カードを引く処理をServiceに寄せている（カードを引いた瞬間プレイヤーが産まれる）が、Playerを先に生成し、Yamaを渡してPlayer側でカードを引く処理の方が、現実のイメージに合っているかも？
 * . キーボード入力は外部サービスとの連係部分と捉えて、更にクラスを分けても良さそう...
 */
public class GameService {

  public void run() {
    // カードの山を作る
    Yama yama = new Yama();
    // プレイヤー1が山からカードをひく
    Player player1 = drawCardByPlayer1(yama);
    // プレイヤー2が山からカードをひく
    Player player2 = drawCardByPlayer2(yama);
    // 勝者を判定する
    seeWhoWins(player1, player2);
  }

  Player drawCardByPlayer1(Yama yama) {
    System.out.println("Player1の操作です");
    return drawCard(yama);
  }

  Player drawCardByPlayer2(Yama yama) {
    System.out.println("Player2の操作です");
    return drawCard(yama);
  }

  Player drawCard(Yama yama) {
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

  void seeWhoWins(Player p1, Player p2) {
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
