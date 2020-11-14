import java.util.Iterator;

public class MyList<T> {

    public static class Node<T> {
        T val;
        Node<T> next;

        public Node(T val) {
            this.val = val;
            next = null;
        }
    }

    Node<T> head;
    int size;

    public MyList() {
        head = null;
        size = 0;
    }

    /**
     * 链表尾部增加元素
     */
    public void add(T val) {
        Node<T> tmp = head;
        if (head == null) {
            head = new Node<>(val);
        } else {
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new Node<>(val);
        }
        size++;
    }

    /**
     * 在链表中间增加元素
     */
    public void add(T val, int pos) {
        Node<T> newNode = new Node<>(val);
        if (pos < size) {
            if (pos == 0) {
                newNode.next = head;
                head = newNode;
            } else {
                Node<T> pre = head;
                Node<T> tmp = head;
                for (int i = 0; i < pos; i++) {
                    pre = tmp;
                    tmp = tmp.next;
                }
                pre.next = newNode;
                newNode.next = tmp;
            }
            size++;
        }
    }

    /**
     * 删除链表指定元素
     */
    public void delete(T val) {
        Node<T> tmp = head;
        if (!isEmptyList()) {
            if (head.val == val) {
                head = head.next;
            } else {
                while (tmp.next != null && tmp.next.val != val) {
                    tmp = tmp.next;
                }
                if (tmp.next == null) {
                    System.out.println("查无此元素");
                } else {
                    tmp.next = tmp.next.next;
                }
            }
            size--;
        } else System.out.println("空表无法进行操作");
    }

    /**
     * 删除链表指定位置的元素
     */
    public void delete(int pos) {
        if (!isEmptyList()) {
            if (pos == 0) {
                head = head.next;
            } else {
                Node<T> pre = head;
                Node<T> tmp = head;
                for (int i = 0; i < pos; i++) {
                    pre = tmp;
                    tmp = tmp.next;
                }
                pre.next = tmp.next;
            }
            size--;
        } else System.out.println("空表无法进行操作");
    }

    /**
     * 查找指定元素是否存在
     */
    public int query(T val) {
        Node<T> tmp = head;
        if (!isEmptyList()) {
            while (tmp.next != null) {
                if (tmp.val == val) return 1;
                tmp = tmp.next;
            }
            if (tmp.val == val) return 1;
        } else System.out.println("空表无法进行操作");
        return -1;
    }

    /**
     * 查找链表指定位置的元素
     */
    public T query(int pos) {
        Node<T> tmp = head;
        if (!isEmptyList()) {
            if (pos < size) {
                for (int i = 0; i < pos; i++) {
                    tmp = tmp.next;
                }
                return tmp.val;
            } else System.out.println("长度超出链表上限");
        } else System.out.println("空表无法进行操作");
        return null;
    }

    /**
     * 修改表中某一元素的值
     */
    public void update(T preVal, T upVal) {
        Node<T> tmp = head;
        if (!isEmptyList()) {
            while (tmp.next != null) {
                if (tmp.val == preVal) {
                    tmp.val = upVal;
                    break;
                }
                tmp = tmp.next;
            }
            if (tmp.val == preVal) tmp.val = upVal;
            else System.out.println("查无此元素，无法进行修改");
        } else System.out.println("空表无法进行操作");
    }

    /**
     * 修改链表中指定位置元素的值
     */
    public void update(int pos, T updateVal) {
        Node<T> tmp = head;
        if (!isEmptyList()) {
            if(pos<size){
                for (int i = 0; i < pos; i++) {
                    tmp = tmp.next;
                }
                tmp.val = updateVal;
            }else System.out.println("长度超出链表上限");
        } else System.out.println("空表无法进行操作");
    }

    /**
     * 判断是否为空表
     */
    public boolean isEmptyList() {
        return head == null;
    }

    /**
     * 获取链表长度
     */
    public int getListLength() {
        return size;
    }


    class Itr implements Iterator<T> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }

    public Iterator<T> iterator() {
        return new Itr();
    }
}
