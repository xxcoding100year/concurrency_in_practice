package threadcodeknowledge.createthreads;

/**
 * @创建日期 2020/8/23  21:46
 * @作者 Xiao
 * @描述 用Runnable方式创建线程
 */
public class RunnableStyle implements Runnable{

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();

    }

    @Override
    public void run() {
        System.out.println("用Runnable方法实现线程");
    }
}

