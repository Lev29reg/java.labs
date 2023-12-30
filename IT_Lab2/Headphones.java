public class Headphones extends ComputerPerifery {
    private String lighting;
    private static int counter = 0;
    public Headphones(String name_, String color_, int age_, String lighting_){ // конструктор инициализации
        super(name_, color_, age_);
        lighting = lighting_;
        counter ++;
    }
    public Headphones(){ // конструктор по умолчанию
        this("Head", "black", 1, "Blue");
    }
    public String getLighting() {return lighting;} // геттер
    public void setLighting(String val){lighting = val;} // сеттер
    public int  getCounter() {return counter;}
    @Override
    public String info(){
        String age_s = String.valueOf(age);
        return "Name: " + name + ", Color: " + color + ", Age: " + age_s + ", Lighting: " + lighting;
    }

    public static void main(String[] args){
        Headphones head1 = new Headphones("Head1", "brown", 4, "Green");
        System.out.println(head1.getCounter());
        Headphones head2 = new Headphones();
        System.out.println(head1.getCounter());
        Keyboard key1 = new Keyboard("Key1", "red", 2, "Red");
        Keyboard key2 = new Keyboard();
        System.out.println(head1.info());
        System.out.println(head2.info());
        System.out.println(key1.getColor());
        System.out.println(key2.info());
    }
}
