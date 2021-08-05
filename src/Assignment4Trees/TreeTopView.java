package Assignment4Trees;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TreeTopView {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        BinaryTree2 bt = new BinaryTree2(arr);

        bt.topView();

    }
}

class BinaryTree2 {
    private class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    BinaryTree2(String[] arr) {
        Queue<Node> queue = new LinkedList<Node>();
        construct(arr, 0, queue);
    }

    public void topView() {
        topView(this.root);
    }
    static class posData{
        int pos;
        Node node;

        public posData(int pos, Node node) {
            this.pos = pos;
            this.node = node;
        }
    }

    private void topView(Node root) {
        Map<Integer,Node> map = new TreeMap<>();
        int pos = 0;
        Queue<posData> queue = new LinkedList<>();
        queue.add(new posData(0,root));
        while(!queue.isEmpty()){
            posData temp = queue.poll();
            Node tempNode = temp.node;
            pos = temp.pos;
            if(!map.containsKey(pos)){
                map.put(pos,tempNode);
            }
            if(tempNode.left.data != -1){
                queue.add(new posData(pos-1,tempNode.left));
            }
            if(tempNode.right.data != -1){
                queue.add(new posData(pos+1,tempNode.right));
            }
        }
        for(Map.Entry<Integer,Node> m : map.entrySet()){
            System.out.print(m.getValue().data + " ");
        }
    }


    private void construct(String[] arr, int ind, Queue<Node> queue) {
        if (ind >= arr.length)
            return;
        if (queue.size() == 0) {
            Node nn = new Node(Integer.parseInt(arr[ind]));
            this.root = nn;
            queue.add(nn);
        } else {
            Node parent = queue.peek();
            if (parent.data != -1) {
                if (parent.left == null) {
                    parent.left = new Node(Integer.parseInt(arr[ind]));
                    queue.add(parent.left);
                } else {
                    if (parent.right == null) {
                        parent.right = new Node(Integer.parseInt(arr[ind]));
                        queue.add(parent.right);
                        queue.poll();
                    }
                }
            } else {
                queue.poll();
                ind--;
            }
        }
        construct(arr, ind + 1, queue);
    }

    public void display() {
        display_tree(this.root);
    }

    private void display_tree(Node root) {
        if (root == null)
            return;
        String str = root.data + "";
        if (root.left != null) {
            str = root.left.data + " <= " + str;
        } else {
            str = "END <= " + str;
        }

        if (root.right != null) {
            str = str + " => " + root.right.data;
        } else {
            str = str + " => END";
        }
        System.out.println(str);
        display_tree(root.left);
        display_tree(root.right);

    }


}
