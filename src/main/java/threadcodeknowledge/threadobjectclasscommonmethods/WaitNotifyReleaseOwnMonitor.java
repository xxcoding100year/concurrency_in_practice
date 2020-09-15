package threadcodeknowledge.threadobjectclasscommonmethods;

/**
 * @创建日期 2020/9/14  22:29
 * @作者 Xiao
 * @描述 证明wait只释放当前的那把锁
 */
public class WaitNotifyReleaseOwnMonitor {
    private static volatile Object resourcesA = new Object();
    private static volatile Object resourcesB = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourcesA) {
                    System.out.println("ThreadA got resourcesA lock");
                    synchronized (resourcesB) {
                        System.out.println("ThreadA got resourcesB lock");
                        try {
                            System.out.println("ThreadA releases resourcesA lock ");
                            resourcesA.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resourcesA) {
                    System.out.println("ThreadB got resourcesA lock");
                    System.out.println("ThreadB tries resourcesB lock");
                    synchronized (resourcesB) {
                        System.out.println("ThreadB got resourcesB lock ");
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}

