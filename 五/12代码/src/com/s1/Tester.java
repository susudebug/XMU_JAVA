import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
public class Tester {
    public static void main(String[] args) {
        //静态代理
        //被代理对象
        Chinese chinese=new Chinese();
        //代理对象，将被代理对象传给代理对象
        ChineseProxy chineseProxy=new ChineseProxy(chinese);
        //由代理对象调用speak函数
        chineseProxy.speak();



        //动态代理
        //被代理对象
        People english=new English();
        //代理对象，将被代理对象传入
        InvocationHandler handler=new PeopleProxy(english);
        //获取真实对象的类加载器
        ClassLoader loader = english.getClass().getClassLoader();
        //获取真实对象实现的接口列表
        Class[] interfaces = english.getClass().getInterfaces();
        //通过Proxy.newProxyInstance()方法生成动态代理类对象
        People subject = (People) Proxy.newProxyInstance(loader, interfaces, handler);
//        //打印动态代理对象的类型，即代理类的全限定名
//        System.out.println("动态代理对象的类型："+subject.getClass().getName());
        //调用方法
        subject.speak();

        //被代理对象
        People USA=new American();
        //代理对象，将被代理对象传入
        InvocationHandler handler2=new PeopleProxy(USA);
        //获取真实对象的类加载器
        ClassLoader loader2 = USA.getClass().getClassLoader();
        //获取真实对象实现的接口列表
        Class[] interfaces2 = USA.getClass().getInterfaces();
        //通过Proxy.newProxyInstance()方法生成动态代理类对象
        People subject2 = (People) Proxy.newProxyInstance(loader2, interfaces2, handler2);
//        //打印动态代理对象的类型，即代理类的全限定名
//        System.out.println("动态代理对象的类型："+subject2.getClass().getName());
        //调用方法
        subject2.speak();


    }

}