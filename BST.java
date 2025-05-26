class Node {
    int data;
    Node left, right;

    public Node(int ele) {
        data = ele;
        left = right = null;
    }
}

class BST {
    
    Node root;
    public BST() {
        root = null;
    }
    
    Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    
    int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }
    
    Node delete(Node root, int key) {
        if (root == null) {
            return root;
        }
        
        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }
    boolean search(Node root, int key){
        if(root == null)
            return false;
        
        if(root.data == key)    
            return true;
        else if(root.data > key)
            return search(root.left,key);
        else
            return search(root.right,key);
    }

    public static void main(String[] args) {
        BST tree = new BST();
        
        tree.root = tree.insert(tree.root,48);
        tree.root = tree.insert(tree.root,30);
        tree.root = tree.insert(tree.root,20);
        tree.root = tree.insert(tree.root,10);
        tree.root = tree.insert(tree.root,25);
        tree.root = tree.insert(tree.root,5);
        tree.root = tree.insert(tree.root,15);
        tree.root = tree.insert(tree.root,60);
        tree.root = tree.insert(tree.root,78);
        tree.root = tree.insert(tree.root,53);
        tree.root = tree.insert(tree.root,89);
        tree.root = tree.insert(tree.root,80);
        tree.root = tree.insert(tree.root,90);

        System.out.println("Inorder traversal of the BST:");
        tree.inorder(tree.root);
        System.out.println();


        System.out.println("\nDeleting element from the tree");
        tree.delete(tree.root,120);
        tree.inorder(tree.root);
        System.out.println();
        
        System.out.println("searching: " + tree.search(tree.root,60));
    }
}
