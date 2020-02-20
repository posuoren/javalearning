package list;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @Description
 * @Author leiyutian
 * @Date 2020/2/19 20:49
 */
public class LinkedList<T> implements Iterable<T>{

    private Node<T> head;
    private Node<T> tail;
    private int nodesCount;

    public LinkedList() {
    }

    public void add(T value){
        Node<T> newNode = new Node<>(value);
        if(head == null){
            head = tail = newNode;
            nodesCount = 1;
            return;
        }
        assert(tail != null);
        tail.setNextNode(newNode);
        newNode.setPreviousNode(tail);
        tail = newNode;
        nodesCount ++;
    }

    public void insert(int index, T value){
        Node<T> newNode = new Node<>(value);
        if(head == null){
            head = tail = newNode;
            nodesCount = 1;
            return;
        }
        if(index == 0){
            newNode.setNextNode(head);
            head.setPreviousNode(newNode);
            head = newNode;
            nodesCount ++;
            return;
        }
        // 0 1 2
        // 0 1 3 2| 0 1
        Node<T> currentNode = head;
        int currentIndex = 0;
        while(currentIndex < index - 1 && currentNode.hasNext()){
            currentNode = currentNode.getNextNode();
            currentIndex++;
        }
        // 判断是否到达了尾结点
        if(!currentNode.hasNext()){
            tail.setNextNode(newNode);
            newNode.setPreviousNode(tail);
            tail = newNode;
            nodesCount ++;
            return;
        }
        Node<T> currentNextTemNode = currentNode.getNextNode();
        currentNode.setNextNode(newNode);
        newNode.setNextNode(currentNextTemNode);
        currentNextTemNode.setPreviousNode(newNode);
        newNode.setPreviousNode(currentNode);
        nodesCount ++;
    }

    public void setHead(T value){
        Node<T> newNode = new Node<>(value);
        if(head == null){
            head = newNode;
        }
        head.setPreviousNode(newNode);
        newNode.setNextNode(head);
        head = newNode;
        nodesCount ++;
    }

    public void removeTail(){
        if(tail == null){
            return;
        }
        if(head == tail){
            head = null;
            tail = null;
            nodesCount = 0;
            return;
        }
        tail = tail.getPreviousNode();
        tail.setNextNode(null);
        nodesCount --;
    }

    public void remove(int index){
        if(index >= nodesCount){
            throw new RuntimeException("out of index");
        }
        if(head == null){
            return;
        }
        if(head == tail || !head.hasNext()){
            head = null;
            tail = null;
            nodesCount = 0;
            return;
        }
        if(index == 0){
            Node<T> secondNode = head.getNextNode();
            secondNode.setPreviousNode(null);
            head=secondNode;
            nodesCount--;
            return;
        }
        int currentIndex = 0;
        Node<T> currentNode = head;
        while(currentIndex < index && currentNode.hasNext()){
            currentNode = currentNode.getNextNode();
        }
        assert(currentNode.hasNext());
        Node<T> targetNode = currentNode.getNextNode();
        Node<T> targetNextNode = targetNode.getNextNode();
        currentNode.setNextNode(targetNextNode);
        if(targetNextNode == null){
            tail = currentNode;
        }else{
            targetNextNode.setPreviousNode(currentNode);
        }
        nodesCount --;
    }

    public void pop(T value){
        if(head == null){
            return;
        }
        Node<T> currentNode = head;
        while(currentNode.hasNext() && currentNode.getValue() != value){
            currentNode = currentNode.getNextNode();
        }

        Node<T> previousNode = currentNode.getPreviousNode();
        Node<T> nextNode = currentNode.getNextNode();
        if(currentNode.hasNext()){
            previousNode.setNextNode(nextNode);
            nextNode.setPreviousNode(previousNode);
        }else{
            previousNode.setNextNode(nextNode);
            tail = previousNode;
        }
        nodesCount--;
    }

    public boolean contains(T value){
        if(head == null){
            return false;
        }
        if(head.getValue() == value){
            return true;
        }
        Node<T> currentNode = head;
        boolean containsValue = false;
        do{
            if(currentNode.getValue() == value){
                return true;
            }
            currentNode = currentNode.getPreviousNode();
        }while(currentNode != null);
        return false;
    }

    public void clear(){
        tail = head = null;
        nodesCount = 0;
    }

    public int size(){
        return nodesCount;
    }


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> currentNode = head;
            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                T value = currentNode.getValue();
                currentNode = currentNode.getNextNode();
                return value;
            }
        };
    }

    /**
     * Performs the given action for each element of the {@code Iterable}
     * until all elements have been processed or the action throws an
     * exception.  Unless otherwise specified by the implementing class,
     * actions are performed in the order of iteration (if an iteration order
     * is specified).  Exceptions thrown by the action are relayed to the
     * caller.
     *
     * @param action The action to be performed for each element
     * @throws NullPointerException if the specified action is null
     * @implSpec <p>The default implementation behaves as if:
     * <pre>{@code
     *     for (T t : this)
     *         action.accept(t);
     * }</pre>
     * @since 1.8
     */
    @Override
    public void forEach(Consumer<? super T> action) {
        if(head == null){
            return;
        }
        Node<T> currentNode = head;
        do{
            action.accept(currentNode.getValue());
            currentNode = currentNode.getNextNode();
        }while(currentNode != null);
    }

    /**
     * Creates a {@link Spliterator} over the elements described by this
     * {@code Iterable}.
     *
     * @return a {@code Spliterator} over the elements described by this
     * {@code Iterable}.
     * @implSpec The default implementation creates an
     * <em><a href="Spliterator.html#binding">early-binding</a></em>
     * spliterator from the iterable's {@code Iterator}.  The spliterator
     * inherits the <em>fail-fast</em> properties of the iterable's iterator.
     * @implNote The default implementation should usually be overridden.  The
     * spliterator returned by the default implementation has poor splitting
     * capabilities, is unsized, and does not report any spliterator
     * characteristics. Implementing classes can nearly always provide a
     * better implementation.
     * @since 1.8
     */
    @Override
    public Spliterator spliterator() {
        return null;
    }
}
