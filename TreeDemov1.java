class Node{
	   int value;
	   Node left, right;
	   
	   public Node(int value){
	      this.value = value;
	      left = null;
	      right = null;
	   }

	}

	class BinarySearchTree{

	   Node root;
	  
	   
	   /*
	   recursive insert method
		
	   */
	   /*
	   inserts a node into the tree
	   */
	   public void insert(int value){
	      //tree is empty
	      if(root == null){
	         root = new Node(value);
	         return;
	      }else{
	         Node current = root;
	         Node parent = null;
	         
	         while(true){
	            parent = current;
	            
	            if(value < current.value){
	               current = current.left;
	               if(current == null){
	                  parent.left = new Node(value);
	                  return;
	               }
	            }else{
	               current = current.right;
	               if(current == null){
	                  parent.right = new Node(value);
	                  return;
	               }
	            }
	           
	         }//closing while
	      
	      }//closing main if-else 
	   }
	   
	    /**
		 * Performs a pre-order traversal of the binary search tree and prints each node's value.
		 * 
		 * @param root The starting node for the traversal.
		 */
		public void preOrderTraversal(Node root) 
		{
			if (root != null) 
			{
				System.out.print(root.value + " ");
				preOrderTraversal(root.left);
				preOrderTraversal(root.right);
			}//end conditional
		}//end method

	   
	   
	    /**
		 * Performs an in-order traversal of the binary search tree and prints each node's value.
		 * 
		 * @param root The starting node for the traversal.
		 */
		public void inOrderTraversal(Node root) 
		{
			if (root != null) 
			{
				inOrderTraversal(root.left);
				System.out.print(root.value + " ");
				inOrderTraversal(root.right);
			}//end conditional
		}//end method
	   
	   
	   
	    /**
		 * Performs a post-order traversal of the binary search tree and prints each node's value.
		 * 
		 * @param root The starting node for the traversal.
		 */
		public void postOrderTraversal(Node root) 
		{
			if (root != null) 
			{
				postOrderTraversal(root.left);
				postOrderTraversal(root.right);
				System.out.print(root.value + " ");
			}//end conditional
		}//end method
	   
	   
	   
	    /**
		 * Searches for a node with a specific value in the binary search tree.
		 * 
		 * @param root The starting node for the search.
		 * @param key  The value to search for.
		 * @return True if a node with the value is found, false otherwise.
		 */
		public boolean find(Node root, int key) 
		{
			if (root == null) 
			
				return false;
			} 
			else if (root.value == key) 
			{
				return true;
			} 
			else if (root.value > key) 
			{
				return find(root.left, key);
			} 
			else 
			{
				return find(root.right, key);
			}//end conditionals
		}//end method
	   
	   
	   
	    /**
		 * Finds the minimum value in the binary search tree.
		 * 
		 * @param root The starting node for finding the minimum value.
		 * @return The minimum value in the tree.
		 */
		public int getMin(Node root) 
		{
			if (root.left == null) 
			{
				return root.value;
			} 
			else 
			{
				return getMin(root.left);
			}//end conditional
		}//end method
	  
	  
	  
	   /**
		 * Finds the maximum value in the binary search tree.
		 * 
		 * @param root The starting node for finding the maximum value.
		 * @return The maximum value in the tree.
		 */
		public int getMax(Node root) 
		{
			if (root.right == null) 
			{
				return root.value;
			} 
			else 
			{
				return getMax(root.right);
			}//end conditional
		}//end method
	   
	   
	   
	   /*
	   this method will not compile until getMax
	   is implemented
	   */
	   public Node delete(Node root, int key){
	      
	      if(root == null){
	         return root;
	      }else if(key < root.value){
	         root.left = delete(root.left, key);
	      }else if(key > root.value){
	         root.right = delete(root.right, key);
	      }else{
	         //node has been found
	         if(root.left==null && root.right==null){
	            //case #1: leaf node
	            root = null;
	         }else if(root.right == null){
	            //case #2 : only left child
	            root = root.left;
	         }else if(root.left == null){
	            //case #2 : only right child
	            root = root.right;
	         }else{
	            //case #3 : 2 children
	            root.value = getMax(root.left);
	            root.left = delete(root.left, root.value);
	         }
	      }
	      return root;  
	   }
	   
	   
	   
	}



	public class TreeDemo{
	   public static void main(String[] args){
	      BinarySearchTree t1  = new BinarySearchTree();
	      t1.insert( 24);
	      t1.insert(80);
	      t1.insert(18);
	      t1.insert(9);
	      t1.insert(90);
	      t1.insert(22);
	            
	      System.out.print("in-order :   ");
	      t1.inOrderTraversal(t1.root);
	      System.out.println();
	           
	      
	   }  
	}
