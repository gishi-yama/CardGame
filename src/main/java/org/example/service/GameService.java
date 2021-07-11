package org.example.service;

import org.example.model.Player;
import org.example.model.Yama;
import org.example.rule.WinLoseRule;

/**
 * == ゲームの進行を表現するクラス
 *
 * ゲームの進行に必要なサービスを順に実行する。
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

  static Player drawCardByPlayer1(Yama yama) {
    System.out.println("Player1の操作です");
    return Player.drawCard(yama);
  }

  static Player drawCardByPlayer2(Yama yama) {
    System.out.println("Player2の操作です");
    return Player.drawCard(yama);
  }

  static void seeWhoWins(Player p1, Player p2) {
    var winLoseRule = new WinLoseRule(p1, p2);
    if (winLoseRule.isPlayer1Win()) {
      System.out.println("Player1の勝利");
      return;
    }
    System.out.println("Player2の勝利");
  }

}
