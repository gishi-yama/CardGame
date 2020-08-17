package org.example;


import java.util.Scanner;

/**
 * ゲームの進行を表現するクラス。
 *
 * ゲームの進行に必要なサービスを順に実行する。
 */
public class GameService {

  public void run() {
    // カードの山を作る
    Yama yama = new Yama();

    // プレイヤー1が山からカードをひく
    Card p1Card = プレイヤー1が山からカードをひく(yama);
    Player player1 = new Player(p1Card);

    // プレイヤー2が山からカードをひく
    Card p2Card = プレイヤー2が山からカードをひく(yama);
    Player player2 = new Player(p2Card);

    // 勝者を判定する
    勝者を判定する(player1, player2);
  }

  Card プレイヤー1が山からカードをひく(Yama yama) {
    System.out.println("プレイヤー1の番です");
    return 山からカードをひく(yama);
  }

  Card プレイヤー2が山からカードをひく(Yama yama) {
    System.out.println("プレイヤー2の番です");
    return 山からカードをひく(yama);
  }

  Card 山からカードをひく(Yama yama) {
    System.out.println("何枚目のカードをひきますか？");
    // 何枚目を選ぶのか決める = n
    while (true) {
      Scanner scanner = new Scanner(System.in);
      String inputted = scanner.nextLine(); // 数字が入ってこなきゃいけない
      // ルールは？
      DrawRule rule = new DrawRule(yama, inputted);
      if (rule.isOK()) {
        int n = Integer.parseInt(inputted);
        // n枚目のカードを山からひく
        Card card = yama.drawCard(n);
        return card;
      }
    }
  }

  void 勝者を判定する(Player player1, Player player2) {
    // player1 のカードのマークは？
    Mark mark1 = player1.getCardMark();
    // player2 のカードのマークは？
    Mark mark2 = player2.getCardMark();
    System.out.println(String.format("Player1 : %s, Player2 : %s", mark1, mark2));
    //マークを比べた時の勝者は?
    WinLoseRule rule = new WinLoseRule(mark1, mark2);
    if (rule.player1が勝利()) {
      System.out.println("Player1の勝利");
    } else {
      System.out.println("Player2の勝利");
    }
  }

}
