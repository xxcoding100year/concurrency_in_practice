package threadcodeknowledge.threadobjectclasscommonmethods;

/**
 * @创建日期 2020/9/15  21:56
 * @作者 Xiao
 * @描述 演示打印main、Thread0、Thread1
 */
public class CurrentThread implements Runnable {
    public static void main(String[] args) {
        new CurrentThread().run();
        new Thread(new CurrentThread()).start();
        new Thread(new CurrentThread()).start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
