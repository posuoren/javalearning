package list;

/**
 * @Description
 * @Author leiyutian
 * @Date 2020/2/19 20:45
 */
public class Node <T>{
    private T value;
    private Node<T> previousNode;
    private Node<T> nextNode;

    public Node(T value, Node<T> previousNode, Node<T> nextNode) {
        this.value = value;
        this.previousNode = previousNode;
        this.nextNode = nextNode;
    }

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node<T> previousNode) {
        this.previousNode = previousNode;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public boolean hasNext(){
        return nextNode != null;
    }

    public boolean hasPrevious(){
        return previousNode != null;
    }
}
