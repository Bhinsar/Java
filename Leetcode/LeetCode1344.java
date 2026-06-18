public class LeetCode1344 {
    public static double angleClock(int hour, int minutes) {
        double hourAngle = 30 * hour + 0.5 * minutes;
        double minAngle = 6 * minutes;
        double angle = Math.abs(hourAngle - minAngle);
        if (angle > 180) {
            return 360 - angle;
        }
        return angle;
    }

    public static void main(String[] args) {
        System.out.println("res1: " + angleClock(12, 30));
        System.out.println("res2: " + angleClock(3, 30));
        System.out.println("res3: " + angleClock(3, 15));
    }
}
