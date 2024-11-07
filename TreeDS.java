import java.util.Random;
import java.util.Scanner;

class Tree {

    private Object info = null;
    private Tree left = null;
    private Tree right = null;

    public Tree(Object info, Tree left, Tree right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    public Tree(Object info) {
        this(info, null, null);
    }

    public Tree() {
        this(null, null, null);
    }

    public Object getInfo() {
        return this.info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public Tree getLeft() {
        return this.left;
    }

    public Tree getRight() {
        return this.right;
    }

    public void setLeft(Tree node) {
        this.left = node;
    }

    public void setRight(Tree node) {
        this.right = node;
    }

    public static void printPreOrder(Tree tree) {
        
        if (tree == null) {
            System.out.print(" - ");
            return;
        }
        System.out.print(" " + tree.getInfo() + " ");
        if (tree.getLeft() != null || tree.getRight() != null){
            System.out.print("[");
        }
        if (tree.getLeft() == null && tree.getRight() == null){
            System.out.print("");
        }
        else {
            printPreOrder(tree.getLeft());
            printPreOrder(tree.getRight());
        }
        if (tree.getLeft() != null || tree.getRight() != null){
            System.out.print("]");
        }
    }
    /*public static void printPreOrder(Tree tree) {
        if (tree == null) {
            System.out.print(" - ");
            return;
        }
        System.out.print(tree.getInfo());
        System.out.print(" [ ");
        printPreOrder(tree.getLeft());
        printPreOrder(tree.getRight());
        System.out.print(" ] ");
    }*/
    /*public static void printPreOrder(Tree tree) {
        if (tree == null) {
            System.out.print(" - ");
        } else {
            if (tree.getLeft() == null && tree.getRight() == null) {
                System.out.print(" " + (int) tree.getInfo() + " ");
            } else {
                System.out.print(" " + (int) tree.getInfo() + " ");
                System.out.print("[");
                printPreOrder(tree.getLeft());
                printPreOrder(tree.getRight());
                System.out.print("]");
            }
        }
    }*/
}

public class TreeDS{
    
    public static int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static boolean searchAndPrintSteps(Tree root, int target, String path) {
        if (root == null) {
            String nPath = path.substring(0, path.length() - 1);
            System.out.println(target + ": (" + nPath + ") Not Found!");
            return false;
        }

        if ((int) root.getInfo() == target) {
            System.out.println(target + ": (" + path + ") Found!");
            return true;
        }

        boolean found = false;

        if (target < (int) root.getInfo()) {
            found = searchAndPrintSteps(root.getLeft(), target, path + "L");
        } 
        else if (target >= (int) root.getInfo()){
            found = searchAndPrintSteps(root.getRight(), target, path + "R");
        }
        return found;
    }

    public static Tree insert(Tree root, int data) {
        if (root == null) {
            return new Tree(data);
        }
        if (data < (int) root.getInfo()) {
            root.setLeft(insert(root.getLeft(), data));
        } else if (data >= (int) root.getInfo()) {
            root.setRight(insert(root.getRight(), data));
        }
        return root;
    }

    public static int getHeight(Tree root) {
        if (root == null) {
            return -1;
        }

        int leftHeight = getHeight(root.getLeft());
        int rightHeight = getHeight(root.getRight());

        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        int n = randomNumber(10, 20);
        Tree bst = null;

        System.out.println("---Random numbers [" + n + "] ---");
        for (int i = 0; i < n; i++) {
            //int randomNumber = sc.nextInt();
            int randomNumber = randomNumber(0, 50);
            System.out.print(randomNumber + " ");
            bst = insert(bst, randomNumber);
        }
        System.out.println("");

        System.out.println("--- Tree (Height=" + getHeight(bst) + ") ---");
        Tree.printPreOrder(bst);
        System.out.println("");

        System.out.println("--- Search --- ");
        int target = randomNumber(0, 50);
        //int target = sc.nextInt();
        while (TreeDS.searchAndPrintSteps(bst, target, "") == false) {
            target = TreeDS.randomNumber(0, 50);
            //target = sc.nextInt();
        }
    }
}
