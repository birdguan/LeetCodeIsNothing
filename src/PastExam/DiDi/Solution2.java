package PastExam.DiDi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

class Road {
    int node;
    int t;

    public Road(int n, int t) {
        this.node = n;
        this.t = t;
    }
}

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if (n == 0) {
            scanner.nextInt();
            scanner.nextInt();
            System.out.println(scanner.next());
            return;
        }
        LinkedList<Road>[] links = new LinkedList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            links[i] = new LinkedList<Road>();
        }
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int t = scanner.nextInt();
            links[u].add(new Road(v, t));
            links[v].add(new Road(u, t));
        }
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        int[] status = new int[n + 1];
        distances[start] = 0;
        int cursor = start;
        while (true) {
            for (Road road : links[cursor]) {
                int dis = road.t + distances[cursor];
                if (dis < distances[road.node]) {
                    distances[road.node] = dis;
                }
            }
            status[cursor] = 1;
            int minDis = Integer.MAX_VALUE;
            int nearestNode = -1;
            for (int i = 1; i < n + 1; i++) {
                if (status[i] == 0 && distances[i] < minDis) {
                    minDis = distances[i];
                    nearestNode = i;
                }
            }
            if (nearestNode == -1) {
                break;
            }
            cursor = nearestNode;
        }
        int t = distances[end];
        DateFormat format = new SimpleDateFormat("yyyy-M.d/H");
        try {
            Date s = format.parse("2020-" + scanner.next());
            s.setTime(s.getTime() + t * 1000 * 60 * 60);
            String ss = format.format(s);
            System.out.println(ss.substring(5));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}