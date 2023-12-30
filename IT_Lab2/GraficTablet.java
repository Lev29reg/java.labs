public class GraficTablet extends ComputerPerifery {
    private int inches;
    public GraficTablet(String name_, String color_, int age_, double inches_){ // конструктор инициализации
        super(name_, color_, age_);
        inches = (int) inches_;
    }
    public GraficTablet(){ // конструктор по умолчанию
        this("Tablet", "white", 2, 15);
    }
    public int getInches() {return inches;} // геттер
    public void setInches(int val){inches = val;} // сеттер
    public void setInches(double val){inches = (int) val;}
    @Override
    public String info(){
        String age_s = String.valueOf(age);
        return "Name: " + name + ", Color: " + color + ", Age: " + age_s + ", Inches: " + inches;
    }

    public static void main(String[] args){
        Headphones head1 = new Headphones("Head1", "brown", 5, "Red");
        Keyboard key1 = new Keyboard("Key1", "red", 3, "Blue");
        GraficTablet tablet1 = new GraficTablet();
        GraficTablet tablet2 = new GraficTablet("Tablet1", "blue", 2, 12);
        tablet1.setInches(15.5);
        tablet2.setInches(20);
        System.out.println(head1.info());
        System.out.println(key1.info());
        System.out.println(tablet1.info());
        System.out.println(tablet2.info());
    }
}
