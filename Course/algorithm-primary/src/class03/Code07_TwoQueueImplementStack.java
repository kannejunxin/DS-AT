package class03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-11-19
 * Time: 上午12:27
 */
public class Code07_TwoQueueImplementStack {

    //队列实现栈
    public static class TwoQueueStack<T> {
        public Queue<T> queue;
        public Queue<T> help;

        public TwoQueueStack(){
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }
        //压入数据
        public void push(T value){
            //在队列中用add or offer
            queue.offer(value);
        }
        //弹出数据
        public T poll(){
            //因为要弹出队列最后一个数据，所以要先将其他数据放入help栈，然后弹出最后一个数据到ans
            //之后将把help栈 和 queue栈 名称互换
            while(queue.size()>1){
                help.offer(queue.poll());
            }
            T ans = queue.poll();
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;
            return ans;
        }
        //查看数据
        public T peek(){
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            T ans = queue.poll();
            help.offer(ans);//这也是和弹出唯一差别的地方
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;
            return ans;
        }
        //是否为空
        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }
}
