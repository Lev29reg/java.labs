public class Products {
    private String[][] info = {{"apple", "milk", "meat"},
            {"20", "80", "300"},
            {"100", "50", "20"}};
    public String[][] getInfo(){
        return info.clone();
    }
}
