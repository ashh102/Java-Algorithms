// Author: Ashley Maynez; Project #3

import java.util.Scanner;

public class MAYA3 {
	
	// Current node's left and right child and key value.
	class Node { 
		int key; 
		Node left;
		Node right; 
  
		public Node(int item) { 
			key = item; 
			left = null; 
			right = null;
		} 
	} 
  
	Node root; 
  
	MAYA3() {  
		root = null;  
	} 
    
	// TREE-INSERT
	void insert(int key) { 
		root = treeInsert(root, key); 
	} 
      
	Node treeInsert(Node root, int key) { 
		if (root == null) { 
			root = new Node(key); 
			return root; 
		}
		
		if (key < root.key) {
			root.left = treeInsert(root.left, key);
		}
		
		else if (key > root.key) {
			root.right = treeInsert(root.right, key); 
		}
 
		return root; 
	} 
  
    
    
	// Inorder traversal.
	void inorder()  { 
		inorder(root); 
	} 

	void inorder(Node node) { 
		if (node == null) { 
			return;
		}
        
		inorder(node.left);
		System.out.print(node.key + " ");
		inorder(node.right);   
	} 
    
    
    
	// Postorder traversal.
	void postorder() {
		postorder(root);
	}
    
	void postorder(Node node) {
		if (node == null) {
			return;
		}
    	
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.key + " ");
	}
    
    
    
	// Preorder traversal.
	void preorder() {
		preorder(root);
	}
    
	void preorder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.key + " ");
		preorder(node.left);
		preorder(node.right);
	}
    
    
    
	// TREE-SEARCH
	void search(int key){
		search(root, key);    
	}
    
	void search(Node node, int key) {
		if (node == null) {
			System.out.println("... " + node + ", does not exist in BST.");
			return;
		}
    	
		System.out.print(node.key + " ");
    	
		if (node.key == key) {
			System.out.print("... True, BST contains key " + key + ".");
			return;
		}
    	
		if (node.key > key) {
			search(node.left, key);
			return;
		}
		else {
			search(node.right, key);
			return;
		}	
	}
    
    
    
	// TREE-DELETE
	void delete(int key) { 
		root = delete(root, key); 
	} 
    
	Node delete(Node root, int key) { 
		if (root == null) {
			return root; 
		}
  
		if (key < root.key) {
			root.left = delete(root.left, key); 
		}
		
		else if (key > root.key) {
			root.right = delete(root.right, key); 
		}

		else { 
			if (root.left == null) {
				return root.right; 
			}
			
			else if (root.right == null) {
				return root.left; 
			}

			root.key = minimum(root.right); 
			root.right = delete(root.right, root.key); 
		} 
		return root; 
	} 
    
	int minimum(Node root) { 
		int min = root.key;
		
		while (root.left != null) { 
			min = root.left.key; 
			root = root.left; 
		} 
		return min; 
	} 
  
	
 
	public static void main(String[] args) {
		
		MAYA3 tree = new MAYA3();
		
		int [] arr = {30, 10, 45, 38, 20, 50, 25, 33, 8, 12};
		
		// Creates tree.
		for(int i = 0; i < arr.length; i++) {
			tree.insert(arr[i]);
		}
		
		boolean again = true;
		
		// Takes input from user until user terminates program.
		while (again) {
			again = false;
			System.out.println();
			System.out.print("Enter code: ");
			Scanner input = new Scanner(System.in);
			int operation = input.nextInt();
			
			switch (operation) {
				// Terminates program.
				case 0: 
					System.out.println("**Terminated.**");
					break;
				
				// Inorder traversal.
				case 1: 
					System.out.println("Inorder traversal: ");
					tree.inorder();
					System.out.println("");
					again = true;
					break;
					
				// Postorder traversal.
				case 2: 
					System.out.println("Postorder traversal: ");
					tree.postorder();
					System.out.println("");
					again = true;
					break;
					
				// Preorder traversal.
				case 3: 
					System.out.println("Preorder traversal: ");
					tree.preorder();
					System.out.println("");
					again = true;
					break;
					
				// TREE-SEARCH
				case 4: 
					System.out.println("TREE-SEARCH ");
					System.out.println("Key 38: ");
					System.out.print("Traverses: ");
					tree.search(38);
					System.out.println();
					System.out.println("Key 9: ");
					System.out.print("Traverses: ");
					tree.search(9);
					again = true;
					break;
					
				// TREE-DELETE
				case 5: 
					System.out.println("TREE-DELETE was called. 10 is deleted.");
					tree.delete(10);
					again = true;
					break;
				
				// Invalid entry.
				default:
					System.out.print("Invalid. ");
					again = true;
					break;
			}	
		}
	}
}
