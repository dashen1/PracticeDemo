package com.example.architect_day11.simple5;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    private static final int CORE_POOL_SIZE = 1;
    private static final int MAXIMUM_POOL_SIZE = 20;
    private static final int BACKUP_POOL_SIZE = 5;
    private static final int KEEP_ALIVE_SECONDS = 3;

    public static final Executor THREAD_POOL_EXECUTOR;
    private static LinkedBlockingQueue<Runnable> sPoolWorkQueue =
                        new LinkedBlockingQueue<>(4);

    //BlockingQueue 先进先出队列
    //SynchronousQueue 线程安全的队列，它里面是没有固定的缓存的（OKHttp里面有）
    //PriorityBlockingQueue 无序的可以根据优先级进行排列

    // 报错原因 AsyncTask 存在一些隐患
    // 线程队列是 4，核心线程数也是 4， 最大线程数是 10，目前加入的Runnable有20个
    // 20个都要放到队列中，但是队列只有4 还有16个是没法放，这个时候最大线程数是10 非核心线程数是6
    // 但是还有10个没办法就只能抛异常了，也就是说那10个Runnable 没办法执行就会抛异常

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                4,
                10,
                60,
                TimeUnit.SECONDS,
                sPoolWorkQueue,
                new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r,"Thread_run");
                thread.setDaemon(false);
                return thread;
            }
        });
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("下载图片显示错误-"+Thread.currentThread().getId());
//                }
//            };
            //加入线程队列
            Request request = new Request();
            THREAD_POOL_EXECUTOR.execute(request);
        }
    }
}
