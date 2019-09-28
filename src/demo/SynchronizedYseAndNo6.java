package demo;

/**
 * @ClassName SynchronizedYseAndNo6
 * @Description 同时访问同步方法和非同步方法
 * 并行，非同步方法不需要争抢锁
 * @Author ZFF
 * @Date 2019/9/28 11:34
 * @Version 1.0
 **/
public class SynchronizedYseAndNo6 implements Runnable
{
    static SynchronizedYseAndNo6 instance = new SynchronizedYseAndNo6();
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
        System.out.println("我是加锁的方法。我叫" + Thread.currentThread().getName());
        try
        {
            Thread.sleep(3000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public void method2()
    {
        System.out.println("我是没加锁的方法。我叫" + Thread.currentThread().getName());
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
