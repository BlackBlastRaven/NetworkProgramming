package jp.ac.dendai.fi_17fi000.ex2;

import java.security.SecureRandom;
import java.util.Random;
import java.math.BigDecimal;

public class Iwailab {
    public static void main(String args[]) {
        Iwailab iwailab = new Iwailab();
    }

    Iwailab() {
        int students[][] = new int[2][25];
        int women[][] = new int[2][25];
        int assignment[][] = new int[2][25];

        for (int i = 0; i < 25; i++) {
            students[0][i] = i + 1;
            students[1][i] = 120 + getRandom(21) - 10;
            //System.out.println(students[0][i] + "年目の生徒数は" + students[1][i]);

            women[0][i] = i + 1;
            women[1][i] = 20 + i;
            //System.out.println(women[0][i] + "年目の女性生徒数は" + women[1][i]);

            assignment[0][i] = i + 1;
            assignment[1][i] = 10 + getRandom(7) - 3;
            //System.out.println(assignment[0][i] + "年目の参加者は" + assignment[1][i]);

        }

        BigDecimal nothing = new BigDecimal("1");
        for (int i = 0; i < 25; i++) {
            BigDecimal nStudents = BigDecimal.valueOf(students[1][i]);
            BigDecimal nWomen = BigDecimal.valueOf(women[1][i]);
            BigDecimal nAssignment = BigDecimal.valueOf(assignment[1][i]);
            //全員が男性の確率=((nStudents - nWomen) C nAssignment)/(nStudents C nAssignment)
            //BigDecimal allMen = BigDecimal.valueOf(calcNumOfCombination((nStudents.subtract(nWomen)), nAssignment)).divide(BigDecimal.valueOf(calcNumOfCombination(nStudents, nAssignment)), 10, BigDecimal.ROUND_HALF_UP);
            BigDecimal allMen = calcNumOfCombination((nStudents.subtract(nWomen)), nAssignment).divide(calcNumOfCombination(nStudents, nAssignment),10,BigDecimal.ROUND_HALF_UP);
            System.out.println(i + 1 + "年目の生徒数は" + nStudents);
            System.out.println(i + 1 + "年目の女性生徒数は" + nWomen);
            System.out.println(i + 1 + "年目の男性生徒数は" + nStudents.subtract(nWomen));
            System.out.println(i + 1 + "年目の参加者は" + nAssignment);
            System.out.println(i + 1 + "年目に女性が一人も参加しない確率は" + allMen);

            System.out.println(i + 1 + "年目のup" + calcNumOfCombination((nStudents.subtract(nWomen)), nAssignment));
            System.out.println(i + 1 + "年目のdown" + calcNumOfCombination(nStudents, nAssignment));

            nothing = nothing.multiply(allMen);
            /*
            int per = 1;
            for (int j = 0; j < assignment[1][i]; j++) {
                per = per * ((nWomen - j) / nStudents);
            }
             */
        }
        System.out.println("25年間一人も女性が入らない確率は" + nothing);
    }

    int getRandom(int input) {
        Random random = new SecureRandom();
        return random.nextInt(input);
    }

    //組み合わせの数nCrを計算
    BigDecimal calcNumOfCombination(BigDecimal bn, BigDecimal br) {
        int n = bn.intValue();
        int r = br.intValue();
        //BigDecimal result = new BigDecimal("1");
        int up = n;
        int down = 1;
        for (int i = 0; i < r - 1; i++) {
            up = (up - i) * (up - i - 1);
        }
        for (int i = 0; i < r - 1; i++) {
            down = down * (down + 1);
        }
        BigDecimal result = BigDecimal.valueOf(up).divide(BigDecimal.valueOf(down), 10, BigDecimal.ROUND_HALF_UP);
        return result;
    }
}
