public class HollowSquare {
    public static void main(String[] args) {
        int row = 5;
        for(int i = 0; i <row;i++){
            if(i == 0 || i == row-1){
                System.out.println("* ".repeat(row));
            }else{
                System.out.print("* ");
                System.out.print("  ".repeat(row-2));
                System.out.println("* ");
            }
        }
    }
}
