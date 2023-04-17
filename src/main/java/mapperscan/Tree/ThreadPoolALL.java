package mapperscan.Tree;

import java.util.concurrent.*;

public class ThreadPoolALL {

    public void threadPoll() {
        int corePoolSize = 2; //线程池维护线程的最少数量
        int maxPoolSize = 3; //线程池维护线程的最大数量
        long keepAliveTime = 10; //线程池维护线程所允许的空闲时间（解释：当线程池的数量超过corePoolSize时，多余的空闲线程的存活时间。）
        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.AbortPolicy();
        BlockingDeque<Runnable> queue = new LinkedBlockingDeque<>(7);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.SECONDS, queue, rejectedExecutionHandler);
        executor.allowCoreThreadTimeOut(false);

        //1、Runnable方法起线程
        Runnable testRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("begin");
            }
        };
        //起多少个线程
        for (int i = 0; i < 10; i++) {
            executor.execute(testRunnable);
        }
//        executor.shutdown();
    }

}

