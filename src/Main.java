public class Main {
    public static void main(String[] args) throws Exception {
        Graph graph=new Graph();
        graph.initialize("src/input1.txt");
//        graph.printEdgeList();
//        graph.printAdjacencyMatrix();
        int[] costs =new int[graph.size()];
        int[] parents =new int[graph.size()];
        graph.BellmanFord(0,costs,parents);
        graph.dist1d(costs,0);
        graph.printParents(parents);
    }
}
