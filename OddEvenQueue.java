import java.util.Random;

class Node {

    int info;
    Node link;

    public Node(int info, Node link) {
        this.info = info;
        this.link = link;
    }

    public Node(int info) {
        this(info, null);
    }

    public Node() {
        this(0, null);
    }

    public int getInfo() {
        return this.info;
    }

    public Node getLink() {
        return this.link;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public void setLink(Node link) {
        this.link = link;
    }

    public String toString() {
        return "" + this.info;
    }
}

class Queue {

    private Node queueFront = null;
    private Node queueRear = null;
    private int count = 0;

    public void initializeQueue() {
        queueFront = null;
        queueRear = null;
        count = 0;
    }

    public boolean isEmptyQueue() {
        return (queueFront == null);
    }

    public boolean isFullQueue() {
        return false;
    }

    public int front() {
        if (isEmptyQueue()) {

        }
        return queueFront.getInfo();
    }

    public int back() {
        if (isEmptyQueue()) {

        }
        return queueRear.getInfo();
    }

    public void enQueue(int newItem) {
        Node newNode = new Node(newItem);
        if (queueFront == null) {
            queueFront = newNode;
            queueRear = newNode;
        } else {
            queueRear.setLink(newNode);
            queueRear = queueRear.getLink();
        }
        count++;
    }

    public int deQueue() {
        int itemInfo;
        if (isEmptyQueue()) {

        }
        itemInfo = queueFront.getInfo();
        queueFront = queueFront.getLink();
        if (queueFront == null) {
            queueRear = null;
        }
        count--;
        return itemInfo;
    }

    public int getSize() {
        return count;
    }

    public String toString() {
        Node trav = queueFront;
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

public class OddEvenQueue {

    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static void main(String[] args) {
        Random random = new Random();
        Queue queue = new Queue();
        Queue queueEven = new Queue();
        Queue queueOdd = new Queue();

        int n = generateRandomNumber(10, 20);
        for (int i = 0; i < n; i++) {
            int randomNumber = generateRandomNumber(0, 100);
            queue.enQueue(randomNumber);
            if (randomNumber % 2 == 0) {
                queueEven.enQueue(randomNumber);
            } else {
                queueOdd.enQueue(randomNumber);
            }
        }

        System.out.println("--- Random Numbers " + "[" + queue.getSize() + "] " + "---");
        System.out.println(queue);
        System.out.println("--- Even Queue " + "[" + queueEven.getSize() + "] " + "---");
        System.out.println(queueEven);
        System.out.println("--- Odd Queue " + "[" + queueOdd.getSize() + "] " + "---");
        System.out.println(queueOdd);

        int round = 0;
        int evenCount = 0;
        int oddCount = 0;
        while (queueEven.getSize() > 0 && queueOdd.getSize() > 0) {
            round++;
            if (queueEven.front() > queueOdd.front()) {
                evenCount++;
                queueEven.deQueue();
                queueOdd.enQueue(queueOdd.front());
                queueOdd.deQueue();
                if (queueEven.getSize() == 0) {
                    System.out.println("===> Winner is Even!");
                    System.out.print("Round=" + round + ", ");
                    System.out.print("Win=(E:" + evenCount + ",O:" + oddCount + "), ");
                    System.out.println("Odd Left=" + queueOdd.getSize());

                }
            } else {
                oddCount++;
                queueOdd.deQueue();
                queueEven.enQueue(queueEven.front());
                queueEven.deQueue();
                if (queueOdd.getSize() == 0) {
                    System.out.println("===> Winner is Odd!");
                    System.out.print("Round=" + round + ", ");
                    System.out.print("Win=(E:" + evenCount + ",O:" + oddCount + "), ");
                    System.out.println("Even Left=" + queueEven.getSize());
                }
            }
        }

    }
}