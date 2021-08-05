package Assignment4Trees;

import java.util.Scanner;

public class SumNodes {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        SumNodes m = new SumNodes();
        BinaryTree bt = m.new BinaryTree();
        System.out.println(bt.sumOfNodes());
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

            // left
            boolean hlc = scn.nextBoolean();

            if (hlc) {
                child.left = this.takeInput(child, true);
            }

            // right
            boolean hrc = scn.nextBoolean();

            if (hrc) {
                child.right = this.takeInput(child, false);
            }

            // return
            return child;
        }

        public int sumOfNodes() {
            return this.sumOfNodes(this.root) ;
        }
        int temp;
        public void inOrder(Node root){
            if(root == null){
                return;
            }
            inOrder(root.left);
            temp += root.data;
            inOrder(root.right);
        }
        private int sumOfNodes(Node root) {
            inOrder(root);
            return temp;
        }
    }
}

