package org.example;

// トランプの山からカードを引くときの（全ての）ルール
public class DrawRule {

  private final Yama yama;
  private final String inputted;

  public DrawRule(Yama yama, String inputted) {
    this.yama = yama;
    this.inputted = inputted;
  }
  
  public boolean isOK() {
    return キーボードからの入力が数値である()
      && 入力値が1以上で山の枚数以下である();
  }

  // キーボードからの入力が数値であるルールのチェック
  private boolean キーボードからの入力が数値である() {
    try {
      Integer.parseInt(inputted);
      return true;
    } catch (NumberFormatException e) {
      System.out.println("数値を入力してください");
      return false;
    }
  }

  // 入力値が1以上で、山の枚数以下であるルールのチェック
  private boolean 入力値が1以上で山の枚数以下である() {
    var num = Integer.parseInt(inputted);
    var yamaMaisu = yama.getMaisu();
    if (1 <= num && num <= yamaMaisu) {
      return true;
    }
    System.out.println(String.format("1〜%dを入力してください", yamaMaisu));
    return false;
  }

}
