package huffmancode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author chiko
 */

class huffmanNode{
    int data;   char c;
    huffmanNode left;
    huffmanNode right;
}
class MyComparator implements Comparator<huffmanNode>{
    
    public int compare(huffmanNode x, huffmanNode y) {
        return x.data - y.data;
    }
}

public class Huffmancode {
    
    public static void printCode(huffmanNode root, String s){
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println( root.c + "" + s);
            return;
        }
        
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }
    public static void main(String[] args) {
        int n = 6;
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] charFrequency = {5, 9, 12, 13, 16, 45};
        
        //sorting all the nodes in assending order 
         PriorityQueue<huffmanNode>q = new PriorityQueue<huffmanNode>(n, new MyComparator());
        
        for (int i = 0; i < n; i++) {
            huffmanNode hn = new huffmanNode();
            
            hn.c = charArray[i];
            hn.data = charFrequency[i];
            
            hn.left = null;
            hn.right = null;
            
            q.add(hn);
           
        }
        
        huffmanNode root = null;
        
        while (q.size() > 1) {
            //first min extract
            huffmanNode x = q.peek();
            q.poll();
            
            //second min extract
            huffmanNode y = q.peek();
            q.poll();
            
            //new node f which is equal
            huffmanNode f = new huffmanNode();
            
            //to the sum of the frequency of the two nodes 
            //assigning value to the f node
            f.data = x.data + y.data;
            f.c= '-';
            
            //first extracted node as left child
            f.left = x;
            
            //first extracted node as left child
            f.right = y;
            
            //marking the f node as the root node 
            root = f;
            
            //add this node to the priority queue
            q.add(f);
        }
        
        //print the nodes by traversing the tree
        printCode(root, " ");
    }
    
}
