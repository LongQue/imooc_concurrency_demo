package demo;

/**
 * @ClassName SynchronizedSuperClass12
 * @Description 可重入粒度测试：调用父类方法
 * @Author ZFF
 * @Date 2019/9/28 23:55
 * @Version 1.0
 **/
public class SynchronizedSuperClass12
{
    public synchronized void doSomething()
    {
        System.out.println("我是父类方法");
    }
}

class TestClass extends SynchronizedSuperClass12
{
    public synchronized void doSomeThing()
    {
        System.out.println("我是子类方法");
        super.doSomething();
    }

    public static void main(String[] args)
    {
        TestClass s = new TestClass();
        s.doSomeThing();
    }

}
