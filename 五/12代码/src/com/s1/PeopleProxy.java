import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PeopleProxy implements InvocationHandler {

    //要代理的真实对象
    private Object target;
    public PeopleProxy(Object target){
        this.target=target;
    }
    //在InvocationHandler接口中的方法，用于处理代理类对象的方法调用
    public Object invoke(Object proxy, Method method,Object[] args) throws Throwable{
        System.out.println("Using dynamic proxy");
        System.out.println("In proxy,before speaking");
        method.invoke(target,args);
        return null;
    }

}
