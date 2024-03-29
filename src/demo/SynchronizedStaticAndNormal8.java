package demo;

/**
 * @ClassName SynchronizedStaticAndNormal8
 * @Description 同时访问静态synchronized和非静态synchronized方法
 * 并行，一个类锁一个对象锁
 * @Author ZFF
 * @Date 2019/9/28 17:06
 * @Version 1.0
 **/
public class SynchronizedStaticAndNormal8 implements Runnable
{
    static SynchronizedStaticAndNormal8 instance = new SynchronizedStaticAndNormal8();
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

    public synchronized static void method1()
    {
        System.out.println("我是静态加锁的方法1。我叫" + Thread.currentThread().getName());
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
        System.out.println("我是非静态加锁的方法2。我叫" + Thread.currentThread().getName());
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
