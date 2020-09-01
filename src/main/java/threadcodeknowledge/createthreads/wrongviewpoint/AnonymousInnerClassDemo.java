package threadcodeknowledge.createthreads.wrongviewpoint;

/**
 * @创建日期 2020/8/31  22:12
 * @作者 Xiao
 * @描述
 */
public class AnonymousInnerClassDemo {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }
}

