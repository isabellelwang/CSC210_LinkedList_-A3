
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
        this.head = null;
        this.tail = null;
    }

    public SLL(SLL<T> list) {
        SLL<T> newList = new SLL<T>();
        this.head = list.getHead();
        this.tail = list.getTail();

        if (!list.isEmpty()) {
            newList.addFirst(head.getData());
            for (NodeSL<T> item = head; item != null; item = item.getNext()) {
                if (item != tail) {
                    newList.addAfter(item, item.getNext().getData());
                } else {
                    newList.addAfter(item, null);
                }
            }
        }
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
        if (isEmpty()) {
            throw new MissingElementException();
        }
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

        if (isEmpty()) {
            throw new MissingElementException();
        }

        T oldTail = tail.getData();

        for (NodeSL<T> item = head; item != null; item = item.getNext()) {
            if (item.getNext() == tail) {
                tail = item;
                item.setNext(null);
            }
            // if only one element in the array
            else if (item == tail && item == head) {
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

        if (isEmpty()) {
            throw new MissingElementException();
        } else if (here == null) {
            removedItem = tail.getData();
            head = null;
        } else {
            removedItem = here.getNext().getData();
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
        SLL<T> list = new SLL<T>();
        list.addFirst(here.getData());
        here = here.getNext();

        for (int i = 0; i < n - 1; i++) {
            list.addLast(here.getData());
            here = here.getNext();
        }
        return list;
    }

    /**
     * Places copy of the provided list into this after the specified node.
     * 
     * @param list      the list to splice in a copy of
     * @param afterHere marks the position in this where the new list should go
     */
    public void spliceByCopy(SLL<T> list, NodeSL<T> afterHere) {

        SLL<T> list2 = new SLL<>(list);

        if (this.equals(list)) {
            throw new SelfInsertException();
        } else if (afterHere == null) {
            NodeSL<T> addItem = list2.getHead();
            this.addFirst(addItem.getData());
            NodeSL<T> previousItem = this.getHead();

            for (NodeSL<T> item = list2.getHead().getNext(); item != null; item = item.getNext()) {
                this.addAfter(previousItem, item.getData());
                previousItem = previousItem.getNext();
            }

        } else if (!list.isEmpty()) {
            NodeSL<T> afterNode = afterHere;
            T copiedItem = list2.getHead().getData();
            this.addAfter(afterHere, copiedItem);
            afterNode = afterNode.getNext();
            for (NodeSL<T> item = list2.getHead().getNext(); item != null; item = item.getNext()) {
                this.addAfter(afterNode, item.getData());
                afterNode = afterNode.getNext();
            }

        }
    }

    /**
     * Extracts a subsequence of nodes and returns them as a new list
     * 
     * @param afterHere marks the node just before the extraction
     * @param toHere    marks the node where the extraction ends
     * @return the new list
     */
    public SLL<T> subseqByTransfer(NodeSL<T> afterHere, NodeSL<T> toHere) {
        SLL<T> newList = new SLL<T>();

        if(afterHere == null) {
            for(NodeSL<T> item = head; item != toHere.getNext(); item = item.getNext()) {
                newList.addLast(item.getData()); 
            }
            for(int i = 0; i < newList.size() - 1; i++) {
                head.setNext(head.getNext().getNext());
            }
            removeFirst(); 

        }else {
            for(NodeSL<T> item = afterHere.getNext(); item != toHere.getNext(); item = item.getNext()) {
                newList.addLast(item.getData()); 
            }
            for(int i = 0; i < newList.size(); i++) {
                afterHere.setNext(afterHere.getNext().getNext());
            }

        }

        return newList;
    }

    /**
     * Takes the provided list and inserts its elements into this
     * after the specified node. The inserted list ends up empty.
     * 
     * @param list      the list to splice in. Becomes empty after the call
     * @param afterHere Marks the place where the new elements are inserted
     */
    public void spliceByTransfer(SLL<T> list, NodeSL<T> afterHere) {
        NodeSL<T> afterNode = afterHere;

        if(this.equals(list)) {
            throw new SelfInsertException();
        }
        else if (afterHere == null) {
            for (int i = 0; i < list.size() + 1; i++) {
                this.addFirst(list.tail.getData());
                list.removeLast();
            }

        } else {
            for (int i = 0; i < list.size() + 1; i++) {
                this.addAfter(afterNode, list.getHead().getData());
                afterNode = afterNode.getNext();
                list.removeFirst();
            }

        }

    }

    //testing
    public static void main(String[] args) {
        // SLL<String> list = SLLTest.makeSLL(SLLTest.abc);
        // System.out.println(list.removeAfter(list.getHead().getNext()));
        // System.out.println(list.toString());
        // System.out.println(list.getHead().getData());
        // System.out.println(list.getTail().getData());
        // System.out.println(list.removeAfter(list.getHead()));
        // System.out.println(list.toString());
        // System.out.println(list.removeAfter(null));

        // SLL<String> list = new SLL();
        // System.out.println(list.isEmpty());
        // list.removeAfter(list.getHead());

        // subseqbycopy
        // SLL<String> list = SLLTest.makeSLL(SLLTest.bac);
        // SLL<String> list2 = list.subseqByCopy(list.getHead(), 2);
        // System.out.println(list2.toString());

        // splice by copy
        // SLL<String> list = SLLTest.makeSLL(SLLTest.dac);
        // SLL<String> list2 = SLLTest.makeSLL(SLLTest.eb);
        // list.spliceByCopy(list2, list.getHead());
        // System.out.println(list.toString());

        SLL<String> list = SLLTest.makeSLL(SLLTest.debacfg);
        SLL<String> list2 = SLLTest.makeSLL(SLLTest.hi);
        // list.spliceByCopy(list2, null);

        // list = SLLTest.makeSLL(SLLTest.abc);
        // list2 = SLLTest.makeSLL(SLLTest.empty);
        // list.spliceByCopy(list2, list.getHead().getNext());

        // subseq by transfer
        list = SLLTest.makeSLL(SLLTest.debac);
        list2 = list.subseqByTransfer(list.getHead(),
                list.getHead().getNext().getNext());
        // System.out.println(list2.toString()); // B
        // System.out.println(list.toString());

        // // list = SLLTest.makeSLL(SLLTest.abc);
        // // list2 = list.subseqByTransfer(list.getHead(), list.getHead().getNext());
        // System.out.println(list2.toString()); // B
        // System.out.println(list.toString()); // AC

        // // splicebytransfer
        // SLL<String> list = SLLTest.makeSLL(SLLTest.dbac);
        // SLL<String> list2 = SLLTest.makeSLL(SLLTest.e);
        // list.spliceByTransfer(list2, list.getHead());

        // list = SLLTest.makeSLL(SLLTest.debacfg);
        // list2 = SLLTest.makeSLL(SLLTest.hi);
        // list.spliceByTransfer(list2, null);
        // System.out.println(list.toString());
        // System.out.println(list2.toString());

        list = SLLTest.makeSLL(SLLTest.hidebacfg);
        list2 = list.subseqByTransfer(null, list.getHead().getNext());
          System.out.println(list2.toString()); // B
        System.out.println(list.toString());
    }
}
