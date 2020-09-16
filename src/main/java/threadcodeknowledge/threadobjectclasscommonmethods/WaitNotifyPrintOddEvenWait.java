package threadcodeknowledge.threadobjectclasscommonmethods;

/**
 * @创建日期 2020/9/15  21:56
 * @作者 Xiao
 * @描述 两个线程交替打印0~100的奇偶数，用wait/notify
 */
public class WaitNotifyPrintOddEvenWait {
    private static int count = 0;
    private static final Object lock = new Object();
    //1.拿掉锁，我们就打印
    //2.打印完，唤醒其它线程，自己就休眠
    static class TurningRunner implements Runnable {

        public static void main(String[] args) {
            new Thread(new TurningRunner()).start();
            new Thread(new TurningRunner()).start();
        }

        @Override
        public void run() {
            while (count < 100) {
                synchronized (lock) {
                    //拿到锁就打印
                    System.out.println(Thread.currentThread().getName() + ":" +count++);
                    lock.notify();
                    if (count <= 100) {
                        try {
                            //如果任务还没结束，让出当前锁并休眠
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }
    }
}
