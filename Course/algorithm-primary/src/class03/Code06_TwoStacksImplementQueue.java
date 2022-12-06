package class03;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-11-19
 * Time: 上午12:07
 */
public class Code06_TwoStacksImplementQueue {
    //用栈实现队列
    public static class TwoStacksQueue{
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStacksQueue(){
            stackPop = new Stack<Integer>();
            stackPush = new Stack<Integer>();
        }

        //push栈向pop栈倒入数据
        private void pushToPop(){
            if(stackPop.empty()){
                while(!stackPush.empty()){
                    stackPop.push(stackPush.pop());
                }
            }
        }
        //往队列添加数据
        public void add(int pushInt) {
            stackPush.push(pushInt);
            pushToPop();
        }
        //取队列数据
        public int poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            pushToPop();
            return stackPop.pop();
        }
        //查看队列的即将出来的数据
        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            pushToPop();
            return stackPop.peek();
        }
    }
}

