package test;

import java.util.ArrayList;
import java.util.List;

/**
 * 購入した本数に対して、ある条件を満たすと購入した本数+αを返すクラス
 * @author yoshimura
 */
public class DrinkPlaus {

    private static int plaus = 0;//増えた本数
    private static int target = 3;//対象の条件

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("");

        System.out.println("※　購入した本数を入力してください　※　");
        System.out.print("＞");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int input = sc.nextInt();    // 入力した値
        System.out.println("購入した本数は" + input + "です.");
        System.out.println("飲める本数は" + total(input) + "です.");
        System.out.println("もらった本数:" + plaus);
    }

    /**
     * 入力本数に対して合計本数を出力する.
     */
    private static int total(int value) {
        if (value < target) {
            return value;
        } else {
            return value + quotientAndremainder(value);
        }
    }

    /**
     * 入力値をある条件で割り切れなくなったときの商と余りの合計値を返します。
     * @param value
     * @return 合計値
     */
    private static int quotientAndremainder(int value) {
        int syo = value / target;
        int amari = value % target;
        int goukei = syo + amari;
        if(goukei >= target) {
            plaus += syo;
            quotientAndremainder(goukei);
        } else {
            plaus += 1 + amari;
        }
        return plaus;
    }
}
