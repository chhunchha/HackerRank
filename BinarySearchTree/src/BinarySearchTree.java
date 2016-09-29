/**
 * Created by chhunchha on 9/29/16.
 */
public class BinarySearchTree {

    public static void main(String args[]){
        BinaryTree bt = new BinaryTree();

        Node node4 = new Node(4);
        Node node2 = new Node(2);
        Node node5 = new Node(5);
        Node node1 = new Node(1);
        Node node3 = new Node(3);

        bt.root = node4;

        node4.left = node2;
        node4.right = node5;

        node2.left = node1;
        node2.right = node3;

        bt.inOrderTraverse();
        System.out.println("\nIs BST " + bt.isBST());


        bt = new BinaryTree();

        node4 = new Node(4);
        node2 = new Node(2);
        node5 = new Node(5);
        node1 = new Node(1);
        node3 = new Node(3);

        bt.root = node3;

        node3.left = node2;
        node3.right = node5;

        node2.left = node1;
        node2.right = node4;

        bt.inOrderTraverse();
        System.out.println("\nIs BST " + bt.isBST());
    }
}
