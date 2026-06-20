import java.util.Arrays;

public class LeetCode1833 {
    public static void main(String[] args) {
        System.out.println("res: " + maxIceCream(new int[] { 1, 3, 2, 4, 1 }, 7));
    }

    public static int maxIceCream(int[] costs, int coins) {
        int maxIceCream = 0;
        Arrays.sort(costs);
        int sum=0;
        for (int cost : costs) {    
            sum+=cost;
            if(sum>coins){
                break;
            }
            maxIceCream++;
        }
        return maxIceCream;
    }
}
