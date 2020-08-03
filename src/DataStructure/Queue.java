package DataStructure;

public class Queue<E> {
    //创建队列，队列只可以删除、查询头部元素以及加入队尾元素
private Object[] data=null;
private int maxSize;
private int front;
private int rear;
Queue(){
    this(20);
}
Queue(int initialSize){
    if(initialSize<0){
        throw new RuntimeException("队列的长度不能小于0："+initialSize);
    }
    else{
        this.maxSize=initialSize;
        data=new Object[initialSize];
        this.front=rear=0;
    }
}
//加入队尾元素，头部元素不动，不断加入尾部元素
    public boolean add(E e){
    if(rear==maxSize){
        throw new RuntimeException("队列已满 不允许写入");
    }
    else{
        data[rear++]=e;
        return true;
    }
    }
    //删除并返回头部元素
    public E poll(){
    if(front==rear){
        throw new RuntimeException("队列为空");
    }
    else{
        E value=(E)data[front];
        data[front++]=null;
        return value;
    }
    }
    //查询头部元素
    public E peek(){
    if(rear==front){
        throw new RuntimeException("队列为空 无需查询");
    }
    else{
        return (E)data[front];
    }
    }
//调用主函数
    public static void main(String[] args){
    Queue queuedemo=new Queue(30);
    queuedemo.add("happygirl");
    queuedemo.add("luhan");
    queuedemo.add(24);
    System.out.println(queuedemo.peek());
    System.out.println(queuedemo.poll());
    System.out.println(queuedemo.poll());
    }
}
