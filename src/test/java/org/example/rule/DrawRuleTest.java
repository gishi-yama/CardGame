package org.example.rule;

import org.example.model.Yama;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DrawRuleTest {

  private Yama yama;

  @BeforeEach
  public void 山を準備() {
    yama = new Yama();
  }

  @Test
  public void 入力値が数値に変換できない時にfalse() {
    var sut = new DrawRule(yama, "Test");
    assertFalse(sut.isOK());
  }

  @Test
  public void 入力値が山の枚数より大きい時にfalse() {
    var sut = new DrawRule(yama, "6");
    assertFalse(sut.isOK());
  }

  @Test
  public void 入力値が山の枚数より小さいときにTrue() {
    var sut = new DrawRule(yama, "2");
    assertTrue(sut.isOK());
  }

  @Test
  public void 入力値が負の時にfalse() {
    var sut = new DrawRule(yama, "-1");
    assertFalse(sut.isOK());
  }
  
}
