//真实对象
public class Chinese implements People{
    private String name="Chinese";
    public Chinese(){
    }
    public Chinese(String name){
        this.name=name;
    }
    //重写People中的方法
    public void speak(){
        System.out.println(name+" speaks "+name);
        System.out.println("After speaking\n");
    }

    public String getName() {
        return name;
    }
}
