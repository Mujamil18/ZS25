package special.programs.evaluation;

public class CustomStack {
    int arr[];
    int size;
    int top;
    CustomStack(int size){
        this.size = size;
        this.arr = new int[size];
        this.top = -1;
    }
    public void push(int element){
        if(!isFull()){
            top++;
            this.arr[top] = element;
            System.out.println("Pushed element: "+ element);
        }
        else{
            System.out.println("Stack is full");
        }
    }
    public int pop(){
        if(!isEmpty()) {
            top--;
            this.size--;
            return arr[top];
        }
        else{
            System.out.println("Stack is Empty");
            return -1;
        }
    }
    public boolean isEmpty(){
        if(top == -1){
            return true;
        }
        return false;
    }
    public boolean isFull(){
        if(top == size - 1){
            return true;
        }
        return false;
    }
    public int peek(){
        return arr[top];
    }
    public int size(){
        return size;
    }
    public String toString(){
        String arrStr = "";
        for(int i=0; i<this.size; i++){
            arrStr += this.arr[i] + " ";
        }
        return arrStr;
    }
    public static void main(String[] args) {
        CustomStack stack = new CustomStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.pop();
        System.out.println(stack);

    }
}
