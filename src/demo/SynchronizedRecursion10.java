package demo;

/**
 * @ClassName SynchronizedRecursion10
 * @Description 可重入粒度测试：递归调用本方法
 * @Author ZFF
 * @Date 2019/9/28 23:46
 * @Version 1.0
 **/
public class SynchronizedRecursion10
{
    int b = 0;

    public static void main(String[] args)
    {
        SynchronizedRecursion10 synchronizedRecursion10 = new SynchronizedRecursion10();
        synchronizedRecursion10.method1();

    }

    private synchronized void method1()
    {
        System.out.println("这是method1，a="+b);
        if (b == 0)
        {
            b++;
            method1();
        }
    }
}
