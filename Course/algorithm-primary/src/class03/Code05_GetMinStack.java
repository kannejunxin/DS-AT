package class03;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-11-18
 * Time: 下午7:26
 */
public class Code05_GetMinStack {
    //实现返回栈中最小元素的功能
    public static class Mystack{
        //事先准备两个栈 一个最小栈 一个数据栈
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;
        //这里的stackMin有两种写法 一种是同步增长（没有比现在值更小的就反复存入）
        //另一种是只存入一次最小值，除非下次还比它小，否则不存入任何东西
        public Mystack(){
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }
        //压入数据  回望两遍都压入
        public void push(int newNum){
            if(this.stackMin.isEmpty()){
                this.stackMin.push(newNum);
            }else if(newNum <= this.getmin()){
                this.stackMin.push(newNum);
            }
            this.stackData.push(newNum);
        }
        //弹出数据
        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            int value = this.stackData.pop();
            if (value == this.getmin()) {
                this.stackMin.pop();
            }
            return value;
        }
        //得到栈中元素最小值
        public int getmin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();//peek函数可以用来查看栈顶元素
        }
    }
}
