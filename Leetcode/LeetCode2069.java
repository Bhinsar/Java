class LeetCode2069 {
    public static void main(String[] args) {

        Robot robot = new Robot(6, 3); // Initialize the grid and the robot at (0, 0) facing East.
        robot.step(2); // It moves two steps East to (2, 0), and faces East.
        robot.step(2); // It moves two steps East to (4, 0), and faces East.
        int pos[] = new int[2];
        pos = robot.getPos(); // return [4, 0]

        System.out.println("pos");
        for (int num : pos) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("dir: " + robot.getDir()); // return "East"
        robot.step(2); // It moves one step East to (5, 0), and faces East.
                       // Moving the next step East would be out of bounds, so it turns and faces
                       // North.
                       // Then, it moves one step North to (5, 1), and faces North.
        robot.step(1); // It moves one step North to (5, 2), and faces North (not West).
        robot.step(4); // Moving the next step North would be out of bounds, so it turns and faces
                       // West.
                       // Then, it moves four steps West to (1, 2), and faces West.
        pos = robot.getPos(); // return [1, 2]
        System.out.println("pos");
        for (int num : pos) {
            System.out.print(num + " ");
        }
        System.out.println("dir: " + robot.getDir()); // return "West"
    }
}

class Robot {
    private int width;
    private int height;
    private int totalSteps = 0;
    private int perimeter;
    private boolean moved = false;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width - 1) + 2 * (height - 1);
    }

    public void step(int num) {
        moved = true;
        // Use modulo to skip full laps
        totalSteps = (totalSteps + num) % perimeter;
        // If we complete a full lap and land at (0,0),
        // we must treat it as having finished the lap (facing South).
        if (totalSteps == 0) {
            totalSteps = perimeter;
        }
    }

    public int[] getPos() {
        int s = totalSteps;
        // 1. Bottom Edge (East)
        if (s < width)
            return new int[] { s, 0 };
        s -= (width - 1);

        // 2. Right Edge (North)
        if (s < height)
            return new int[] { width - 1, s };
        s -= (height - 1);

        // 3. Top Edge (West)
        if (s < width)
            return new int[] { width - 1 - s, height - 1 };
        s -= (width - 1);

        // 4. Left Edge (South)
        return new int[] { 0, height - 1 - s };
    }

    public String getDir() {
        // Initial state check
        if (!moved || totalSteps == 0)
            return "East";

        int s = totalSteps;
        // Note the boundaries: if s is exactly at a corner,
        // the direction is the one it used to arrive there.
        if (s > 0 && s <= width - 1)
            return "East";
        if (s > width - 1 && s <= (width - 1) + (height - 1))
            return "North";
        if (s > (width - 1) + (height - 1) && s <= 2 * (width - 1) + (height - 1))
            return "West";
        return "South";
    }
}