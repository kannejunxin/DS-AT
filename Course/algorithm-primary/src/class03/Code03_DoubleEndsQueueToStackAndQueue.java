package class03;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-11-18
 * Time: 下午3:42
 */
public class Code03_DoubleEndsQueueToStackAndQueue {

    //用双链表的形式实现栈和队列

    //返回值T是泛型，T是一个占位符
    public static class Node<T>{
        public T value;
        public Node<T> last;
        public Node<T> next;

        public Node(T data){value = data;}
    }

    //双向队列 ：借他可以实现队列 & 栈
    public static class DoubleEndsQueue<T> {
        public Node<T> head;
        public Node<T> tail;
        //从头部加入
        public void addFromHead(T value){
            Node<T> cur = new Node<T>(value);
            if(head == null){
                head = cur;
                tail = cur;
            }else{
                cur.next = head;
                head.last = cur;
                head = cur;
            }
        }
        //从尾部加
        public void addFromBottom(T value) {
            Node<T> cur = new Node<T>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.last = tail;
                tail.next = cur;
                tail = cur;
            }
        }
        //从头部出
        public T popFromHead(){
            if(head == null){
                return null;
            }
            Node<T> cur = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                cur.next = null;
                head.last = null;
            }
            return cur.value;
        }
        //从尾部出
        public T popFromBottom() {
            if (head == null) {
                return null;
            }
            Node<T> cur = tail;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                tail.next = null;
                cur.last = null;
            }
            return cur.value;
        }
        public boolean isEmpty() {
            return head == null;
        }
    }


}
