package org.example.spec;

import org.example.model.Yama;

public class DrawSpec {

  private final Yama yama;
  private final int num;

  public DrawSpec(Yama yama, int num) {
    this.yama = yama;
    this.num = num;
  }

  public boolean isOK() {
    return yama.getMaisu() > num;
  }

}
