import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        int[] a = {1, 5, 2, 4, 3, 2};
        int[] b = {1, 4, 6, 1, 9, 8};
        int[] c = {1, 20, 30, 50, 40, 60, 70};
        int[] d = {1, 2, 3, 4, 5, 7, 6, 8, 9, 10};

        System.out.println("Before swap:");
        System.out.println("a array: " + Arrays.toString(a));
        System.out.println("b array: " + Arrays.toString(b));
        System.out.println("After swap:");
        exchangeValues(a,b);
        System.out.println("a array: " + Arrays.toString(a));
        System.out.println("b array: " + Arrays.toString(b));
        System.out.println("Nearly sorted array: " + Arrays.toString(c));
        sortAlmostSortedArray(c);
        System.out.println("Array sorted: " + Arrays.toString(c));
        System.out.println("Nearly sorted array: " + Arrays.toString(d));
        sortAlmostSortedArray(d);
        System.out.println("Array sorted: " + Arrays.toString(d));

        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.left = new Node (4);
        tree.right.right = new Node (5);

        Node subtree = new Node(3);
        subtree.left = new Node(4);
        subtree.right = new Node(5);

        Node secondSubtree = new Node(3);
        secondSubtree.left = new Node(4);
        System.out.println(isSubtree(tree,subtree));
        System.out.println(isSubtree(tree,secondSubtree));

    }

    // Here are two arrays of numbers. How to exchange values between arrays without any variable instantiation except for iterator for cycles?
    private static void exchangeValues(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] + b[i];
            b[i] = a[i] - b[i];
            a[i] = a[i] - b[i];
        }
    }

    // There is almost an ordered array of numbers. Only one element is not in the proper place. How to find that element and move it to the right place?
    private static void sortAlmostSortedArray(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] < array[i-1]) {
                for (int j = i - 1; j >= 0; j--) {
                    if (array[i] < array[j]) {
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
    }

    //  How to understand that tree is a part of another tree?
    // I assumed that we are only consider binary tree with left, right node

    private static boolean isSubtree(Node a, Node b) {
        if (a == null) return false;
        else if (isTheSameTree(a,b)) return true;
        else return isSubtree(a.left,b) || isSubtree(a.right,b);
    }

    private static boolean isTheSameTree(Node a, Node b) {
        if (a == null || b == null) return a == null && b == null;
        else if (a.value == b.value) return isTheSameTree(a.left,b.left) && isTheSameTree(a.right,b.right);
        else return false;
    }
}
