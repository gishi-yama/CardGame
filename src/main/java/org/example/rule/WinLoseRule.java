package org.example.rule;

import org.example.model.Mark;

import java.util.Objects;

/**
 * ゲームの勝敗を表現するクラス（イミュータブル）。
 *
 * . スペードはジョーカーに無条件に勝つ
 * . カードに与えられた強さが大きい方が勝つ
 */
public class WinLoseRule {

  private final Mark left;
  private final Mark right;

  public WinLoseRule(Mark left, Mark right) {
    this.left = Objects.requireNonNull(left);
    this.right = Objects.requireNonNull(right);
  }

  // 左が勝つ
  public boolean isLeftWon() {
    return isBeatenJokerBySpade() || isHigherStrengthWins();
  }

  // スペードはジョーカーに無条件に勝つ
  boolean isBeatenJokerBySpade() {
    if (left == Mark.SPADE) {
      // もし左がSPADEなら、右がJOKERの時だけ勝てる。
      return right == Mark.JOKER;
    }
    return false;
  }

  //  カードに与えられた強さが大きい方が勝つ
  boolean isHigherStrengthWins() {
    return right.getStrength() < left.getStrength();
  }

}
