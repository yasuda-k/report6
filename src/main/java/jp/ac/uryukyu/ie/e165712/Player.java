package jp.ac.uryukyu.ie.e165712;

public class Player {
    String name; //名前
    int[] tehuda; //カード(配列)
    int power; //カードの組の強さ

    public Player(int[] tehuda, String name) {
        this.tehuda = tehuda;
        this.name = name;
    }

    //power(カードの組の強さ)を返す
    public int getPower(){
        return power;
    }

    public void Sort(Player player) {
        //レポート7の昇順に並べ替えるプログラムを利用
        int lower;
        for (int i = 0; i < tehuda.length - 1; i++) {
            for (int t = 0; t < tehuda.length - (1 + i); t++) {
                if (tehuda[t] > tehuda[t + 1]) {
                    lower = tehuda[t + 1];
                    tehuda[t + 1] = tehuda[t];
                    tehuda[t] = lower;
                }
            }
        }

        //結果発表(並び替えた後のカードの並び)
        System.out.printf("%sのカードを昇順に並べ替えた後",player.name);
        for (int i = 0; i < tehuda.length; i++) {
            System.out.printf("%d,", tehuda[i]);
        }
        System.out.printf("\n");


        //ペア数の判定
        int count = 0;//同じカードの数を数える
        int jump = 0;//被らないように飛ばす
        int[] pears = new int[5];//同じカードがあった数を格納する

        for (int i = 0; i < 5; i++) {
            for (int t = i + 1; t < 5; t++) {
                if (tehuda[i] == tehuda[t]) {
                    count++;
                    jump++;
                }
            }
            pears[i] = count;
            i += jump;
            count = 0;
            jump = 0;
        }

        //結果発表(ペア数)
        System.out.printf("%sのペア数の判定",player.name);
        for (int i = 0; i < pears.length; i++) {
            System.out.printf("%d,", pears[i]);
        }
        System.out.printf("\n");

        //ペア数を渡して組の強さを測る
        Judge(pears,player);
    }

    //ペア数を集計する
    public void Judge(int[] pears ,Player player){
        int onepear = 0; //1ペアの数
        int threecard = 0; //3カードの数
        int fourcard = 0; //4カードの数

        for (int i = 0; i < pears.length; i++) {
            if (pears[i] == 1) {
                onepear++;
            }
            if (pears[i] == 2) {
                threecard++;
            }
            if (pears[i] == 3) {
                fourcard++;
            }
        }

        //組の強さの決定と結果発表(組の強さ)
        if (onepear == 1 && threecard == 1) {
            System.out.printf("フルハウス！\n");
            power = 4;
        } else if (fourcard == 1) {
            System.out.printf("フォーカード！\n");
            power = 5;
        } else if (threecard == 1) {
            System.out.printf("スリーカード！\n");
            power = 3;
        } else if (onepear == 2) {
            System.out.printf("ツーペア！\n");
            power = 2;
        } else if (onepear == 1) {
            System.out.printf("ワンペア！\n");
            power = 1;
        } else {
            System.out.printf("ノーペア！\n");
            power = 0;
        }
    }
}