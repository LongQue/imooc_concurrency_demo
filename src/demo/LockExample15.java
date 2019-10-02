package demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName LockExample15
 * @Description TODO
 * @Author ZFF
 * @Date 2019/10/2 15:16
 * @Version 1.0
 **/
public class LockExample15
{
    public static void main(String[] args)
    {
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
        lock.tryLock();
//        lock.tryLock(10, TimeUnit.SECONDS);
    }
}
