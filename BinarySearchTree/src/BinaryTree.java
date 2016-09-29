/**
 * Created by chhunchha on 9/29/16.
 */
public class BinaryTree {
    Node root;

    private boolean isBSTUtil(Node root, int min, int max) {
        if(root == null)
            return true;

        if(root.data > max || root.data < min)
            return false;

        return isBSTUtil(root.left, min, root.data - 1) && isBSTUtil(root.right, root.data + 1, max);
    }

    boolean isBST() {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private void inOrderTraverseRecursive(Node node){
        if(node.left != null) {
            inOrderTraverseRecursive(node.left);
        }
        System.out.print(" " + node.data + " ");
        if(node.right != null) {
            inOrderTraverseRecursive(node.right);
        }
    }

    void inOrderTraverse(){
        inOrderTraverseRecursive(root);
    }
}
