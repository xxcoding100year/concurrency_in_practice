package threadcodeknowledge.createthreads;

/**
 * @创建日期 2020/8/23  22:34
 * @作者 Xiao
 * @描述 同时使用Runnable和Thread两种实现线程的方式
 */
public class BothRunnableThread {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我来自Runnable");
            }
        }) {
            @Override
            public void run() {
                System.out.println("我来自Thread");
            }
        }.start();
    }

}

