public class Stack {

    private int maxStackSize = 100;
    private int stackTop = 0;
    private Object[] list;

    public Stack() {
        list = new Object[maxStackSize];
    }

    public Stack(int size) {
        list = new Object[size];
        maxStackSize = size;
    }

    public void initializeStack() {
        for (int i = 0; i < stackTop; i++) {
            list[i] = null;
        }
        stackTop = 0;
    }

    public boolean isEmptyStack() {
        return (stackTop == 0);
    }

    public boolean isFullStack() {
        return (stackTop == maxStackSize);
    }

    public void push(Object newItem) throws Exception {
        if (isFullStack()) {
            throw new Exception("StackOverflow");
        }
        list[stackTop] = newItem; 
        stackTop++; 
    }

    public Object peek() throws Exception {
        if (isEmptyStack()) {
            throw new Exception("StackUnderflow");
        }
        return list[stackTop - 1];
    }

    public Object pop() throws Exception {
        Object itemInfo;
        if (isEmptyStack()) {
            throw new Exception("StackUnderflow");
        }
        stackTop--;
        itemInfo = list[stackTop];
        list[stackTop] = null;
        return itemInfo;
    }

    public int getSize() {
        return stackTop; 
    }

    public int getMaxSize() {
        return maxStackSize;
    }
    
    public void print(){
        System.out.print("[");
        for(int i=0;i<=stackTop;i++){
            System.out.print(list[i]+" ");
        }
        System.out.println("]");
    }
}
