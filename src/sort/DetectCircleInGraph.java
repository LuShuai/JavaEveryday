package sort;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by shuailu on 4/27/16.
 *
 * Two ways to detect if there exists a circle in a graph
 *
 */
public class DetectCircleInGraph {

    static class Graph {
        int vertexNum;
        LinkedList<Integer>[] edges;

        public Graph(int num) {
            vertexNum = num;
            edges = new LinkedList[vertexNum];
            for (int n = 0; n < num; n++) {
                edges[n] = new LinkedList<Integer>();
            }
        }

        public void add(int start, int end) {
            edges[start].add(end);
        }

    }

    /*dfs version*/
    public static boolean hasCircle(Graph graph) {
        if (graph == null) {
            return false;
        }
        HashSet<Integer> visited = new HashSet<Integer>();
        HashSet<Integer> visiting = new HashSet<Integer>();
        for (int n = 0; n < graph.vertexNum; n++) {
            if (!visited.contains(n) && inACircle(graph, n, visiting, visited)) {
                return true;
            }
        }
        return false;
    }


    private static boolean inACircle(Graph graph, int currentVertex, HashSet<Integer> visiting, HashSet<Integer> visited) {
        if (visiting.contains(currentVertex)) {
            return true;
        }
        visiting.add(currentVertex);
        visited.add(currentVertex);

        LinkedList<Integer> outgoingEdges = graph.edges[currentVertex];
        for (Integer destination : outgoingEdges) {
            if (inACircle(graph, destination, visiting, visited)) {
                return true;
            }
        }
        visiting.remove(currentVertex);
        return false;
    }

    public static void main(String[] args) {
        //test dfs
        //no circle
        Graph graph1 = new Graph(3);
        graph1.add(0, 1);
        graph1.add(1, 2);
        graph1.add(0, 2);
        test(graph1);

        //1 circle
        Graph graph2 = new Graph(3);
        graph2.add(0, 1);
        graph2.add(1, 2);
        graph2.add(2, 0);
        test(graph2);

        //self circle
        Graph graph3 = new Graph(3);
        graph3.add(0, 1);
        graph3.add(0, 2);
        graph3.add(2, 2);
        test(graph3);


    }

    public static void test(Graph graph) {
        System.out.println("Has circle: " + hasCircle(graph));
    }

}
