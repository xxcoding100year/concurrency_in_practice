package threadcodeknowledge.uncaughtexception;

/**
 * @创建日期 2020/9/16  22:01
 * @作者 Xiao
 * @描述 1.不加try catch抛出4个异常，都带线程名字
 * 2.加了try catch，期望捕获到第一个线程的异常，线程234不应该运行，希望看到打印出Caught Exception
 * 3.执行时发现，根本没有Caught Ecxeption，线程234依然运行并且抛出异常
 *
 * 说明线程的异常不能用传统方法捕获
 */
public class CantCatchDirectly implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        try {
            new Thread(new CantCatchDirectly(), "MyThread-1").start();
            Thread.sleep(300);
            new Thread(new CantCatchDirectly(), "MyThread-2").start();
            Thread.sleep(300);
            new Thread(new CantCatchDirectly(), "MyThread-3").start();
            Thread.sleep(300);
            new Thread(new CantCatchDirectly(), "MyThread-4").start();
            Thread.sleep(300);
        } catch (RuntimeException e) {
            System.out.println("Caught Exception");
        }

    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}

