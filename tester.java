import java.util.HashMap;
import java.util.Random;

public class tester {
    public static int ran(int min, int max){
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    public static void main(String[] args) {
        // Create Lookup Table by HashMap
        HashMap<String, Integer> Number = new HashMap<>();

        // Add info in Lookup Table
        Random random = new Random();
        Number.put("n1", random.nextInt(10) );
        Number.put("n2", random.nextInt());
        Number.put("n3", random.nextInt());
        Number.put("n4", ran(10, 20));
        Number.put("n5", random.nextInt());

        // Search score of student from number
        String key = "n4";
        if (Number.containsKey(key)){
            System.out.println("number in "+ key + " = " + Number.get(key));
        }
        else {
            System.out.println("Not found");
        }
    }
}