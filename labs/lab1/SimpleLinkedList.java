import java.lang.*;

/**
 * generic doubly-linked list
 *
 * @author John Thomsen
 * @version lab1
 */

public class SimpleLinkedList<T> implements SimpleList<T> {

    private int size = 0;
    private Node head = new Node();

    private class Node {
        public Node prev;
        public Node next;
        public T element;

        public Node() {
            next = this;
            prev = this;
        }

        public Node(T element, Node prev, Node next) {
            this.prev = prev;
            this.next = next;
            this.element = element;
        }
    }


    public void add(T element) {
        size++;
        //create new node that points forward to head and back to tail
        Node newNode = new Node(element, head.prev, head);
        //tail now points to new node
        head.prev.next = newNode;
        //head points back to new node
        head.prev = newNode;
    }

    //helper to locate nodes
    private Node find(int index) {
        Node n = head;
        for (int i = -1; i < index; i++) {
            n = n.next;
        }
        return n;
    }

    //print to test
    public void print()
    {
        Node n = head;
        System.out.println("\n--START TEST PRINT--\nSIZE:"+size);
        for (int i = -1; i < size; i++) {
            System.out.println(n.element);
            n = n.next;
        }
        System.out.println(n.element+"\n--END TEST PRINT--\n");
    }


    public void add(int index, T element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            size++;
            //get node at index
            Node cur = find(index);
            //create new node that points forward to node at index location and back to prev node
            Node newNode = new Node(element, cur.prev, cur);
            //prev node now points forward to new node
            cur.prev.next = newNode;
            //cur now points back to new node
            cur.prev = newNode;
        }
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            return find(index).element;
        }
    }

    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            size--;
            //get node at index
            Node cur = find(index);
            //set next pointer of prev node to next of the removed node
            cur.prev.next = cur.next;
            //set prev pointer of next node to the prev of the removed node
            cur.next.prev = cur.prev;
            //return element
            return cur.element;
        }
    }

    public int size() {
        return size;
    }

}
