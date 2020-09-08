package volatiledemo;

/**
 * @创建日期 2020/9/8  22:36
 * @作者 Xiao
 * @描述 演示用voltile的局限 part2
 * 陷入阻塞时，volatile是无法中断线程的
 * 此例中，生产者的生产速度很快，消费者消费速度慢，所以阻塞队列满了以后，生产者会阻塞，等待消费者进一步消费
 */
public class WrongWayVolatileCantStop {
}

