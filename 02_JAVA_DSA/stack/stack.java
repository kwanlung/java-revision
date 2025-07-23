package stack;

import java.util.Stack;

public class stack {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack: " + stack);

        stack.peek();
        System.out.println("Stack after peek: " + stack.peek());

        stack.pop();
        System.out.println("Stack after pop: " + stack);

        if (stack.isEmpty()){
            System.out.println("The stack is empty");
        } else {
            System.out.println("The stack is not empty");
        }
    }
}
