import java.util.LinkedList;

/**
 * Class to implement a singly linked list
 *
 * @author Isabelle Wang
 * @version Spring 2024
 */

public class SLL<T> implements Phase1SLL {

    private NodeSL<T> head; 
    private NodeSL<T> tail; 
    private LinkedList<T> list = new LinkedList<>(); 

    public SLL<T> () { 
        list = new LinkedList<>(); 

    }

    /**
     * Accessor for head node
     * 
     * @return the head node
     */
    public NodeSL<T> getHead() {
        return this.head;
    }

    /**
     * Accessor for tail node
     * 
     * @return the tail node
     */
    public NodeSL<T> getTail() {
        return this.tail;
    }

    /**
     * Determines whether a list is empty
     * 
     * @return T/F is the list empty?
     */
    public boolean isEmpty() {
        if()
    }

    /**
     * Inserts the given item at the head of the list
     * 
     * @param v item to insert
     */
    public void addFirst(T v);

    /** Converts to a string representation */
    public String toString() {
        String list; 
        while(this.next() != null) {

        }
    }

    public static void main(String[] args) {
        NodeSL<String> = new NodeSL("hello", "bye"); 
    }

}
