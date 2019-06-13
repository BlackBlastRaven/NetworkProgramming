package ex8;

/*
threadパッケージのCountTenRunnable.javaを改造してCountAZTenRunnable.javaを作成せよ。
a-zまでスレッドを26個作成し自動で10までカウントアップせよ。
コンソール出力の結果も8_A_Result.txtに記載して提出せよ。
 */
class CountAZTenRunnable extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(getName() + ":" + i);
            try {
                //(4)sleep状態へ移行
                sleep(1000);
                //1000ms=1s
            } catch (InterruptedException e) {
                System.out.println("エラー!");
            }
        }
        System.out.println("Thread終わり");
    }

    public static void main(String[] args) {
        char L00 = 'A';
        for (int L01 = 0; L01 <= ('Z' - 'A'); L01++) {
            CountAZTenRunnable thread = new CountAZTenRunnable();
            //(2)実行可能状態へ移行
            String set=String.valueOf(L00++);
            thread.setName(set);
            thread.start();
        }
    }
}
