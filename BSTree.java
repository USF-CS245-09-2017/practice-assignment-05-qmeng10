
public class BSTree {
	
	//constructor
	private class BSTNode {	
		public Comparable data;
		public BSTNode left;
		public BSTNode right;
		
		BSTNode(Comparable newdata) {
			data = newdata;
			
		}
	}
    private BSTNode root;
    
	public void insert(Comparable elem) {
		root = insert(root, elem);
	}
	
	public boolean find(Comparable elem) {
		return find(root, elem);
	}
	public void delete(Comparable elem) {
		root = delete(root, elem);
	}
	
	//insert funtion that insert a node to the tree
	BSTNode insert(BSTNode tree, Comparable elem) {
		if(tree == null) {
			return new BSTNode(elem);
		}
		if(elem.compareTo(tree.data) < 0) {
			tree.left = insert(tree.left, elem);
			return tree;
		} else {
			tree.right = insert(tree.right, elem);
			return tree;
		}
	}
	
	//find function that return true if the value is in the tree
	public boolean find(BSTNode tree, Comparable elem) {
		if(tree == null) {
			return false;
		}
		if(elem.compareTo(tree.data) == 0) {
			return true;
		}
		if(elem.compareTo(tree.data) < 0) {
			return find(tree.left, elem);
		} else {
			return find(tree.right, elem);
		}
	}
	
	//delete function that delete the elem in the tree
	public BSTNode delete(BSTNode tree, Comparable elem) {
		if(tree == null) {
			return null;
		}
		if(tree.data.compareTo(elem) == 0) {
			if(tree.left == null) {
				return tree.right;
			}
			else if(tree.right == null) {
				return tree.left;
			} else {
				if(tree.right.left == null) {
					tree.data = tree.right.data;
					tree.right = tree.right.right;
					return tree;
				} else {
					tree.data = removeSmallest(tree.right);
					return tree;
				}
			}
		} else if(elem.compareTo(tree.data) < 0) {
			tree.left = delete(tree.left, elem);
			return tree;
		} else {
			tree.right = delete(tree.right, elem);
			return tree;
		}
	}
	
	//remove the smallest in the tree
	Comparable removeSmallest(BSTNode tree) {
		if(tree.left.left == null) {
			Comparable smallest = tree.left.data;
			tree.left = tree.left.right;
			return smallest;
		} else {
			return removeSmallest(tree.left);
		}
	}
	
	//return the string in ascending order
	public String toStringInOrder()	{
		return toStringInOrder(root).trim();
	}
	
	private String toStringInOrder(BSTNode node) {
		String s = "";
		if(node != null) {
			s = s + toStringInOrder(node.left) + node.data + " " + toStringInOrder(node.right);
		}
		return s;
	}
	
	public String toStringPreOrder() {
		return toStringPreOrder(root).trim();
	}
	
	//return the string in pre-order
	private String toStringPreOrder(BSTNode node) {	
		String s = "";
		if(node != null) {
			s = s + node.data + " " + toStringPreOrder(node.left) + toStringPreOrder(node.right);
		}
		return s;
	}
	
	//for test
//	public void print() {
//		print(root);
//	}
//	
//	void print(BSTNode tree) {
//		if(tree != null) {
//			print(tree.left);
//			System.out.println(tree.data);
//			print(tree.right);
//		}
//	}
	
}
