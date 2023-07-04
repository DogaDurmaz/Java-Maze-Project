
public class Stack {
    int max_size;
    int top;
    Node[] stack_array;
    
    public Stack(int max_size){
        this.max_size = max_size;
        top = -1;
        stack_array = new Node[max_size];
    }

    public void push(Node node){
        if(top == max_size) {
            System.out.println("Stack overflow!");
            return;
        }
        stack_array[++top] = node;
    }

    public Node pop(){
        if(top == -1) {
            System.out.println("Stack is empty!");
            return null;
        }
        return stack_array[top--];
    }

    public boolean is_empty(){
        return top == -1;
    }

    public String printstack(char[][] maze){
        if(top == -1) {
            System.out.println("Stack is empty!");
            return "";
        }
        String result = "";
        for(int i = 0; i < top + 1; i++){
            result += maze[stack_array[i].y][stack_array[i].x];
        }
        return result;
    }

}
