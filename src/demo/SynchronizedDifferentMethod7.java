package demo;

/**
 * @ClassName SynchronizedDifferentMethod7
 * @Description 访问一个对象的不同的普通同步方法(只有一把对象锁
 * 串行，只有一个对象锁
 * @Author ZFF
 * @Date 2019/9/28 15:40
 * @Version 1.0
 **/
public class SynchronizedDifferentMethod7 implements Runnable
{
    static SynchronizedDifferentMethod7 instance = new SynchronizedDifferentMethod7();
    @Override
    public void run()
    {
        if (Thread.currentThread().getName().equals("Thread-0"))
        {
            method1();
        }
        else
        {
            method2();
        }
    }

    public synchronized void method1()
    {
        System.out.println("我是加锁的方法1。我叫" + Thread.currentThread().getName());
        try
        {
            Thread.sleep(3000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public synchronized void method2()
    {
        System.out.println("我是加锁的方法2。我叫" + Thread.currentThread().getName());
        try
        {
            Thread.sleep(3000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public static void main(String[] args)
    {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive())
        {

        }
        System.out.println("finish");
    }
}
