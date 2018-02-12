package jp.ac.uryukyu.ie.e165712;
public class Main {
    public static void main(String[] args) {

        //カード作成(配列)
        int[] player1cards = new int[5];
        int[] player2cards = new int[5];

        for (int i = 0; i < 5; i++) {
            player1cards[i] = (int) (Math.random() * 3 + 1); //カードが揃わないので3種類にしてます
            player2cards[i] = (int) (Math.random() * 3 + 1);
        }

        //インスタンス作成
        Player player1 = new Player(player1cards, "player1");
        Player player2 = new Player(player2cards, "player2");

        //カードの並び替え，ペア数の判定
        player1.Sort(player1);
        player2.Sort(player2);

        //勝敗の判定
        if (player1.getPower() == player2.getPower()) {
            System.out.printf("引き分け\n");
        } else if (player1.getPower() > player2.getPower()) {
            System.out.printf("Player1の勝ち\n");
        } else if (player1.getPower() < player2.getPower()) {
            System.out.printf("Player2の勝ち\n");
        }
    }
}
