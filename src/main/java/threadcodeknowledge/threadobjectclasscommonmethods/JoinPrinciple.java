package threadcodeknowledge.threadobjectclasscommonmethods;

/**
 * @创建日期 2020/9/15  21:56
 * @作者 Xiao
 * @描述 通过讲解join原理，分析出join的代替写法
 */
public class JoinPrinciple {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "本线程执行完毕");
            }
        });
        thread.start();
        System.out.println("开始等待子线程运行完毕");
//        thread1.join();
        synchronized (thread) {
            thread.wait();
        }
        System.out.println("所有子线程执行完毕");
    }
}
