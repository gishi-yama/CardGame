package org.example.rule;

import org.example.model.Mark;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinLoseRuleTest {

  @Test
  public void 左がダイア右がスペードで左が勝つ() {
    var sut = new WinLoseRule(Mark.DIA, Mark.SPADE);
    assertTrue(sut.isLeftWon());
  }

  @Test
  public void 右がダイア左がスペードで左が負ける() {
    var sut = new WinLoseRule(Mark.SPADE, Mark.DIA);
    assertFalse(sut.isLeftWon());
  }

  @Test
  public void 左がスペード右がジョーカーで左が勝つ() {
    var sut = new WinLoseRule(Mark.SPADE, Mark.JOKER);
    assertTrue(sut.isLeftWon());
  }


}
