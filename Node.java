/** Node class for holding data and reference to next node.*/
public class Node<T extends Comparable> {

    protected T data;
    protected Node<T> next;

    /** Node constructor 
     *  @param data     data for node to hold
     *  @param next     reference to next node
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }
}