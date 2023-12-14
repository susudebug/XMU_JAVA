public class English implements People{
    private String name="English";
    public English(){

    }
    public English(String name){
        this.name=name;
    }
    @Override
    public void speak(){
        System.out.println(name+" speaks "+name);
        System.out.println("After speaking\n");
    }
}
