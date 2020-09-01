package threadcodeknowledge.createthreads.wrongviewpoint;

/**
 * @创建日期 2020/8/31  22:16
 * @作者 Xiao
 * @描述
 */
public class Lambda {
    public static void main(String[] args) {
        new Thread(()-> System.out.println(Thread.currentThread().getName())).start();
    }
}

