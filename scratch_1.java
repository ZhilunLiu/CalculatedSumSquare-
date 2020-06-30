import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        int[] dir = new int[10];
        for(int i =0;i<10;i++){
            dir[i] = i*i;
        }

        Scanner input = new Scanner(System.in);
        int total = input.nextInt();
        //create an int array to increase calculating speed;

        int[] ary  = new int[total];
        for(int i=0;i<total;i++){
            ary[i] = input.nextInt();
        }

        for(int i=0;i<total;i++){
            int num = ary[i];
            List<Integer> calculated = new ArrayList<>();
            System.out.println(calculateResult(num,calculated,dir));
        }

    }

    public static boolean calculateResult(int num,List<Integer> calculated, int[] dir){
        if(num==1){
            return true;
        }
        if(calculated.contains(num)){
            return false;
        }

        calculated.add(num);
        int result = 0;
        while(num>0){
            int digit = num%10;
            result+=dir[digit];
            num /= 10;
        }
        return calculateResult(result,calculated,dir);
    }
}