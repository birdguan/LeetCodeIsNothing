package PastExam.Qushi;

import java.util.Scanner;

public class Solution1 {
    private static char[] inorder, postorder;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(" ");
        String inorderStr = strs[0], postorderStr = strs[1];
        inorder = new char[inorderStr.length()];
        for (int i = 0; i < inorderStr.length(); i++) {
            inorder[i] = inorderStr.charAt(i);
        }
        postorder = new char[postorderStr.length()];
        for (int i = 0; i < postorderStr.length(); i++) {
            postorder[i] = postorderStr.charAt(i);
        }
        pre(postorder.length - 1, 0, postorder.length - 1);
    }

    private static void pre(int root, int start, int end) {
        if (start > end) return;
        int i = start;
        while (i < end && inorder[i] != postorder[root]) i++;
        System.out.print(postorder[root]);
        pre(root-1-end+i, start, i-1);
        pre(root-1, i+1, end);
    }
}
