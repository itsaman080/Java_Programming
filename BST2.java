class BST2 {

    class Node {
        int data;
        Node left, right;

        public Node(int ele) {
            data = ele;
            left = right = null;
        }
    }

    Node root;
    public BST2() {
        root = null;
    }

    void insert(int data) {
        root = insertRec(root, data);
    }

    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    void inorder() {
        inorderRec(root);
    }
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
    
    boolean search(int key) {
        return searchRec(root, key);
    }
    boolean searchRec(Node root, int key) {
        if (root == null || root.data == key) {
            return root != null;
        }
        if (root.data < key) {
            return searchRec(root.right, key);
        }
        return searchRec(root.left, key);
    }

    void delete(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.data) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.data) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public static void main(String[] args) {
        BST2 tree = new BST2();
        
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the BST:");
        tree.inorder();

        System.out.println("\nSearch for 40 in the tree: " + tree.search(40)); 
        System.out.println("Search for 25 in the tree: " + tree.search(25)); 

        System.out.println("\nDelete 20 from the tree");
        tree.delete(20);
        tree.inorder();

        System.out.println("\nDelete 30 from the tree");
        tree.delete(30);
        tree.inorder();
    }
}
