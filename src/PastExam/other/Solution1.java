package PastExam.other;

import com.sun.webkit.SimpleSharedBufferInputStream;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int[] nums = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            nums[i] = str.charAt(i) - '0';
        }
        int res = minKBitFlips(nums);
        System.out.println(res);
    }

    public static int minKBitFlips(int[] A) {
        int N = A.length;
        int[] hint = new int[N];
        int ans = 0, flip = 0;
        for (int i = 0; i < N; ++i) {
            flip ^= hint[i];
            if (A[i] == flip) {
                ans++;
                flip ^= 1;
                hint[i] ^= 1;
            }
        }

        return ans-1;
    }
}

class SingleTon {
    private volatile static SingleTon instance;
    private SingleTon() {}
    public synchronized static SingleTon getInstance() {
        if (instance == null) {
            synchronized (SingleTon.class) {
                if (instance == null) {
                    instance = new SingleTon();
                }
            }
        }
        return instance;
    }
}
