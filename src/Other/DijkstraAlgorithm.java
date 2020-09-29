//package Other;
//
//import java.util.LinkedList;
//import java.util.Map;
//import java.util.Scanner;
//
//public class DijkstraAlgorithm {
//    private static class Vertex {
//        int city;
//
//        public Vertex(int city) {
//            this.city = city;
//        }
//    }
//
//    private static class Edge {
//        int index, weight;
//
//        public Edge(int index, int weight) {
//            this.index = index;
//            this.weight = weight;
//        }
//    }
//
//    private static class Graph {
//        private Vertex[] vertices;
//        private LinkedList<Edge>[] adj;
//
//        Graph(int size) {
//            vertices = new Vertex[size];
//            adj = new LinkedList[size];
//            for (int i = 0; i < adj.length; i++) {
//                adj[i] = new LinkedList<Edge>();
//            }
//        }
//    }
//
//    private static void initGraph(Scanner scanner) {
//        int cities = scanner.nextInt();
//        int roads = scanner.nextInt();
//        int queries = scanner.nextInt();
//        Graph graph = new Graph(cities);
//        for (int i = 1; i <= cities; i++) {
//            graph.vertices[i] = new Vertex(i);
//        }
//        for (int i = 0; i < roads; i++) {
//            graph.adj[scanner.nextInt()].add(new Edge(scanner.nextInt(), scanner.nextInt()));
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        initGraph(scanner);
//    }
//
//    public static Map<Integer, Integer> dijktra(Graph graph, int startIndex) {
//
//    }
//
//
//}
//
//
