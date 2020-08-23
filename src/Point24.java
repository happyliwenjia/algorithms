import java.util.ArrayList;
import java.util.List;
//标准答案
/*class Point24{
    static final int TARGET = 24;
    static final double EPSILON = 1e-6;
    static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;
    public static void main(String[] args){
        Point24 demo=new Point24();
        int[] nums={1,2,3,4};
        System.out.print(demo.judgePoint24(nums));
    }
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<Double>();
        for (int num : nums) {
            list.add((double) num);
        }
        return solve(list);
    }

    public boolean solve(List<Double> list) {
        if (list.size() == 0) {
            return false;
        }
        if (list.size() == 1) {
            return Math.abs(list.get(0) - TARGET) < EPSILON;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    List<Double> list2 = new ArrayList<Double>();
                    //list2中i先放入没被挑选的值
                    for (int k = 0; k < size; k++) {
                        if (k != i && k != j) {
                            list2.add(list.get(k));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && i > j) {
                            continue;
                        }
                        if (k == ADD) {
                            list2.add(list.get(i) + list.get(j));
                        } else if (k == MULTIPLY) {
                            list2.add(list.get(i) * list.get(j));
                        } else if (k == SUBTRACT) {
                            list2.add(list.get(i) - list.get(j));
                        } else if (k == DIVIDE) {
                            if (Math.abs(list.get(j)) < EPSILON) {
                                continue;
                            } else {
                                list2.add(list.get(i) / list.get(j));
                            }
                        }
                        if (solve(list2)) {
                            return true;
                        }
                        list2.remove(list2.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}*/
//自己写的
class Point24 {
    static double wucha=1e-6;
    public static void main(String[] args){
        Point24 demo=new Point24();
        int[] nums={1,2,3,4};
        System.out.print(demo.judgePoint24(nums));
    }
    public boolean judgePoint24(int[] nums) {
//每次选出2个值，全排列，得出所有情况,因为除法可能有小数很小误差，算是再10的-6次方以为就算对
        ArrayList<Double> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add((double)nums[i]);
        }
        return solve(list);
    }
    public boolean solve(ArrayList<Double> list){
        if(list.size()==0){
            return false;
        }
        if(list.size()==1){
            if(Math.abs(list.get(0)-24)<wucha){
                return true;
            }else{
                return false;
            }
        }
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.size();j++){
                if(i!=j){
                    ArrayList<Double> list2=new ArrayList<>();
                    for(int k=0;k<list.size();k++){
                        if(k!=i&&k!=j){
                            list2.add(list.get(k));
                        }
                    }
                    list2.add(list.get(i)+list.get(j));
                    boolean q=solve(list2);
                    list2.remove(list2.size()-1);
                    list2.add(list.get(i)-list.get(j));
                    boolean w=solve(list2);
                    list2.remove(list2.size()-1);
                    list2.add(list.get(i)*list.get(j));
                    boolean e=solve(list2);
                    list2.remove(list2.size()-1);
                    list2.add(list.get(i)/list.get(j));
                    boolean r=solve(list2);
                    list2.remove(list2.size()-1);
                    if(q||w||e||r){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}