
import java.util.ArrayList;

public class LeetCode1622 {
    public static void main(String[] args) {
        Fancy obj = new Fancy();
        obj.append(2);
        obj.addAll(3);
        obj.append(7);
        obj.multAll(2);
        System.out.println(obj.getIndex(0));
        obj.addAll(3);
        obj.append(10);
        obj.multAll(2);
        System.out.println(obj.getIndex(0));
        System.out.println(obj.getIndex(1));
        System.out.println(obj.getIndex(2));
    }
}

class Fancy {

    ArrayList<Long> list = new ArrayList<>();
    long add = 0;
    long mult = 1;
    private static final int MOD = 1_000_000_007;

    private long power(long x, int y) {
        long res = 1;
        x %= MOD;
        while (y > 0) {
            if (y % 2 == 1) res = (res * x) % MOD;
            x = (x * x) % MOD;
            y >>= 1;
        }
        return res;
    }

    public Fancy() {

    }

    public void append(int val) {
        long base = (val - add + MOD) % MOD;
        base = (base * power(mult, MOD - 2)) % MOD;
        list.add(base);
    }

    public void addAll(int inc) {
        add =(add + inc) % MOD;
    }

    public void multAll(int m) {
        mult = (mult * m) % MOD ;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= list.size())
            return -1;
        return (int) ((list.get(idx) * mult + add) % MOD);
    }
}
