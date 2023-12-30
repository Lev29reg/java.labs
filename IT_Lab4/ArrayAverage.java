public class ArrayAverage {
    public static void main(String[] args) {
        String str = "1 2 3 4 5";
        String[] arr = str.split(" ");
        int sum = 0;

        try{
            for (int i = 0; i < arr.length; i++) {
                sum += Integer.parseInt(arr[i]);
            }
            System.out.println(sum / arr.length);
        } catch (IndexOutOfBoundsException e) {
            System.out.print("Выход за границу массива " + e.getMessage());
        } catch (NumberFormatException e){
            System.out.println("Неверные данные " + e.getMessage());
        }
    }
}
