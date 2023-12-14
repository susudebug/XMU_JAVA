//代理角色
public class ChineseProxy implements People{

    //需要代理的对象
    private Chinese people;
    public ChineseProxy(Chinese people){
        this.people=people;
    }
    @Override
    public void speak(){
        System.out.println("Using static proxy");
        System.out.println("In "+people.getName()+" Proxy, before speaking");
        people.speak();
    }
}
