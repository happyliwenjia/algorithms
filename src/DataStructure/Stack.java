package DataStructure;
//建立栈，E代表元素,data用来存放数据，是一个数组类型，里面是E类型
public class Stack<E> {
    private Object[] data=null;
    private int maxSize=0;
    private int top=-1;
    //建立2个构造函数，其中第一个构造函数中用了第二个构造函数,this泛指这个类中直接有的东西，
    //比如data、maxsize、top
    Stack(){
        this(10);
    }
    Stack(int initialSize){
    if(initialSize>=0){
        this.maxSize=initialSize;
        data=new Object[initialSize];
        top=-1;
    }
    else{
        throw new RuntimeException("初始化大小不能小于0:"+initialSize);
    }
    }
    //入栈
    public boolean push(E e){
        if(top==maxSize-1){
            throw new RuntimeException("栈已满，不能写入");
        }
        else{
            data[++top]=e;
            return true;
        }
    }
    //出栈
    public E pop(){
        if(top==-1){
            throw new RuntimeException("栈中元素为零，此时栈为空栈");
        }
        else{
            return (E)data[top--];
        }
    }
    //查询栈顶元素
    public E peek(){
        if(top==-1){
            throw new RuntimeException("栈中元素为零，此时栈为空栈");
        }
        else{
            return (E)data[top];
        }
    }
    // 创建主函数
    public static void main(String[] args){
        //类都需要实例化，实例化一个类
        Stack chan=new Stack(20);
        chan.push("hello");
        chan.push(456);
        chan.push("beautiful girl");
        System.out.println(chan.peek());
        System.out.println(chan.pop());
        System.out.println(chan.pop());

    }
}
