package demo;

/**
 * @ClassName SynchronizedObjectCodeBlock2
 * @Description 对象锁形式1：代码块，需手动指定所对象；两个不同实例访问两个对象的同步方法
 * 并行，各自用各自实例的对象锁
 * @Author ZFF
 * @Date 2019/9/28 10:19
 * @Version 1.0
 **/
public class SynchronizedObjectCodeBlock2 implements Runnable
{
    static SynchronizedObjectCodeBlock2 instance1 = new SynchronizedObjectCodeBlock2();
    static SynchronizedObjectCodeBlock2 instance2 = new SynchronizedObjectCodeBlock2();

    Object lock1 = new Object();
    Object lock2 = new Object();

    @Override
    public void run()
    {
        synchronized (lock1)
        {
            System.out.println("我是lock1,我叫" + Thread.currentThread()
                    .getName());
            try
            {
                Thread.sleep(3000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread()
                    .getName() + "lock1运行结束");
        }
        synchronized (lock2)
        {
            System.out.println("我是lock2,我叫"+Thread.currentThread()
                    .getName());
            try
            {
                Thread.sleep(3000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread()
                    .getName() + "lock2运行结束");
        }
    }

    public static void main(String[] args)
    {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive())
        {

        }
        System.out.println("finish");
    }
}
