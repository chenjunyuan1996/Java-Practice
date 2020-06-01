/*
面试题09. 用两个栈实现队列
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

链接: https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
*/

class CQueue {

    public Stack<Integer> stack;
    public Stack<Integer> helper;

    public CQueue() {
        stack = new Stack<Integer>();
        helper = new Stack<Integer>();

    }
    
    public void appendTail(int value) {
        while (!stack.isEmpty()) {
            helper.push(stack.pop());
        }
        helper.push(value);
        while (!helper.isEmpty()) {
            stack.push(helper.pop());
        }

    }
    
    public int deleteHead() {
        if (stack.isEmpty()) return -1;
        return stack.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
