package Assignment4Trees;

import java.util.Scanner;

public class TreeUsingInorderPreOrder {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        TreeUsingInorderPreOrder m = new TreeUsingInorderPreOrder();
        int[] pre = takeInput();
        int[] in = takeInput();
        BinaryTree bt = m.new BinaryTree(pre, in);
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

        public BinaryTree(int[] pre, int[] in) {
            this.root = this.construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
        }

        private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {

            // write your code here
            if(plo>phi)
                return null;
            int ind=find_index(pre[plo],in);
            Node nn = new Node();
            nn.data = in[ind];
            nn.left = construct(pre, plo + 1, plo + ind - ilo, in, ilo, ind- 1);
            nn.right = construct(pre, plo + 1 + ind - ilo, phi, in, ind + 1, ihi);
            return nn;
        }
        private int find_index(int data,int[] arr)
        {
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i]==data)
                    return i;
            }
            return -1;
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

