package cn.hn.others;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by huangning on 2018/4/9.
 */
public class CallbackTest {
    static ExecutorService es = Executors.newFixedThreadPool(2);
    public void doSth(ICallback callback) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("副线程中业务处理开始");

                Map<String, Object> params = new HashMap<>();
                try {
                    Thread.sleep(3000);
                    params.put("result", "i am the result");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                callback.callback(params);

            }
        });
        thread.start();

    }


    interface ICallback {
        void callback(Map<String, Object> params);

    }

    public static void main(String[] args) {
        CallbackTest test = new CallbackTest();
        test.doSth(new ICallback() {
            @Override
            public void callback(Map<String, Object> params) {
                String result = (String) params.get("result");
                System.out.println("副线程执行完毕,得到结果:" + result);

            }
        });

        System.out.println("主线程执行完毕");



    }
}

