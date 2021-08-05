package Assignment4Trees;

import java.util.*;

public class Sibling {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        Sibling m = new Sibling();
        BinaryTree bt = m.new BinaryTree();
        bt.sibling();
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

            // return
            return child;
        }

        public void sibling() {
            this.sibling(this.root);
        }

        private void sibling(Node root) {
            if (root == null)
                return;
            Queue<Node> q1 = new LinkedList<>();
            q1.add(root);
            int flag = 0;
            Vector<Integer> v = new Vector<>();
            while (q1.isEmpty() == false) {
                Node temp = q1.peek();
                q1.remove();
                if (temp.left != null &&
                        temp.right == null) {
                    flag = 1;
                    v.add(temp.left.data);
                }
                if (temp.left == null &&
                        temp.right != null) {
                    flag = 1;
                    v.add(temp.right.data);
                }
                if (temp.left != null) {
                    q1.add(temp.left);
                }
                if (temp.right != null) {
                    q1.add(temp.right);
                }
            }
            Collections.sort(v);
            for (int i = 0; i < v.size(); i++) {
                System.out.print(v.get(i) + " ");
            }
            if (v.size() == 0) {
                System.out.print("-1");
            }
        }
    }
}



