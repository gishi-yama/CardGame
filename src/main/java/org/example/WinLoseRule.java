package org.example;

public class WinLoseRule {

  private final Mark mark1;
  private final Mark mark2;

  public WinLoseRule(Mark mark1, Mark mark2) {
    this.mark1 = mark1;
    this.mark2 = mark2;
  }

  public boolean player1が勝利() {
    return player1がSPADEのときplayer2がJOKER()
      || player1のカードがplayer2のカードより強い();
  }

  //ただし、SPADEはJOKERに勝つ
  private boolean player1がSPADEのときplayer2がJOKER() {
    return mark1 == Mark.SPADE && mark2 == Mark.JOKER;
  }

  //SPADE, HART, DIA, CLOVER, JOKER の順に強い（例：HARTはSPADEに勝つ）
  private boolean player1のカードがplayer2のカードより強い() {
    return mark2.getStrength() < mark1.getStrength();
  }
  
}
