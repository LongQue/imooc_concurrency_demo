package demo;

/**
 * @ClassName SynchronizedOtherMethod11
 * @Description 可重入粒度测试：调用类内另外的方法
 * @Author ZFF
 * @Date 2019/9/28 23:52
 * @Version 1.0
 **/
public class SynchronizedOtherMethod11
{
    public synchronized void method1()
    {
        System.out.println("我是method1");
        method2();
    }

    private synchronized void method2()
    {
        System.out.println("我是method2");
    }

    public static void main(String[] args)
    {
        SynchronizedOtherMethod11 s = new SynchronizedOtherMethod11();
        s.method1();
    }
}
