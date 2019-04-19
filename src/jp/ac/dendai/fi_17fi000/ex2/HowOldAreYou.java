package jp.ac.dendai.fi_17fi000.ex2;

import java.io.*;    // C言語では、#include に相当する

public class HowOldAreYou {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader というのは、データ読み込みのクラス(型)
        // クラスの変数を作るには、new を使う。

        // readLine() は、入出力エラーの可能性がある。エラー処理がないとコンパイルできない。
        //  Java では、 try{ XXXXXXXX }  catch(エラーの型 変数) { XXXXXXXXXXXXXXXXXX} と書く
        while (true) {
            try {
                System.out.println("何歳ですか?");
                String line = reader.readLine();
                if (line.equals("q") || line.equals("0")) {
                    System.out.println("シャットダウンします");
                    System.exit(0);
                }
                int age = Integer.parseInt(line);
                if (age < 0 || age >= 120) {
                    System.out.println("再入力してください");
                    continue;
                }
                int ad = 2019 - age;
                String era = "ERROR";
                int eraAge = 0;
                //明治
                if (ad >= 1868 && ad < 1912) {
                    era = "明治";
                    eraAge = ad - 1868;
                }
                //大正
                if (ad >= 1912 && ad < 1926) {
                    era = "大正";
                    eraAge = ad - 1912;
                }
                //昭和
                if (ad >= 1926 && ad < 1989) {
                    era = "昭和";
                    eraAge = ad - 1926;
                }
                //平成
                if (ad >= 1989 && ad < 2019) {
                    era = "平成";
                    eraAge = ad - 1989;
                }
                //令和
                if (ad >= 2019) {
                    era = "令和";
                    eraAge = ad - 2019;
                }
                System.out.println("あなたは" + age + "歳ですね。");
                System.out.println("あなたは2020には" + (age + 1) + "歳ですね。");
                System.out.println("あなたの生年元号は" + era + eraAge + "年ですね。");

            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}

//  課題    キーボードから数字を打ち込む
//  その結果、 あなたは、???歳ですね、と画面に表示させる。
//  その後、あなたは10年後、????歳ですね、と画面に表示させる。

