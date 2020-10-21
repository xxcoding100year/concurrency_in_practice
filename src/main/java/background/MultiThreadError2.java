package background;

/**
 * @创建日期 2020/8/23  22:34
 * @作者 Xiao
 * @描述 第二种线程安全问题，显示死锁
 */
public class MultiThreadError2 implements Runnable {
    int flag = 1;
    static Object o1 = new Object();
    static Object o2 = new Object();

    @Override
    public void run() {

    }
}
