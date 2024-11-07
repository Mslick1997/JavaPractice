import java.util.HashSet;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class FindMatch {

    public static int hashFunction(int key, int size) {
        return key % (2 * size);
    }

    public static void linerProbing() {

    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        HashSet<Integer> uniqueSet = new HashSet<>();

        int size = random.nextInt(11) + 10;
        //int size = scan.nextInt();
        Map<Integer, Integer> ht = new HashMap<Integer, Integer>(size * 2);

        System.out.println("--- Random Numbers " + "[" + "\u001B[34m" + size + "\u001B[0m" + "]" + " ---");
        for (int i = 0; i < size;) {
            //int value = scan.nextInt();
            int value = random.nextInt(101);
            int index = hashFunction(value, size);

            if (ht.containsValue(value)) {
                System.out.print("\u001B[31m" + "!" + value + "\u001B[0m" + " ");
            } else {
                System.out.print(value + " ");
            }

            if (!ht.containsValue(value)) {
                while (ht.get(index) != null) {
                    index = (index + 1) % (size * 2);
                }
                ht.put(index, value);
                i++;
            }
        }
        System.out.println("");

        System.out.println("--- Hash Table " + "[" + "\u001B[34m" + ht.size() + "\u001B[0m" + "]" + " ---");
        for (int i = 0; i < size * 2; i++) {
            if (ht.get(i) != null) {
                String dokJan = i + ":" + ht.get(i);
                if (i != hashFunction(ht.get(i), size)) {
                    dokJan += "*";
                }
                System.out.print(dokJan + " ");
            }
        }
        System.out.println("");

        System.out.println("--- Finding Match ---");
        int countNum = 0;
        int countRound = 0;
        while (countNum < 3) {
            int m = random.nextInt(101);
            //int m = scan.nextInt();
            System.out.print("!" + m + " ");
            for (int i = 0; i < size * 2; i++) {
                if (ht.get(i) != null) {
                    int sum = ht.get(i) + m;
                    if (sum == 100) {
                        ht.remove(i);
                        countNum++;
                        System.out.print("\u001B[32m" + m + "\u001B[0m" + " ");
                    }
                }
            }
            countRound++;
        }
        System.out.println("");
        System.out.println("\u001B[36m" + "Total Finding: " + countRound + "\u001B[0m");

        System.out.println("--- Hash Table " + "[" + "\u001B[34m" + ht.size() + "\u001B[0m" + "]" + " ---");
        for (int i = 0; i < size * 2; i++) {
            if (ht.get(i) != null) {
                System.out.print(i + ":" + ht.get(i) + " ");
            }
        }
        System.out.println("");
    }
}