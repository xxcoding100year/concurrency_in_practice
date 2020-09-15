package threadcodeknowledge.sixstates;

/**
 * @创建日期 2020/9/9  21:43
 * @作者 Xiao
 * @描述 展示Blocked，Waiting，TimeWaiting
 */
public class BlockedWaitingTimeWaiting implements Runnable {
    public static void main(String[] args) {
        BlockedWaitingTimeWaiting runnable = new BlockedWaitingTimeWaiting();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread1.getState());
        System.out.println(thread2.getState());
        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread1.getState());
    }

    @Override
    public void run() {
        syn();
    }

    private synchronized void syn() {
        try {
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

