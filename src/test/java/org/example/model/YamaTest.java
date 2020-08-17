package org.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class YamaTest {

  @Test
  public void カードの山に全種類のカードが入っている() {
    var sut = new Yama();
    var actualSize = sut.getMaisu();
    var actualCards = sut.copyCards();
    assertAll(() -> assertEquals(5, actualSize),
      () -> assertTrue(actualCards.contains(new Card(Mark.CLOVER))),
      () -> assertTrue(actualCards.contains(new Card(Mark.HART))),
      () -> assertTrue(actualCards.contains(new Card(Mark.DIA))),
      () -> assertTrue(actualCards.contains(new Card(Mark.SPADE))),
      () -> assertTrue(actualCards.contains(new Card(Mark.JOKER)))
    );
  }


}
