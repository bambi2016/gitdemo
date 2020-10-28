package c;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class C {
    public static void main(String[] args){
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.print(random.nextInt(3)+" ");
        }
    }
    //0 1 1 1 0 2 2 1 1 2
    //
    private Object func(Object o) {
        return Optional.ofNullable(o).orElse(new Object());
    }

    public int[] distributeCandies(int candies, int num_people) {
        int[] res=new int[num_people];
        int index=0;
        int curr=1;
        while (candies>0){
            if (candies>curr){
                res[index]=res[index]+curr;
            }else {
                res[index]=res[index]+candies;
            }
            candies-=curr;
            curr++;
            index=(index+1)%num_people;
        }
        return res;
    }
}
