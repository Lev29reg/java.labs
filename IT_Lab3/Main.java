public class Main{
    public int num = 0;
    public static void main(String[] args) {

        Products info = new Products();
        String[][] newInfo = info.getInfo();
        int getI = 5;
        int rem_1 = 5;
        int rem_2 = 3;

        HashTable table = new HashTable(5);

        table.put(5, "product-" + newInfo[0][0] + ", price-" +  newInfo[1][0] +
                ", count-" +  newInfo[2][0]);
        table.put(2, "product-" + newInfo[0][1] + ", price-" +  newInfo[1][1] +
                ", count-" +  newInfo[2][1]);
        table.put(12, "product-" + newInfo[0][2] + ", price-" +  newInfo[1][2] +
                ", count-" +  newInfo[2][2]);

        System.out.println("Table size: " + table.size());
        System.out.println("Info of product number " + 2 + ": " + table.get(2));
        System.out.println("Info of product number " + getI + ": " + table.get(getI));
        System.out.println("Info of product number " + 1 + ": " + table.get(1));
        System.out.println("Table is empty: " + table.isEmpty());
        System.out.println();
        table.output();
        System.out.println();

        System.out.println("Removed info for product number " + rem_1 + ": " + table.remove(rem_1));
        System.out.println("Removed info for product number " + rem_2 + ": " + table.remove(rem_2));
        System.out.println("Table size: " + table.size());
        System.out.println();
        table.output();
    }
}