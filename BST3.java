class Node {
    int data;
    Node left, right;

    public Node(int ele) {
        this.data = ele;
        this.left = this.right = null;
    }
}

public class BST3 {

    public static Node insertIntoBST(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data > root.data) {
            root.right = insertIntoBST(root.right, data);
        } else {
            root.left = insertIntoBST(root.left, data);
        }
        return root;
    }

    public static void createBST(Node root) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter data:");
        int data = scanner.nextInt();

        while (data != -1) {
            root = insertIntoBST(root, data);
            System.out.println("Enter data:");
            data = scanner.nextInt();
        }
    }

    public static void levelOrderTraversal(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp == null) {
                System.out.println();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
    }

    public static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static Node minValue(Node root) {
        if (root == null) {
            System.out.println("NO MIN VALUE");
            return null;
        }
        Node temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    public static Node maxValue(Node root) {
        if (root == null) {
            return null;
        }
        Node temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }

    public static boolean searchInBST(Node root, int target) {
        if (root == null) return false;
        if (root.data == target) return true;

        if (target > root.data) {
            return searchInBST(root.right, target);
        } else {
            return searchInBST(root.left, target);
        }
    }

    public static Node deleteFromBST(Node root, int target) {
        if (root == null) {
            return null;
        }

        if (root.data == target) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right == null) {
                return root.left;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else {
                Node maxi = maxValue(root.left);
                root.data = maxi.data;
                root.left = deleteFromBST(root.left, maxi.data);
                return root;
            }
        } else if (root.data > target) {
            root.left = deleteFromBST(root.left, target);
        } else {
            root.right = deleteFromBST(root.right, target);
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = null;
        createBST(root);

        levelOrderTraversal(root);

        System.out.println("Inorder:");
        inorder(root);
        System.out.println("\nPreorder:");
        preorder(root);
        System.out.println("\nPostorder:");
        postorder(root);

        Node minNode = minValue(root);
        if (minNode != null) {
            System.out.println("Min Value: " + minNode.data);
        }

        Node maxNode = maxValue(root);
        if (maxNode != null) {
            System.out.println("Max Value: " + maxNode.data);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value of target to delete:");
        int target = scanner.nextInt();

        while (target != -1) {
            root = deleteFromBST(root, target);
            System.out.println("\nLevel Order Traversal after deletion:");
            levelOrderTraversal(root);

            System.out.println("Enter the value of target to delete:");
            target = scanner.nextInt();
        }

        System.out.println("Enter the target value to search:");
        target = scanner.nextInt();

        while (target != -1) {
            boolean ans = searchInBST(root, target);
            if (ans) {
                System.out.println("Found");
            } else {
                System.out.println("Not Found");
            }

            System.out.println("Enter the target value to search:");
            target = scanner.nextInt();
        }
    }
}
