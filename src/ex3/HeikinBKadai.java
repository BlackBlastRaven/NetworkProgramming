package ex3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class HeikinBKadai {
    public static void main(String[] args) {

// Kamokuクラスのインスタンスとして、englishを
// 作る
        Kamoku english = new Kamoku(80);
// 同様に、math
        //Kamoku math = new Kamoku(70);

// english の name に "英語" を設定する
        english.name = "英語";
        int a = english.getScore();
        //System.out.println("英語の点は" + a + "ですね");
        int b;
        //b = math.getScore();
        //System.out.println("数学の点は" + b + "ですね");
        //int ave=(a+b)/2;
        //System.out.println("平均点は" + ave + "ですね");

        Kamoku[] maths = new Kamoku[100];
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            maths[i] = new Kamoku(random.nextInt(101));
        }

        int sum = 0;
        for (Kamoku math : maths) {
            sum += math.getScore();
        }
        System.out.println("平均点は" + sum / maths.length);
        System.out.println("以下合格者の点数です。");

        Integer sorted[] = new Integer[100];
        for (int i = 0; i < maths.length; i++) {
            sorted[i] = maths[i].getScore();
        }
        Arrays.sort(sorted);
        for (int output : sorted) {
            if (output >= 80) {
                System.out.println(output);
            }
        }
    }
}
