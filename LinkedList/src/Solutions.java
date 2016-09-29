/**
 * Created by chhunchha on 9/29/16.
 */
public class Solutions {

    public static void main(String args[]) {

        Node head = new Node(1);
        LinkedList ls = new LinkedList(head);

        for(int i = 2; i <= 10 ; i++) {
            ls.append(i);
        }
        System.out.println("Linked list " + ls.toString());

        Node node1 = ls.getNodeAtIndex(3);
        Node node2 = ls.getNodeAtIndex(9);
        System.out.println(node1.toString());
        System.out.println(node2.toString());
        ls.linkNodes(node1, node2);

        System.out.println("Linked list has loop: " + ls.hasLoop());

        System.out.println("Lined list loops at : " + ls.findStartOfLoop().toString());
    }
}
