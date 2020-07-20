import java.util.AbstractList;

public class ForwardLinkedList<E> extends AbstractList<E> {

    int size;
    Node<E> head;
    Node<E> tail;

    public static class Node<E> {

        private Node<E> next;
        private E data;

        public Node(Node<E> next, E data) {
            this.next = next;
            this.data = data;
        }
    }

    public ForwardLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public boolean add(E element) {
        Node<E> newNode = new Node<>(null, element);
        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);
        Node<E> previousNode = getNode(index - 1);
        previousNode.next = new Node<>(previousNode.next, element);
        size++;
    }

    @Override
    public E get(int index) {
        return getNode(index).data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int indexOf(Object element) {
        Node<E> node = head;
        int index = -1;
        while (node != null) {
            index++;
            if (node.data.equals(element)) {
                return index;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object element) {
        Node<E> node = head;
        int index = -1;
        int i = -1;
        while (node != null) {
            i++;
            if (node.data.equals(element)) {
                index = i;
            }
            node = node.next;
        }
        return index;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E result;
        if (index == 0) {
            result = head.data;
            head = head.next;
        } else {
            Node<E> prevRemovingItem = getNode(index - 1);
            Node<E> removingItem = prevRemovingItem.next;
            prevRemovingItem.next =  removingItem.next;
            result = removingItem.data;
        }
        size--;

        return result;
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        Node<E> settingItem = getNode(index);
        settingItem.data = element;
        return settingItem.data;
    }

    @Override
    public boolean contains(Object element) {
        return indexOf(element) >= 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node<E> getNode(int index) {
        checkIndex(index);
        Node<E> node = head;
        int i = -1;
        while (node != null) {
            i++;
            if (i == index) {
                return node;
            }
            node = node.next;
        }
        return node;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

}

