package Assignment4Trees;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayLIstOfLevels {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayLIstOfLevels m = new ArrayLIstOfLevels();
        BinaryTree bt1 = m.new BinaryTree();
        System.out.println(bt1.levelOrder(bt1.root));
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

        public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
            ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
            if(root==null) return result;
            ArrayList<Node> list=new ArrayList<Node>();
            list.add(root);
            while(!list.isEmpty())
            {
                ArrayList<Node> Tplist=new ArrayList<Node>();
                ArrayList<Integer> level=new ArrayList<Integer>();
                while(!list.isEmpty())
                {
                    Node node=list.remove(0);
                    level.add(node.data);
                    if(node.left!=null) Tplist.add(node.left);
                    if(node.right!=null) Tplist.add(node.right);
                }
                result.add(level);
                list=Tplist;
            }
            return result;
        }

    }

}

