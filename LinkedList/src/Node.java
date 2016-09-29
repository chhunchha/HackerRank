public class Node {
    Node next;
    int data;

    public Node(int data){
        this.data = data;
    }

    public String toString() {
        return this.data + "";
        //+ " -> " + (this.next != null ? this.next.data : "null");
    }
}