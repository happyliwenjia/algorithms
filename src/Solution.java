import java.util.*;

class Solution {
    public static void main(String[] args){
        Solution demo=new Solution();
        ThreadLocal<String> local=new ThreadLocal<>();
Thread t1=new Thread(()->{
    System.out.println(local.get());
    local.set("1234");
    System.out.println(local.get());
});
Thread t2=new Thread(()->{
    System.out.println(local.get());
    local.set("asdf");
    System.out.println(local.get());
});
t1.start();

t2.start();

    }
}