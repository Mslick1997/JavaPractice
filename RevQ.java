import java.util.Scanner;

public class RevQ {

    public static void inputQ(Queue q) {
        Scanner keyboard = new Scanner(System.in);
        int data;
        try {
            do {
                data = keyboard.nextInt();
                if (data >= 0) {
                    q.enQueue(data);
                }
            } while (data >= 0);
        } catch (Exception e) {
        }
    }

    public static void showQ(Queue q) {
        if(q.getSize()!=0){
            q.print();
        }
    }

    public static void reverseOddQ(Queue q) {
        Queue q1 = new Queue();
        Stack s = new Stack();
        try {
            int size = q.getSize();
            for (int i = 0; i < size; i++) {
                if ((int) q.front() % 2 == 0) {
                    q1.enQueue(q.front());
                    q.deQueue();
                } else {
                    s.push(q.front());
                    q1.enQueue(-1);
                    q.deQueue();
                }
            }
            q.initializeQueue();
            for (int i = 0; i < size; i++) {
                if ((int)q1.front() < 0) {
                    q.enQueue(s.peek());
                    s.pop();
                    q1.deQueue();
                   continue;
                }
                q.enQueue(q1.front());
                q1.deQueue();

            }
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        inputQ(q);
        reverseOddQ(q);
        showQ(q);
    }
}
