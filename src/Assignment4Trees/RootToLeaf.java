package Assignment4Trees;

import java.util.ArrayList;
import java.util.Scanner;

public class RootToLeaf {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        RootToLeaf m = new RootToLeaf();
        BinaryTree bt1 = m.new BinaryTree();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(bt1.root.data);
        int target = scn.nextInt();
        bt1.inOrder(bt1.root, list, bt1.root.data, target);
    }

    private class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
        }

        private Node root;
        private int size;

        public BinaryTree() {
            this.root = this.takeInput(null, false);
        }

        public Node takeInput(Node parent, boolean ilc) {

            int cdata = scn.nextInt();
            Node child = new Node();
            child.data = cdata;
            this.size++;
            boolean hlc = scn.nextBoolean();

            if (hlc) {
                child.left = this.takeInput(child, true);
            }
            boolean hrc = scn.nextBoolean();

            if (hrc) {
                child.right = this.takeInput(child, false);
            }
            return child;
        }

        public void inOrder(Node root, ArrayList<Integer> list, int num, int target) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                if (num == target) {
                    for (int c : list) {
                        System.out.print(c + " ");
                    }
                }
                list.clear();
                return;
            }
            if (root.left != null) {
                list.add(root.left.data);
                num += root.left.data;
                inOrder(root.left, list, num, target);
            }
            if (root.right != null) {
                num += root.right.data;
                list.add(root.right.data);
                inOrder(root.right, list, num, target);
            }

        }
    }
}

