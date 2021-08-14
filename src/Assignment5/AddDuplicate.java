package Assignment5;

import java.util.Scanner;

public class AddDuplicate {
    class Node {
        int val;
        Node left;
        Node right;
    }

    private Node createTreeInSequence(int val, Node root) {
        if (root == null) {
            root = new Node();
            root.val = val;
            root.left = new Node();
            root.left.val = val;
            return root;
        }
        if (val > root.val) {
            root.right = createTreeInSequence(val, root.right);
        } else if (val < root.val) {
            root.left = createTreeInSequence(val, root.left);
        }
        return root;
    }

    private Node createTreeBySortedInOrder(int[] nodeArr, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        Node root = new Node();
        root.val = nodeArr[mid];
        root.left = createTreeBySortedInOrder(nodeArr, left, mid - 1);
        root.right = createTreeBySortedInOrder(nodeArr, mid + 1, right);
        return root;
    }

    private void display(Node root) {
        if (root == null) {
            return;
        }
        String left = root.left == null ? "END" : String.valueOf(root.left.val);
        String right = root.right == null ? "END" : String.valueOf(root.right.val);
        System.out.println(left + " => " + root.val + " <= " + right);
        display(root.left);
        display(root.right);
    }

    int sum;

    private void sumOfNodes(Node root) {
        if (root == null) {
            return;
        }
        sumOfNodes(root.right);
        int temp = root.val;
        root.val = sum;
        sum = sum + temp;
        sumOfNodes(root.left);
    }

    public void createTree(int[] nodeArray) {

//        Node root = createTree(nodeArray, 0, nodeArray.length - 1);

        Node root = new Node();
        root.val = nodeArray[0];
        root.left = new Node();
        root.left.val = nodeArray[0];
        for (int i = 1; i < nodeArray.length; i++) {
            createTreeInSequence(nodeArray[i], root);
        }
        sum = 0;
//        sumOfNodes(root);
        display(root);

    }

    public static void main(String[] args) {
        AddDuplicate obj = new AddDuplicate();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        obj.createTree(arr);
    }

}
