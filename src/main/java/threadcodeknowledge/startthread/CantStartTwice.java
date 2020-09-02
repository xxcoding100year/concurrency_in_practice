package threadcodeknowledge.startthread;

/**
 * @创建日期 2020/9/2  22:02
 * @作者 Xiao
 * @描述 演示不能两次调用start方法，否则会报错
 */
public class CantStartTwice {
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.start();
    }
}

