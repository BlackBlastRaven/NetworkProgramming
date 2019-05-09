package ex3;

import java.util.Scanner;

public class XmasTreeKadai {

    public static void main(String[] args) {
        System.out.println("Draw your own xmas tree with multi-loop!");
        System.out.println("終了するには「雪はつけますか?」で「exit」と入力してください");
        for (; ; ) {
            System.out.println("葉の高さを入力してください");
            Scanner scan = new Scanner(System.in);
            int leafHight = scan.nextInt();

            System.out.println("幹の高さを入力してください");
            int trunkHight = scan.nextInt();

            System.out.println("幹の幅を入力してください");
            int trunkWidth = scan.nextInt();
            System.out.println("雪はつけますか?(y/n)");
            String snow = scan.next();
            if (leafHight < 0 || trunkHight < 0 || trunkWidth < 0 || (!snow.equals("y") && !snow.equals("n") && !snow.equals("exit"))) {
                System.out.println("入力に問題があります。");
                continue;
            }
            if (snow.equals("exit")) {
                System.exit(0);
            }
            draw(leafHight, trunkHight, trunkWidth, snow);
        }
    }

    public static void draw(int leafHight, int trunkHight, int trunkWidth, String snow) {
        //int leafHight = 19;
        //int trunkWidth = 3;
        //int trunkHight = 7;
        //int snow = 0;
        int leathalf = (int) Math.ceil((double) leafHight / 2);

        for (int i = 0; i < leafHight; i++) {
            for (int j = 0; j < leafHight - i; j++) {
                if (snow.equals("y")) {
                    System.out.print("+");
                } else {
                    System.out.print(" ");
                }
            }
            for (int k = 0; k < i + i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < trunkHight; i++) {
            for (int j = 0; j < leafHight - trunkWidth / 2; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < trunkWidth; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
}
