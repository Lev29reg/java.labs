public abstract class ComputerPerifery {
    protected String name;
    protected String color;
    protected int age;
    public ComputerPerifery(String name_, String color_, int age_){ // конструктор инициализации
        name = name_;
        color = color_;
        age = age_;
    }
    public ComputerPerifery(){ // конструктор по умолчанию
        this("Comp", "white", 3);
    }
    public String getName() {return name;} // геттер
    public String getColor() {return color;}
    public int getAge() {return age;}
    public void setName(String val){name = val;} // сеттер
    public void setColor(String val){color = val;}
    public void setAge(int val){age = val;}
    public void birthday(){age += 1;}
    public void coloring(){setColor("Purple");}
    public String info(){
        String age_s = String.valueOf(age);
        return "Name: " + name + ", Color: " + color + ", Age: " + age_s;
    }
}
