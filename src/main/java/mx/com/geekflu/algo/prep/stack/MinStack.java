package mx.com.geekflu.algo.prep.stack;

import java.util.Arrays;

class MinStack {

  private int top;
  private int size;
  private int[] stack;
  private int[] min;


  public MinStack() {
    this.stack = new int[20];
    this.min = new int[20];
    this.top = 0;
    this.size = 0;
  }

  public void push(int val) {
    if (this.size() >= this.stack.length) {
      this.grow();
    }

    if (this.isEmpty()) {
      this.top = 0;
      this.stack[top] = val;
      this.min[top] = 0;
    } else {
      this.top++;
      this.stack[top] = val;
      int currentMin = this.stack[this.min[this.top - 1]];
      System.out.println(Arrays.toString(this.min));

      if (currentMin > val) {
        this.min[top] = top;
      } else {
        this.min[top] = this.min[top - 1];
      }
    }

    this.size++;
  }

  public void pop() {
    int val = this.stack[top];
    this.top--;
    this.size--;
  }

  public int top() {
    return this.stack[this.top];
  }

  public int getMin() {
    return this.stack[this.min[this.top]];
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size() <= 0;
  }

  private void grow() {
    this.stack = Arrays.copyOf(this.stack, this.stack.length * 2);
  }

  public static void main(String[] args) {

    MinStack obj = new MinStack();
    obj.push(-2);
    obj.push(0);
    obj.push(-1);
    int param_4 = obj.getMin();
    int param_3 = obj.top();
    obj.pop();
    param_4 = obj.getMin();


  }

}


