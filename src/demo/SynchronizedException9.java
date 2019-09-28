package demo;

/**
 * @ClassName SynchronizedException9
 * @Description 方法抛异常后，会释放锁。展示不跑异常前和抛出异常后对比：
 * 一旦抛出了异常(指不需要捕获的异常，捕获异常的话try以外的语句仍然执行，执行完才释放锁），第二个线程会立即进同步方法
 * @Author ZFF
 * @Date 2019/9/28 17:12
 * @Version 1.0
 **/
public class SynchronizedException9 implements Runnable
{
    static SynchronizedException9 instance = new SynchronizedException9();

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
        throw new RuntimeException();
//        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public synchronized void method2()
    {
        System.out.println("我加锁的方法2。我叫" + Thread.currentThread().getName());
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

