import java.util.Objects;
import java.util.Scanner;

public class Main {
    public int whichAlgorithm(boolean hasNegative){
        Scanner s=new Scanner(System.in);
        System.out.println("enter 1 for bellman algorithm");
        System.out.println("enter 2 for Floyd Warshall algorithm");
        if (!hasNegative)
            System.out.println("enter 3 for dijkstra algorithm");
        System.out.println("enter -1 to return");
        return s.nextInt();
    }
    public boolean sourceInBound(int s,Graph G){
        return s >= 0 && s < G.size();
    }
    public boolean destinationInBound(int s,int d,Graph G){
        return d >= 0 && d < G.size() && d!=s;
    }
    public void menu() throws Exception {
        while (true) {
            System.out.println("enter the file path describing the graph");
            System.out.println("enter -1 to exit");
            Scanner s = new Scanner(System.in);
            String path = s.nextLine();

            if(Objects.equals(path, "-1"))
                break;
            Graph G = new Graph();
            G.initialize(path);
            int source;
            int destination;
            int size = G.size() ;
            int[] costs = new int[size];
            long[][] costsF = new long[size][size];
            long[][] predecessors = new long[size][size];
            int[] parents = new int[size];
            int whichAlg;
            System.out.println("enter 1 to find shortest path from source node to all other nodes");
            System.out.println("enter 2 to finds the shortest paths between all the pairs of nodes");
            System.out.println("enter -1 to exit");
            int oneOrTwo = s.nextInt();
            if (oneOrTwo==-1)
                break;
            switch (oneOrTwo) {
                case 1 -> {
                    while (true) {
                        whichAlg=whichAlgorithm(G.hasNegative);
                        if(whichAlg==-1)
                            break;
                        switch (whichAlg) {
                            case 3 -> {
                                while (true) {
                                    System.out.println("--------Dijkstra's algorithm-------");
                                    System.out.println("enter number of source vertex ");
                                    System.out.println("enter -1 to return");
                                    source = s.nextInt();
                                    if (source==-1)
                                        break;
                                    if(!sourceInBound(source,G)) {
                                        System.out.println("source out of bound");
                                        break;
                                    }
                                    long startTime = System.nanoTime();
                                    G.Dijkstra(source, costs, parents);
                                    long endTime = System.nanoTime();
                                    while (true) {
                                        System.out.println("enter destination node for source "+source);
                                        System.out.println("enter -1 to finish");
                                        destination = s.nextInt();
                                        if (destination == -1)
                                            break;
                                        else if(!destinationInBound(source,destination,G)) {
                                            System.out.println("Destination out of bound !");
                                            break;
                                        }
                                        System.out.println("cost from "+source+" to "+destination+" = " +costs[destination]);
                                        long t=(endTime - startTime )/ 1000;
                                        System.out.println("time = "+ (float)t/1000+" ms\n");
                                    }
                                }
                            }
                            case 1 -> {
                                while (true) {
                                    System.out.println("--------BellmanFords's algorithm-------");
                                    System.out.println("enter number of source vertex");
                                    System.out.println("enter -1 to return");
                                    source = s.nextInt();
                                    if (source == -1)
                                        break;
                                    if(!sourceInBound(source,G)) {
                                        System.out.println("source out of bound");
                                        break;
                                    }
                                    long startTime = System.nanoTime();
                                    G.BellmanFord(source, costs, parents);
                                    long endTime = System.nanoTime();
                                    while (true) {
                                        System.out.println("enter destination node for source "+source);
                                        System.out.println("enter -1 to finish");
                                        destination = s.nextInt();
                                        if (destination == -1)
                                            break;
                                        else if(!destinationInBound(source,destination,G)) {
                                            System.out.println("Destination out of bound !");
                                            break;
                                        }
                                        System.out.println("cost from "+source+" to "+destination+" = " +costs[destination]);
                                        long t=(endTime - startTime )/ 1000;
                                        System.out.println("time = "+ (float)t/1000+" ms\n");

                                    }
                                }
                            }
                            case 2 -> {
                                long startTime = System.nanoTime();
                                G.FloydWarshall(costsF, predecessors);
                                long endTime = System.nanoTime();
                                System.out.println("--------Floyd Warshall's algorithm-------");
                                System.out.println("enter source");
                                System.out.println("enter -1 to exit process");
                                source = s.nextInt();
                                if (source == -1)
                                    break;
                                if(!sourceInBound(source,G)) {
                                    System.out.println("source out of bound");
                                    break;
                                }
                                while (true) {
                                    System.out.println("enter destination node for source "+source);
                                    System.out.println("enter -1 to exit process");
                                    destination = s.nextInt();
                                    if (destination == -1)
                                        break;
                                    else if(!sourceInBound(destination,G)) {
                                        System.out.println("Destination out of bound !");
                                        break;
                                    }
                                    System.out.println("cost from "+source+" to "+destination+" = " +costsF[source][destination]);
                                    long t=(endTime - startTime )/ 1000;
                                    System.out.println("time = "+ (float)t/1000+" ms\n");
                                }
                            }
                        }
                    }
                }
                case 2 -> {
                    while (true) {
                        int w=whichAlgorithm(G.hasNegative);
                        if (w==-1)
                            break;
                        switch (w) {
                            case 3 -> {
                                while (true) {
                                    System.out.println("--------Dijkstra's algorithm-------");
                                    System.out.println("enter source");
                                    System.out.println("enter -1 to exit process");
                                    source = s.nextInt();
                                    if (source == -1)
                                        break;
                                    if(!sourceInBound(source,G)) {
                                        System.out.println("source out of bound");
                                        break;
                                    }
                                    long startTime = System.nanoTime();
                                    G.Dijkstra(source, costs, parents);
                                    long endTime = System.nanoTime();
                                    System.out.println("enter destination");
                                    System.out.println("enter -1 to exit process");
                                    destination = s.nextInt();
                                    if (destination == -1)
                                        break;
                                    else if(!destinationInBound(source,destination,G)) {
                                        System.out.println("Destination out of bound !");
                                        break;
                                    }
                                    System.out.println("cost from " + source + " to " + destination + " = "  + costs[destination]);
                                    long t=(endTime - startTime )/ 1000;
                                    System.out.println("time = "+ (float)t/1000+" ms\n");
                                }
                            }
                            case 1 -> {
                                while (true) {
                                    System.out.println("--------BellmanFords's algorithm-------");
                                    System.out.println("enter source");
                                    System.out.println("enter -1 to exit process");
                                    source = s.nextInt();
                                    if (source == -1)
                                        break;
                                    if(!sourceInBound(source,G)) {
                                        System.out.println("source out of bound");
                                        break;
                                    }
                                    long startTime = System.nanoTime();
                                    G.BellmanFord(source, costs, parents);
                                    long endTime = System.nanoTime();
                                    System.out.println("enter destination");
                                    System.out.println("enter -1 to exit process");
                                    destination = s.nextInt();
                                    if (destination == -1)
                                        break;
                                    else if(!destinationInBound(source,destination,G)) {
                                        System.out.println("Destination out of bound !");
                                        break;
                                    }
                                    System.out.println("cost from " + source + " to " + destination + " = " + costs[destination]);
                                    long t=(endTime - startTime )/ 1000;
                                    System.out.println("time = "+ (float)t/1000+" ms\n");
                                }
                            }
                            case 2 -> {
                                while (true) {
                                    System.out.println("--------Floyd Warshall's algorithm-------");
                                    System.out.println("enter source");
                                    System.out.println("enter -1 to exit process");
                                    source = s.nextInt();
                                    if (source == -1)
                                        break;
                                    if(!sourceInBound(source,G)) {
                                        System.out.println("source out of bound");
                                        break;
                                    }
                                    long startTime = System.nanoTime();
                                    G.FloydWarshall(costsF, predecessors);
                                    long endTime = System.nanoTime();
                                    System.out.println("enter destination ");
                                    System.out.println("enter -1 to exit process\n");
                                    destination = s.nextInt();
                                    if (destination == -1)
                                        break;
                                    else if(!destinationInBound(source,destination,G)) {
                                        System.out.println("Destination out of bound !");
                                        break;
                                    }
                                    System.out.println("cost from " + source + " to " + destination + " = " + costsF[source][destination]);
                                    long t=(endTime - startTime )/ 1000;
                                    System.out.println("time = "+ (float)t/1000+" ms\n");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
//        Graph graph=new Graph();
//        graph.initialize("src/testFiles/input3.txt");
////        graph.printEdgeList();
////        graph.printAdjacencyMatrix();
//        int[] costs =new int[graph.size()];
//        int[] parents =new int[graph.size()];
//        graph.BellmanFord(7,costs,parents);
//        graph.dist1d(costs,0);
//        graph.printParents(parents);
        Main m=new Main();
       m.menu();
    }
}
