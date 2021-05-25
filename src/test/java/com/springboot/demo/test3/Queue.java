package com.springboot.demo.test3;

import java.util.Scanner;

public class Queue {
    private int front;//队头
    private int rear;//队尾
    private int maxLength;//最大元素个数
    private int[] arr;//操作的数组

    //初始化队列
    public Queue(int value) {
        this.front = 0;
        this.rear = 0;
        this.maxLength = value;
        this.arr = new int[this.maxLength];
    }

    //元素是否满，例：当队首为0，队尾+1等于最大元素个数时，此时模运算结果为0，与队首相等，那么说明队列元素满
    private boolean isFull(){
        return (this.rear + 1) % maxLength == front;
    }

    //元素是否为空,当队尾等于队首，说明队列无元素
    private boolean isEmpty(){
        return this.rear == front;
    }

    //入队
    public void addValue(int value){
        if (isFull()){
            System.out.println("队列已满");
            return;
        }
        this.arr[rear] = value;
        this.rear = (this.rear + 1) % maxLength;
    }

    //出队,实际数组数据还是存在，只是移动了队首指针
    public int getValue(){
        if (isEmpty()){
            System.out.println("队列为空");
            return 0;//懒得抛异常，先这样
        }
        int value = this.arr[front];
        this.front = (this.front + 1) % maxLength;
        return value;
    }

    public int getIndexValue(int index) {
        if (isEmpty()) {
            System.out.println("队列为空");
            return 0;
        }
        if (index > maxLength || index < 0){
            System.out.println("下标越界");
            return 0;
        }
        return this.arr[index];
    }

    public void getAllValue(){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public void Ring(int value){
        if (isFull()){
            getValue();
        }
        addValue(value);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = 5;
        Queue q = new Queue(index);
        while (true){
            int i = sc.nextInt();
            q.Ring(i);
            q.getAllValue();
        }
    }
}
