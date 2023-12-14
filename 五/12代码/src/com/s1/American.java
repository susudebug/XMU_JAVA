public class American implements People{
    private String name="USA";
    public American(){

    }
    public American(String name){
        this.name=name;
    }
    @Override
    public void speak(){
        System.out.println(name+" speaks "+name);
        System.out.println("After speaking\n");
    }
}
