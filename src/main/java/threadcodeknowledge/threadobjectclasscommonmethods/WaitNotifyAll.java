package threadcodeknowledge.threadobjectclasscommonmethods;

/**
 * @创建日期 2020/9/14  22:06
 * @作者 Xiao
 * @描述 3个线程，线程1和线程2首先被阻塞，线程3唤醒它们。notify，notifyAll。
 * start先执行不代表线程先启动
 */
public class WaitNotifyAll implements Runnable {
    private static final Object resouceA = new Object();

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new WaitNotifyAll();
        Thread threadA = new Thread(r);
        Thread threadB = new Thread(r);
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resouceA) {
                    resouceA.notifyAll();
//                    resouceA.notify();
                    System.out.println("ThreadC notified");
                }
            }
        });
        threadA.start();
        threadB.start();
//        Thread.sleep(200);
        threadC.start();
    }

    @Override
    public void run() {
        synchronized (resouceA) {
            System.out.println(Thread.currentThread().getName() + " got resourceA lock");
            try {
                System.out.println(Thread.currentThread().getName() + " waits to start");
                resouceA.wait();
                System.out.println(Thread.currentThread().getName() + "'s waiting to end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

