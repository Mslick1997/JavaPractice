import java.util.Random;

class Stack {

    private int stackSize = 0;
    private Node stackTop = null;

    public Stack() {
        stackTop = null;
    }

    public void initializeStack() {
        stackTop = null;
    }

    public boolean isEmptyStack() {
        return (stackTop == null);
    }

    public boolean isFullStack() {
        return false;
    }

    public void push(int newItem) {
        Node newNode = new Node(newItem);
        newNode.setLink(stackTop);
        stackTop = newNode;
        stackSize++;
    }

    public int peek() {
        return stackTop.getInfo();
    }

    public int pop() {
        int itemInfo;
        itemInfo = stackTop.getInfo();
        stackTop = stackTop.getLink();
        stackSize--;
        return itemInfo;
    }

    public int getSize() {
        return stackSize;
    }

    public String toString() {
        Node trav = stackTop;
        String str = "";
        while (trav != null) {
            str = str.concat(trav.toString());
            trav = trav.getLink();
            if (trav != null) {
                str = str.concat(" | ");
            }
        }
        return str;
    }
}

public class OddEvenStack {

    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static void main(String[] args) {
        Random random = new Random();    
        Stack stack = new Stack();
        Stack stackEven = new Stack();
        Stack stackOdd = new Stack();
        int n = generateRandomNumber(10, 20);

        for (int i = 0; i < n; i++) {
            int randomNumber = generateRandomNumber(0, 100);
            stack.push(randomNumber);
            if (randomNumber % 2 == 0) {
                stackEven.push(randomNumber);
            } else {
                stackOdd.push(randomNumber);
            }
        }

        System.out.println("--- Random Numbers " + "[" + stack.getSize() + "] " + "---");
        System.out.println(stack);
        System.out.println("--- Even Stack " + "[" + stackEven.getSize()+ "] " + "---");
        System.out.println(stackEven);
        System.out.println("--- Odd Stack " + "[" + stackOdd.getSize() + "] " + "---");
        System.out.println(stackOdd);

        while (stackEven.getSize()> 0 && stackOdd.getSize() > 0) {
            if (stackEven.peek() > stackOdd.peek()) {
                stackEven.pop();
                if (stackEven.getSize() == 0) {
                    System.out.println("===> Even is the winner!");
                }
            } else {
                stackOdd.pop();
                if (stackOdd.getSize() == 0) {
                    System.out.println("===> Odd is the winner!");
                }
            }
        }

    }
}
