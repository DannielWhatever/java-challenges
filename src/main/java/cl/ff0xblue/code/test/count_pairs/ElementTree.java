package cl.ff0xblue.code.test.count_pairs;

/**
 * @author daniel
 */
public class ElementTree {



    private static Node insert(Node node, int data) {
        if (node==null) {
            node = new Node(data);
        }
        else {
            if (data <= node.data) {
                node.left = insert(node.left, data);
            }
            else {
                node.right = insert(node.right, data);
            }
        }
        return(node);
    }

    public static void main(String [] args) throws Exception{
        Node _root;
        int[] elements = new int[]{8,10,12,20,30,25,40};
        _root=null;
        boolean first = true;
        for(int e : elements){
            if(first) {
                _root = new Node(e);
                first = false;
                continue;
            }
            insert(_root, e);
        }

        int[] inputs = new int[]{30,10,12,15};
        for (int i : inputs) {
            System.out.println(isPresent(_root,i));
        }
    }

    private static class Node {
        Node left, right;
        int data;

        Node(int newData) {
            left = right = null;
            data = newData;
        }
    }

    //Solution:
    private static final int MAX = Double.valueOf(5 * Math.pow(10,4)).intValue();
    private static final int MIN = 1;

    private static int isPresent(Node root, int val){
        if( MIN > val  || val > MAX ){
            return 0;
        }
        return isPresentImpl(root, val);
    }

    private static int isPresentImpl(Node root, int val){
        if(root==null){
            return 0;
        }
        Node nextNode = val < root.data ? root.left : root.right;
        return root.data == val ? 1 : isPresentImpl(nextNode,val);
    }

}
