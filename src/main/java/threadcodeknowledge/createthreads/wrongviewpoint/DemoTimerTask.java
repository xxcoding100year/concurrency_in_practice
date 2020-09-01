package threadcodeknowledge.createthreads.wrongviewpoint;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @创建日期 2020/8/31  22:03
 * @作者 Xiao
 * @描述
 */
public class DemoTimerTask {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }, 1000, 1000);
    }
}

