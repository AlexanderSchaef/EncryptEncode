/**
Independent Project testing encoding and encryption.
Start date: 10/21/23
README.md in the github repo will be used for a checklist.
@author Alex Schaefer
@author Ashton Putnam
*
*
* This code below was generated using Chat-GPT with the prompt: "write a class in java that would enable me to construct a splay tree of characters found in a string"
*
*
*/


class SplayNode {
    char data;
    SplayNode left, right, parent;

    SplayNode(char data) {
        this.data = data;
        this.left = this.right = this.parent = null;
    }
}

public class SplayTree {
    private SplayNode root;

    private void zig(SplayNode x) {
        SplayNode parent = x.parent;
        if (parent.left == x) {
            parent.left = x.right;
            if (x.right != null) {
                x.right.parent = parent;
            }
            x.right = parent;
        } else {
            parent.right = x.left;
            if (x.left != null) {
                x.left.parent = parent;
            }
            x.left = parent;
        }
        x.parent = parent.parent;
        parent.parent = x;
        if (x.parent != null) {
            if (x.parent.left == parent) {
                x.parent.left = x;
            } else {
                x.parent.right = x;
            }
        } else {
            root = x;
        }
    }

    private void zigZig(SplayNode x) {
        zig(x.parent);
        zig(x);
    }

    private void zigZag(SplayNode x) {
        zig(x);
        zig(x);
    }

    private void splay(SplayNode x) {
        while (x.parent != null) {
            SplayNode parent = x.parent;
            SplayNode grandParent = parent.parent;
            if (grandParent == null) {
                zig(x);
            } else if ((grandParent.left == parent && parent.left == x) || (grandParent.right == parent && parent.right == x)) {
                zigZig(x);
            } else {
                zigZag(x);
            }
        }
    }

    public void insert(char data) {
        SplayNode newNode = new SplayNode(data);
        if (root == null) {
            root = newNode;
        } else {
            SplayNode temp = root;
            SplayNode parent = null;
            while (temp != null) {
                parent = temp;
                if (data < temp.data) {
                    temp = temp.left;
                } else if (data > temp.data) {
                    temp = temp.right;
                } else {
                    // Duplicate values not allowed
                    return;
                }
            }
            if (data < parent.data) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
            newNode.parent = parent;
            splay(newNode);
        }
    }

    private void inorderTraversal(SplayNode node) {
        if (node == null) return;
        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    public void printInorder() {
        inorderTraversal(root);
    }

    public static void main(String[] args) {
        String inputString = "hello";
        SplayTree splayTree = new SplayTree();

        for (char ch : inputString.toCharArray()) {
            splayTree.insert(ch);
        }

        System.out.println("Inorder traversal of constructed Splay Tree:");
        splayTree.printInorder();
    }
}