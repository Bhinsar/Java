
import java.util.HashMap;

class TitleToNumber {
    public static void main(String[] args) {
        String columnTitle = "A";
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int value = columnTitle.charAt(i) - 'A' + 1;
            result = result * 26 + value;
        }
        System.out.println("result: "+result);
    }
}