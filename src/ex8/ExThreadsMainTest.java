package ex8;

class ExThreadsMainTest extends Thread implements ICallBackListener {

    int count;
    String tname;

    public void setThreadName(String tname, int n) {
        this.tname = tname;
        count = n;
    }

    public void run() {
        for (int i = 1; i <= count; i++) {
            System.out.println(tname + ":" + i);
            try {
                //(4)sleep状態へ移行
                sleep(1000);
                //1000ms=1s
            } catch (InterruptedException e) {
            }
        }
        //System.out.println("Thread終わり");
        printFinish(tname);
    }


    public static void main(String[] args) {
        //(1)スレッドの作成
        ExThreadsMainTest thread1 = new ExThreadsMainTest();
        ExThreadsMainTest thread2 = new ExThreadsMainTest();
        ExThreadsMainTest thread3 = new ExThreadsMainTest();
        ExThreadsMainTest thread4 = new ExThreadsMainTest();
        ExThreadsMainTest thread5 = new ExThreadsMainTest();

        //(2)実行可能状態へ移行
        thread1.setThreadName("thread1", 15);
        thread2.setThreadName("thread2", 14);
        thread3.setThreadName("thread3", 13);
        thread4.setThreadName("thread4", 12);
        thread5.setThreadName("thread5", 11);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

    @Override
    public void printFinish(String tname) {
        System.out.println(tname + "完了!");
    }

}
