package com.fannnnn.review.question225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * \*  Created with IntelliJ IDEA.
 * \*  @author shensifan
 * \*  Date: 2022/5/11
 * \*  Time: 8:06
 * \*  Description:
 * \
 */

public class MyStack {

//    Queue<Integer> queue1;
//    Queue<Integer> queue2;
//
//    public MyStack() {
//        queue1 = new LinkedList<>();
//        queue2 = new LinkedList<>();
//    }
//
//    public void push(int x) {
//        if(queue1.isEmpty()){
//            queue2.offer(x);
//        }else if(queue2.isEmpty()){
//            queue1.offer(x);
//        }
//    }
//
//    public int pop() {
//        if(queue1.isEmpty()){
//            while (queue2.size()!=1){
//                queue1.offer(queue2.poll());
//            }
//            return queue2.poll();
//        }else if(queue2.isEmpty()){
//            while (queue1.size()!=1){
//                queue2.offer(queue1.poll());
//            }
//            return queue1.poll();
//        }
//        return -1;
//    }
//
//    public int top() {
//        if(queue1.isEmpty()){
//            while (queue2.size()!=1){
//                queue1.offer(queue2.poll());
//            }
//            int res = queue2.poll();
//            queue1.offer(res);
//            return res;
//
//        }else if(queue2.isEmpty()){
//            while (queue1.size()!=1){
//                queue2.offer(queue1.poll());
//            }
//            int poll = queue1.poll();
//            queue2.offer(poll);
//            return poll;
//        }
//        return -1;
//    }
//    public boolean empty() {
//        return queue1.isEmpty() &&queue2.isEmpty();
//    }


    /**
     * queue1用来当做栈存储数据
     * queue2用来进行插入操作
     * */

    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()){ //每次push完以后 将queue1中所有的元素放入queue2中
            queue2.offer(queue1.poll());
        }
        //交换两个队列 使得queue1指向已经存储好的元素且队头是最新插入的元素
        Queue<Integer> queue3 = new LinkedList<>();
        queue3 = queue1;
        queue1 = queue2;
        queue2 = queue3;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }
    public boolean empty() {
        return queue1.isEmpty();
    }
}
