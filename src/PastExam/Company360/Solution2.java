package PastExam.Company360;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if (str.length() < 8) {
                System.out.println("Irregular password");
                continue;
            }
            int[] records = new int[4];
            for (char ch : str.toCharArray()) {
                if (ch >= '0' && ch <= '9') records[0]++;
                else if (ch >= 'A' && ch <= 'Z') records[1]++;
                else if (ch >= 'a' && ch <= 'z') records[2]++;
                else records[3]++;
            }
            if (records[0] == 0 || records[1] == 0 || records[2] == 0 || records[3] == 0) {
                System.out.println("Irregular password");
            } else {
                System.out.println("Ok");
            }
        }
    }
}
