package org.example.service;

import org.example.model.Card;
import org.example.model.Mark;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameServiceTest {

  @Test
  public void マークの種類からカードの山を作る() {
    var sut = new GameService();
    var actual = sut.マークの種類からカードの山を作る();
    assertAll(() -> assertEquals(5, actual.getMaisu()),
      () -> assertTrue(actual.getCards().contains(new Card(Mark.CLOVER))),
      () -> assertTrue(actual.getCards().contains(new Card(Mark.HART))),
      () -> assertTrue(actual.getCards().contains(new Card(Mark.DIA))),
      () -> assertTrue(actual.getCards().contains(new Card(Mark.SPADE))),
      () -> assertTrue(actual.getCards().contains(new Card(Mark.JOKER)))
    );
  }


}
