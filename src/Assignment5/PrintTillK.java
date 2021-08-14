package Assignment5;

import java.util.Scanner;

public class PrintTillK {
    class Node {
        int val;
        Node left;
        Node right;
    }


    private Node createTreeInSequence(int val, Node root) {
        if (root == null) {
            root = new Node();
            root.val = val;
            return root;
        }
        if (val > root.val) {
            root.right = createTreeInSequence(val, root.right);
        } else if (val < root.val) {
            root.left = createTreeInSequence(val, root.left);
        }
        return root;
    }

    private int printKFar(Node node, int target, int k) {
        if (node == null) {
            return -1;
        }
        if (node.val == target) {
            printkDown(node, k);
            return 0;
        }
        int distanceLeft = printKFar(node.left, target, k);

        if (distanceLeft != -1) {
            if (distanceLeft + 1 == k) {
                System.out.print(node.val);
                System.out.println("");
            } else {
                printkDown(node.right, k - distanceLeft - 2);
            }

            return distanceLeft + 1;
        }

        int distanceRight = printKFar(node.right, target, k);

        if (distanceRight != -1) {
            if (distanceRight + 1 == k) {
                System.out.print(node.val);
                System.out.println("");
            } else {
                printkDown(node.left, k - distanceRight - 2);
            }

            return distanceRight + 1;
        }
        return -1;
    }

    private void printkDown(Node node, int k) {
        if (node == null || k < 0) {
            return;
        }
        if (k == 0) {
            System.out.print(node.val);
            System.out.println("");
            return;
        }
        printkDown(node.left, k - 1);
        printkDown(node.right, k - 1);
    }


    private void implementNode(int[] nodesArr, int node, int k) {
        Node root = new Node();
        root.val = nodesArr[0];
        for (int i = 1; i < nodesArr.length; i++) {
            createTreeInSequence(nodesArr[i], root);
        }
        printKFar(root, node, k);

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int node = sc.nextInt();
        int k = sc.nextInt();
        PrintTillK obj = new PrintTillK();
        obj.implementNode(arr, node, k);
    }

}
