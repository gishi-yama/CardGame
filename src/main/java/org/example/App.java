package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {

    // カードの山を作る
    List<String> cards = new ArrayList<>();
    cards.add("SPADE");
    cards.add("HART");
    cards.add("DIA");
    cards.add("CLOVER");
    cards.add("JOKER");
    Collections.shuffle(cards);

    //Player1のカードをひく
    Scanner scanner = new Scanner(System.in);
    System.out.println("Player1の操作です");
    String p1Card;
    while (true) {
      System.out.println("何枚目のカードをひきますか？");
      try {
        String p1Input = scanner.nextLine();
        int p1Number = Integer.parseInt(p1Input);
        if (p1Number <= cards.size()) {
          int p1Index = p1Number - 1;
          p1Card = cards.get(p1Index);
          cards.remove(p1Index);
          break;
        }
        System.out.println("1〜5を入力してください");
      } catch (NumberFormatException e) {
        System.out.println("数値を入力してください");
      }
    }

    //Player2のカードをひく
    System.out.println("Player2の操作です");
    String p2Card;
    while (true) {
      System.out.println("何枚目のカードをひきますか？");
      try {
        String p2Input = scanner.nextLine();
        int p2Number = Integer.parseInt(p2Input);
        if (p2Number <= cards.size()) {
          int p2Index = p2Number - 1;
          p2Card = cards.get(p2Index);
          cards.remove(p2Index);
          break;
        }
        System.out.println("1〜4を入力してください");
      } catch (NumberFormatException e) {
        System.out.println("数値を入力してください");
      }
    }

    // カードのマークを見せ合い、勝者を判定する
    System.out.println(String.format("Player1 : %s, Player2 : %s", p1Card, p2Card));

    // それ以外は、強さの順に勝つ
    // player1のカードを強さに変える
    int p1Strength = 0;
    if (p1Card.equals("SPADE")) {
      p1Strength = 1;
    }
    if (p1Card.equals("HART")) {
      p1Strength = 2;
    }
    if (p1Card.equals("DIA")) {
      p1Strength = 3;
    }
    if (p1Card.equals("CLOVER")) {
      p1Strength = 4;
    }
    if (p1Card.equals("JOKER")) {
      p1Strength = 5;
    }

    // player2のカードを強さに変える
    int p2Strength = 0;
    if (p2Card.equals("SPADE")) {
      p2Strength = 1;
    }
    if (p2Card.equals("HART")) {
      p2Strength = 2;
    }
    if (p2Card.equals("DIA")) {
      p2Strength = 3;
    }
    if (p2Card.equals("CLOVER")) {
      p2Strength = 4;
    }
    if (p2Card.equals("JOKER")) {
      p2Strength = 5;
    }

    // スペードはジョーカーに無条件に勝つ
    if (p2Strength == 5 && p1Strength == 1) {
      System.out.println("Player1の勝利");
      return;
    }
    if (p2Strength == 1 && p1Strength == 5) {
      System.out.println("Player2の勝利");
      return;
    }
    // カードが強い方が勝つ
    if (p1Strength > p2Strength) {
      System.out.println("Player1の勝利");
      return;
    }
    if (p1Strength < p2Strength) {
      System.out.println("Player2の勝利");
      return;
    }
  }
}
