package org.example.rule;

import org.example.model.Mark;
import org.example.model.Player;

import java.util.Objects;

/**
 * == ゲームの勝敗を表現するクラス（イミュータブル）
 *
 * . スペードはジョーカーに無条件に勝つ
 * . カードに与えられた強さが大きい方が勝つ
 */
public class WinLoseRule {

  private final Mark p1Mark;
  private final Mark p2Mark;

  public WinLoseRule(Player p1, Player p2) {
    this.p1Mark = Objects.requireNonNull(p1.getCardMark());
    this.p2Mark = Objects.requireNonNull(p2.getCardMark());
    System.out.println(String.format("Player1 : %s, Player2 : %s", p1Mark, p2Mark));
  }

  // 左が勝つ
  public boolean isPlayer1Win() {
    return isBeatenJokerBySpade() || isHigherStrengthWins();
  }

  // スペードはジョーカーに無条件に勝つ
  boolean isBeatenJokerBySpade() {
    if (p1Mark == Mark.SPADE) {
      // もし左がSPADEなら、右がJOKERの時だけ勝てる。
      return p2Mark == Mark.JOKER;
    }
    return false;
  }

  //  カードに与えられた強さが大きい方が勝つ
  boolean isHigherStrengthWins() {
    return p2Mark.getStrength() < p1Mark.getStrength();
  }

}
