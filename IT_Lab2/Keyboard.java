public class Keyboard extends ComputerPerifery {
    private String lighting;
    public Keyboard(String name_, String color_, int age_, String lighting_){ // конструктор инициализации
        super(name_, color_, age_);
        lighting = lighting_;
    }
    public Keyboard(){ // конструктор по умолчанию
        this("Key", "white", 2, "Green");
    }
    public String getLighting() {return lighting;} // геттер
    public void setCourse(String val){lighting = val;} // сеттер

    @Override
    public String info(){
        String age_s = String.valueOf(age);
        return "Name: " + name + ", Color: " + color + ", Age: " + age_s + ", Lighting: " + lighting;
    }

    public static void main(String[] args){
        Keyboard key1 = new Keyboard("Key1", "White", 2, "Red");
        Keyboard key2 = new Keyboard();
        System.out.println(key1.info());
        System.out.println(key2.info());
        System.out.println(key1.getAge());
        key2.coloring();
        key2.birthday();
        System.out.println(key2.info());
    }
}
