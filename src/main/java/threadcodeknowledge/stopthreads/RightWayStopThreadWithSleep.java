package threadcodeknowledge.stopthreads;

/**
 * @创建日期 2020/9/2  23:06
 * @作者 Xiao
 * @描述 run方法内有sleep方法时中断线程的写法
 */
public class RightWayStopThreadWithSleep {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()-> {
            int num = 0;
            try {
                while (num <= 300 && !Thread.currentThread().interrupted()) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是100的倍数");
                    }
                    num++;
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}

