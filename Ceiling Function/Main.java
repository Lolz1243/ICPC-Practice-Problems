import java.io.*;
import java.util.HashSet;
import java.util.Set;

class Main {
    public static void main (String[] args){
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        try {
            String[] first = in.readLine().split(" ");
            int n = Integer.parseInt(first[0]);
            
            Set<String> set = new HashSet<>();
            
            for(int i = 0; i < n; i++) 
            {
                String[] next = in.readLine().split(" ");
                BinarySearchTree bst = new BinarySearchTree();
                
                for(String str : next)
                {
                    bst.add(Integer.parseInt(str));
                }
                set.add(bst.toString());
            }
            out.println(set.size());
        }
        catch(IOException e){
            //e.printStackTrace();
        }
        out.close();
    }
}

class BinarySearchTree{
    private Node root;
    
    private static class Node{
        private int data;
        private Node left;
        private Node right;
        
        private Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public BinarySearchTree(){
        this.root = null;
    }
    
    public void add(int n){
        this.root = addHelper(root,n);
    }
    
    private Node addHelper(Node node, int n){
        if(node == null) return new Node(n);
        if(node.data < n) node.right = addHelper(node.right,n);
        else node.left = addHelper(node.left, n);
        return node;
    }
    
    @Override
    public String toString(){
        if(root == null) return "";
        StringBuilder str = new StringBuilder();
        toStringHelper(root, str);
        return str.toString();
    }
    
    private void toStringHelper(Node node, StringBuilder str){
        if(node.left != null)
        {
            str.append("l");
            toStringHelper(node.left,str);
        }
        str.append('x');
        if(node.right != null)
        {
            str.append("r");
            toStringHelper(node.right, str);
        }
    }
}