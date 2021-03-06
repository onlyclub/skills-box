package com.yew1eb.core.thread;

import java.util.ArrayList;
import java.util.concurrent.*;


// Callable实现类task，指定其类型参数
class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}

public class CallableDemo {
    public static void main(String[] args) {
        // 创建一个新的线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        // Callable实现类task的返回结果集
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 5; i++)
            results.add(exec.submit(new TaskWithResult(i)));// 使用submit来启动Tasks

        // 异步计算的结果
        for (Future<String> fs : results)
            try {
                // get阻塞，直至获取结果
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                System.out.println(e);
                e.printStackTrace();
            } catch (ExecutionException e) {
                System.out.println(e);
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
    }
}