package org.example.rule;

import org.example.model.Yama;

import java.util.Objects;

/**
 * カードを引くためのルールを反映するクラス（イミュータブル）
 *
 * . 入力値が整数である（システムからの入力値チェックとして別立てすべきだが、  講習資料としてコードの見た目上の簡易化のためこちらにいれた）
 * . 入力値が範囲内（1〜山の残り枚数まで）
 */
public class DrawRule {

  private final Yama yama;
  private final String inputted;

  public DrawRule(Yama yama, String inputted) {
    this.yama = Objects.requireNonNull(yama);
    this.inputted = Objects.requireNonNullElse(inputted, "");
  }

  public boolean isOK() {
    return isIntegerInputted() && isWithinRange();
  }

  boolean isIntegerInputted() {
    try {
      Integer.parseInt(inputted);
      return true;
    } catch (NumberFormatException e) {
      System.out.println("数値を入力してください");
      return false;
    }
  }

  //入力値が1より大きく、山の枚数より小さい
  boolean isWithinRange() {
    var num = Integer.parseInt(inputted);
    if (1 <= num && num <= yama.getMaisu()) {
      return true;
    }
    System.out.println(String.format("1〜%dを入力してください", yama.getMaisu()));
    return false;
  }

}
