package background;

/**
 * @创建日期 2020/8/23  22:34
 * @作者 Xiao
 * @描述 第一种：运行结果出错
 * 演示技术不准确（减少），找出具体出错的位置
 */
public class MultiThreadError implements Runnable {
    int index = 0;
    final boolean[] marked = new boolean[10000000];
    static MultiThreadError instance = new MultiThreadError();
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("表面上结果是" + instance.index);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            index++;
            if (marked[index]) {
                System.out.println("发生了错误" + index);
            }
            marked[index] = true;
        }
    }
}
