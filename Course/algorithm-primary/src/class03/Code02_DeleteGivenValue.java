package class03;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-11-11
 * Time: 下午10:56
 */
public class Code02_DeleteGivenValue {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node removeValue(Node head, int num){
        //head要来到第一个不需要删的位置
        while(head != null){
            if(head.value != num){
                break;
            }
            head = head.next;
        }
        //情况1： head == null
        //情况2： head != null
        Node pre = head;
        Node cur = head;
        while (cur!=null){
            if(cur.value==num){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

}
