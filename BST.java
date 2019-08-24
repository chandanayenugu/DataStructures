import java.util.*;

public class BST{
	 class Node{
		int data;
		Node lchild;
		Node rchild;
		public Node(int a){
			data =  a;
			lchild = null;
			rchild = null;
		}
	}
	Node root;
    TreeNode(){
    	root = null;
    }
	public void insert(int num){
		root = insertValues(num,root);
	}
	public void inOrder(){
	       inOrderTraversal(root);
	    }
	public void delete(int data){
		root = deleteNode(data,root);
	}

	public Node insertValues(int d,Node root){
		if(root == null){
			root = new Node(d);
			return root;
		}
		else if(root.data<d){
		    root.rchild = insertValues(d,root.rchild);
		}
		else{
			root.lchild = insertValues(d,root.lchild);
		}
		return root;
	}

	public void inOrderTraversal(Node root){
		 if(root != null){
			inOrderTraversal(root.lchild);
			System.out.print(root.data + " ");
			inOrderTraversal(root.rchild);
		}
	}

	 public Node deleteNode(int key,Node root){
		 if(root == null){
			 return root;
		 }
		 if(key<root.data){
			 root.lchild = deleteNode(key,root.lchild);
		 }
		 else if(key > root.data){
			 root.rchild = deleteNode(key,root.rchild);
		 }
		 else{
			 if(root.lchild == null){
				 return root.rchild;
			 }
			 else if(root.rchild == null){
				 return root.lchild;
		      }
		 root.data = maxnode(root.lchild);
		 System.out.println("predecessor is :" + root.data);
		 root.lchild = deleteNode(root.data,root.lchild);
		 }
	   return root;
	 }
	 public int maxnode(Node root){
		 int max = root.data;
		 if( root.rchild == null){
			 max = root.data;
		 }
		 else{
			  return maxnode(root.rchild);
		 }
		 System.out.println("max is :" + max);
		 return max;
	 }
	public static void main(String[]args){
		BST tree1 = new BST();
		try{
		tree1.insert(9);
		tree1.insert(6);
		tree1.insert(4);
		tree1.insert(11);
		tree1.insert(24);
		tree1.insert(14);
		tree1.insert(10);
		tree1.insert(17);
		tree1.insert(3);
		tree1.insert(42);
		tree1.insert(15);
		tree1.insert(30);
		tree1.insert(8);
		tree1.insert(20);
		tree1.insert(25);
		System.out.println("In-orderTraversal");
		tree1.inOrder();
		tree1.delete(3);
		System.out.println("\nIn-order traversal after deleting leaf 3");
		tree1.inOrder();
		System.out.println("\nIn-order traversal after deleting internal node 24");
		tree1.delete(24);
		tree1.inOrder();
		}catch(NullPointerException e){
			System.out.println("exception found");
		}
	}

}
