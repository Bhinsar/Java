public class LeetCode657 {
    public static void main(String[] args) {
        String moves = "UD";
        System.out.println("result: " + judgeCircle(moves));
    }

    public static boolean judgeCircle(String moves) {
        int x = 0, y = 0;

        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U' -> y++;
                case 'D' -> y--;
                case 'R' -> x++;
                case 'L' -> x--;
                default -> {
                }
            }
        }

        return x == 0 && y == 0;
    }
}
