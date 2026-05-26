public class Leetcode1871 {
    public static void main(String[] args) {
        // String s = "01101110";
        String s = "01";
        System.out.println("res: "+canReach(s, 1, 1));
    }

    public static boolean canReach(String s, int minJump, int maxJump) {
        int len = s.length();
        if(s.charAt(len-1) !='0'){
            return false;
        }
        int i =0;
        int jump=0;
        while(jump <minJump){
            i = Math.min(i + maxJump, len - 1);
            if(i==len-1){
                return true;
            }
            jump++;
        }
        return false;
    }
}
