public class LinkedList {

    Node head;

    public LinkedList(Node head) {
        this.head = head;
    }

    public void append(int data) {
        if(head == null) {
            head = new Node(data);
            return;
        }

        Node current = head;
        while(current.next != null) {
            current = current.next;
        }

        current.next = new Node(data);

    }

    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void deleteWithValue(int data) {
        if(head == null) return;

        if(head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while(current.next != null) {
            if(current.next.data == data) {
                current.next = current.next.next;
                return;
            }
        }
    }

    public void linkNodes(Node node1, Node node2) {
        node2.next = node1;
    }

    public Node getNodeAtIndex(int i) {
        Node current = head;
        int c = 1;
        while(current != null) {
            if(c == i) return current;
            current = current.next;
            c++;
        }

        return null;
    }

    public String toString() {
        if(hasLoop()) return "Linked list has loop!!";

        Node current = head;
        StringBuilder str = new StringBuilder();
        while(current != null) {
            str.append(current.data + " ");
            current = current.next;
        }
        return str.toString();
    }

    public boolean hasLoop() {

        if( head == null ) return false;
        Node slow = head;
        Node fast = head;

        while(fast.next !=null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }

        return false;
    }

    public Node findStartOfLoop() {
        if( head == null ) return null;
        Node slow = head;
        Node fast = head;

        while(fast.next !=null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }

        if(fast == null && fast.next == null)
            return null;

        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}