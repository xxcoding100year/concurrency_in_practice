package threadcodeknowledge.sixstates;

/**
 * @创建日期 2020/9/9  21:32
 * @作者 Xiao
 * @描述 展示线程的NEW、RUNNABLE、TERMINATED状态。即使是正在运行，也是Runnable状态，而不是Running
 */
public class NewRunnableTerminated implements Runnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTerminated());
        //打印出new的状态
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出RUNNABLE状态，即使是正在运行，也是RUNNABLE,而不是RUNNING
        System.out.println(thread.getState());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出TERMINATED状态
        System.out.println(thread.getState());

    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}

