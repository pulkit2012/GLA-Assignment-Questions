package Assignment4Trees;

import java.util.Scanner;

public class TreeFromInorderPostOrder {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        TreeFromInorderPostOrder m = new TreeFromInorderPostOrder();
        int[] post = takeInput();
        int[] in = takeInput();
        BinaryTree bt = m.new BinaryTree(post, in);
        bt.display();
    }

    public static int[] takeInput() {
        int n = scn.nextInt();

        int[] rv = new int[n];
        for (int i = 0; i < rv.length; i++) {
            rv[i] = scn.nextInt();
        }

        return rv;
    }

    private class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
        }

        private Node root;
        private int size;

        public BinaryTree(int[] post, int[] in) {
            this.root = this.construct(in, post, 0, in.length - 1, 0, post.length - 1);
        }

        private Node construct(int[] in, int[] post, int inStrt, int inEnd, int postStrt, int postEnd) {
            if (inStrt > inEnd)
                return null;
            Node node = new Node();
            node.data = post[postEnd];
            if (inStrt == inEnd)
                return node;
            int iIndex = search(in, inStrt, inEnd, node.data);
            node.left = construct(in, post, inStrt, iIndex - 1, postStrt, postStrt - inStrt + iIndex - 1);
            node.right = construct(in, post, iIndex + 1, inEnd, postEnd - inEnd + iIndex, postEnd - 1);

            return node;
        }
        int search(int arr[], int strt, int end, int value)
        {
            int i;
            for (i = strt; i <= end; i++) {
                if (arr[i] == value)
                    break;
            }
            return i;
        }


        public void display() {
            this.display(this.root);
        }

        private void display(Node node) {
            if (node == null) {
                return;
            }

            String str = "";

            if (node.left != null) {
                str += node.left.data;
            } else {
                str += "END";
            }

            str += " => " + node.data + " <= ";

            if (node.right != null) {
                str += node.right.data;
            } else {
                str += "END";
            }

            System.out.println(str);

            this.display(node.left);
            this.display(node.right);
        }

    }

}

