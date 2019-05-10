package ex4;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Renshu {

    public static void main(String[] args) {
        new Renshu();
    }

    public Renshu() {//コンストラクタ
        //printHello();
    }

    void printHello() {
        System.out.println("Hello World");
    }

    void printHello2() {
        System.out.println("Hello World");
        System.out.println("Hello World");
    }

    void printHellos(int n) {
        int i = 0;
        while (i < n) {
            System.out.println("Hello World");
            i++;
        }
    }

    void calc1(int x) {
        if (x < 10) {
            System.out.println("small number");
        }
    }

    int calc2(int x) {
        return x * 2;
    }

    float calc3(float x) {
        return x * 2;
    }

    int calc4(int x, int y) {
        return (x + y) * 2;
    }

    int calc5(int x, int y, int z) {
        return (x + y + z) * 2;
    }

    int sum(int n) {
        int result = 0;
        for (int i = 0; i < (n + 1); i++) {
            result += i;
        }
        return result;
    }

    int sum(int p, int q) {
        int result = 0;
        for (int i = p; i < q + 1; i++) {
            result += i;
        }
        return result;
    }

    int sum(int[] a, int index) {
        if (index >= a.length) {
            System.out.println("Index Error!");
            return -1;
        }
        int result = 0;
        for (int i = index; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }

    int selectMaxValue(int[] a) {
        int maximum = a[0];
        for (int i = 0; i < a.length; i++) {
            maximum = Math.max(maximum, a[i]);
        }
        return maximum;
    }

    int selectMaxIndex(int[] a) {
        int maximum = a[0];
        int maxindex = 0;
        for (int i = 0; i < a.length; i++) {
            if (maximum < a[i]) {
                maxindex = i;
            }
            maximum = Math.max(maximum, a[i]);
        }
        return maxindex;
    }

    int selectMinIndex(int[] p) {
        int minimum = p[0];
        int minindex = 0;
        for (int i = 0; i < p.length; i++) {
            if (minimum > p[i]) {
                minindex = i;
            }
            minimum = Math.min(minimum, p[i]);
        }
        return minindex;
    }

    int selectDiffMaxMinValue(int[] p) {
        return p[selectMaxIndex(p)] - p[selectMinIndex(p)];
    }

    void swapArrayElements(int[] p, int i, int j) {
        int temp;
        temp = p[i];
        p[i] = p[j];
        p[j] = temp;
    }

    int selectMaxIndex(int[] a, int i, int j) {
        int maximum = 0;
        int maxindex = 0;
        for (; i < j; i++) {
            if (maximum < a[i]) {
                maxindex = i;
            }
            maximum = Math.max(maximum, a[i]);
        }
        return maxindex;
    }

    boolean swapTwoArrays(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        int[] temp = a.clone();
        System.arraycopy(b, 0, a, 0, b.length);
        System.arraycopy(temp, 0, b, 0, a.length);
        return true;
    }
}//Renshu class end