import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        int N = Integer.parseInt(br.readLine());
        Tree tree = new Tree();
        
        for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	Node newNode = i == 0 ? tree.setRoot(new Node(st.nextToken().charAt(0))) : tree.find(st.nextToken().charAt(0));
        	String left = st.nextToken();
        	String right = st.nextToken();
        	
        	if(left != ".") newNode.left = new Node(left.charAt(0));
        	if(right != ".") newNode.right = new Node(right.charAt(0));
        }
        
        StringBuilder sb = new StringBuilder();
        tree.preorder(sb, tree.root);
        bw.write(sb.toString() + "\n");
        
        sb.setLength(0);
        tree.inorder(sb, tree.root);
        bw.write(sb.toString() + "\n");
        
        sb.setLength(0);
        tree.postorder(sb, tree.root);
        bw.write(sb.toString() + "\n");
        
        bw.flush();
        bw.close();
    }
    
    
}

class Tree {
	Node root;
	
	Tree() {}
	
	Node setRoot(Node n) {
		root = n;
		return root;
	}
	
	Node find(char data) {
	    return findRecursive(root, data);
	}

	Node findRecursive(Node cur, char data) {
	    if (cur == null) return null;
	    if (cur.data == data) return cur;

	    Node left = findRecursive(cur.left, data);
	    if (left != null) return left;

	    return findRecursive(cur.right, data);
	}
	
	void preorder(StringBuilder sb, Node cur) {
        if(cur.data != '.') sb.append(cur.data);
        if(cur.left != null) preorder(sb, cur.left);
        if(cur.right != null) preorder(sb, cur.right);
    }
    
    void inorder(StringBuilder sb, Node cur) {
        if(cur.left != null) inorder(sb, cur.left);
    	if(cur.data != '.') sb.append(cur.data);
        if(cur.right != null) inorder(sb, cur.right);
    }
    
    void postorder(StringBuilder sb, Node cur) {
        if(cur.left != null) postorder(sb, cur.left);
        if(cur.right != null) postorder(sb, cur.right);
    	if(cur.data != '.') sb.append(cur.data);
    }
}

class Node {
	char data;
	Node left;
	Node right;
	
	Node(char data) { this.data = data; }
}