package demo;

/**
 * @ClassName SynchronizedClassClass5
 * @Description 类锁形式2：*.Class
 * @Author ZFF
 * @Date 2019/9/28 10:54
 * @Version 1.0
 **/
public class SynchronizedClassClass5 implements Runnable
{
    static SynchronizedClassClass5 instance1 = new SynchronizedClassClass5();
    static SynchronizedClassClass5 instance2 = new SynchronizedClassClass5();

    @Override
    public void run()
    {
        method();
    }

    private void method()
    {
        synchronized (SynchronizedClassClass5.class)
        {
            System.out.println("我是类锁的第二种形式：synchronized(*.class)。我叫" + Thread.currentThread()
                    .getName());
            try
            {
                Thread.sleep(3000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"运行结束");
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
