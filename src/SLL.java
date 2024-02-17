
/**
 * Class to implement a singly linked list
 *
 * @author Isabelle Wang
 * @version Spring 2024
 */

public class SLL<T> implements Phase1SLL<T>, Phase2SLL<T>, Phase4SLL<T> {

    // Phase 1
    private NodeSL<T> head;
    private NodeSL<T> tail;

    public SLL() {
        head = null;
        tail = null;
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
        return (head == null);
    }

    /**
     * Inserts the given item at the head of the list
     * 
     * @param v item to insert
     */
    public void addFirst(T v) {
        NodeSL<T> item = new NodeSL<>(v, head);
        head = item;
        if (item.getNext() == null) {
            tail = item;
        }
    }

    /** Converts to a string representation */
    public String toString() {

        String stringList = "[";

        for (NodeSL<T> item = head; item != null; item = item.getNext()) {
            stringList += item.getData();
            if (item.getNext() != null) {
                stringList += ", ";
            }
        }
        return stringList + "]";

    }

    // Phase 2
    /**
     * Inserts the given item at the tail of the list
     * 
     * @param item to insert
     */
    public void addLast(T v) {
        NodeSL<T> lastItem = new NodeSL<>(v, null);
        if (isEmpty()) {
            head = lastItem;
            tail = lastItem;
        } else {
            tail.setNext(lastItem);
            tail = lastItem;

        }

    }

    /**
     * Inserts the given item after the specified node
     * 
     * @param here node to insert after
     * @param v    item to insert
     */
    public void addAfter(NodeSL<T> here, T v) {

        for (NodeSL<T> item = head; item != null; item = item.getNext()) {
            if (item == here) {
                if (item.getNext() != null) {
                    item.setNext(new NodeSL<T>(v, item.getNext()));
                } else {
                    NodeSL<T> itemInserted = new NodeSL<T>(v, null);
                    item.setNext(itemInserted);
                    tail = itemInserted;
                }
            }

        }
    }

    /**
     * Removes the given item from the head of the list
     * 
     * @return v item removed
     */
    public T removeFirst() {
        T remove = head.getData();
        head = head.getNext();
        return remove;
    }

    /**
     * Removes the given item from the tail of the list
     * 
     * @return item removed
     */
    public T removeLast() {
        T oldTail = tail.getData();
        for (NodeSL<T> item = head; item != null; item = item.getNext()) {
            if (item.getNext() == tail) {
                tail = item;
                item.setNext(null);
            } else if (item.getNext() == null) {
                head = null;
                tail = null;
            }
        }
        return oldTail;
    }

    /**
     * Removes the node after the given position
     * 
     * @param here marks position to remove after
     * @return item removed
     */
    public T removeAfter(NodeSL<T> here) {
        T removedItem;
        if (here == null) {
            removedItem = tail.getData();
            tail = null;
            head = null;

        } else {
            removedItem = here.getNext().getData();
            for (NodeSL<T> item = head; item != null; item = item.getNext()) {
                if (item == here) {
                    if (here.getNext().getNext() != null) {
                        here.setNext(here.getNext().getNext());
                        if (here.getNext() == null) {
                            tail = here.getNext();
                        }
                    } else if (here.getNext().getNext() == null) {
                        here.setNext(null);
                        tail = here;
                    }
                }
            }
        }
        return removedItem;
    }

    /**
     * Returns a count of the number of elements in the list
     * 
     * @return current number of nodes
     */
    public int size() {
        int count = 0;
        for (NodeSL<T> item = head; item != null; item = item.getNext()) {
            count++;
        }
        return count;
    }

    // Phase4
    /**
     * Makes a copy of elements from the original list
     * 
     * @param here starting point of copy
     * @param n    number of items to copy
     * @return the copied list
     */
    public SLL<T> subseqByCopy(NodeSL<T> here, int n) {

    }

    /**
     * Places copy of the provided list into this after the specified node.
     * 
     * @param list      the list to splice in a copy of
     * @param afterHere marks the position in this where the new list should go
     */
    public void spliceByCopy(SLL<T> list, NodeSL<T> afterHere);

    /**
     * Extracts a subsequence of nodes and returns them as a new list
     * 
     * @param afterHere marks the node just before the extraction
     * @param toHere    marks the node where the extraction ends
     * @return the new list
     */
    public SLL<T> subseqByTransfer(NodeSL<T> afterHere, NodeSL<T> toHere);

    /**
     * Takes the provided list and inserts its elements into this
     * after the specified node. The inserted list ends up empty.
     * 
     * @param list      the list to splice in. Becomes empty after the call
     * @param afterHere Marks the place where the new elements are inserted
     */
    public void spliceByTransfer(SLL<T> list, NodeSL<T> afterHere);

    public static void main(String[] args) {
        SLL<String> list = SLLTest.makeSLL(SLLTest.abc);
        System.out.println(list.removeAfter(list.getHead().getNext()));
        System.out.println(list.toString());
        System.out.println(list.getHead().getData());
        System.out.println(list.getTail().getData());
        System.out.println(list.removeAfter(list.getHead()));
        System.out.println(list.toString());
        System.out.println(list.removeAfter(null));
    }

}
