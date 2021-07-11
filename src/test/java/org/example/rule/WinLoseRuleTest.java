package org.example.rule;

import org.example.model.Card;
import org.example.model.Mark;
import org.example.model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinLoseRuleTest {

  @Test
  public void 左がダイア右がスペードで左が勝つ() {
    Player p1 = new Player(new Card(Mark.DIA));
    Player p2 = new Player(new Card(Mark.SPADE));
    var sut = new WinLoseRule(p1, p2);
    assertTrue(sut.isPlayer1Win());
  }

  @Test
  public void 右がダイア左がスペードで左が負ける() {
    Player p1 = new Player(new Card(Mark.SPADE));
    Player p2 = new Player(new Card(Mark.DIA));
    var sut = new WinLoseRule(p1, p2);
    assertFalse(sut.isPlayer1Win());
  }

  @Test
  public void 左がスペード右がジョーカーで左が勝つ() {
    Player p1 = new Player(new Card(Mark.SPADE));
    Player p2 = new Player(new Card(Mark.JOKER));
    var sut = new WinLoseRule(p1, p2);
    assertTrue(sut.isPlayer1Win());
  }


}
