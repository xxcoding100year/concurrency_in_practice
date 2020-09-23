package threadcodeknowledge.uncaughtexception;

/**
 * @创建日期 2020/9/16  21:53
 * @作者 Xiao
 * @描述 使用刚才自己写的UncaughtExceptionHandler
 */
public class UseOwnUncaugthExceptionHandler implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler("捕获器1"));
        new Thread(new UseOwnUncaugthExceptionHandler(), "MyThread-1").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaugthExceptionHandler(), "MyThread-2").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaugthExceptionHandler(), "MyThread-3").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaugthExceptionHandler(), "MyThread-4").start();
        Thread.sleep(300);
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
