package threadcodeknowledge.uncaughtexception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @创建日期 2020/9/16  21:53
 * @作者 Xiao
 * @描述 自己的MyUncaughtExceptionHandler
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private String name;

    public MyUncaughtExceptionHandler(String name) {
        this.name = name;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.WARNING,"线程异常，中止啦" + t.getName(), e);
        System.out.println(name + "捕获了异常" + t.getName() + "异常：" + e);
    }
}
