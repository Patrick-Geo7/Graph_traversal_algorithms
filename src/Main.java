import java.util.Objects;
import java.util.Scanner;
public class Main {
    public int whichAlgorithm(boolean hasNegative){
        Scanner s=new Scanner(System.in);
        System.out.println("enter 1 for bellman algorithm");
        System.out.println("enter 2 for Floyd Warshall algorithm");
        if (!hasNegative)
            System.out.println("enter 3 for dijkstra algorithm");
        System.out.println("\u001B[34m"+"<-- enter -1 to return"+"\u001B[0m");
        return s.nextInt();
    }
    public boolean sourceInBound(int s,Graph G){
        return s >= 0 && s < G.size();
    }
    public boolean destinationInBound(int s,int d,Graph G){
        return d >= 0 && d < G.size() && d!=s;
    }
    public void menu() throws Exception {
        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_PURPLE = "\u001B[35m";
        String ANSI_YELLOW = "\u001B[1m";
        while (true) {
            System.out.println("enter the file path describing the graph");
            System.out.println(ANSI_BLUE+"<-- enter -1 to exit"+ANSI_RESET);
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
            int[][] costsF = new int[size][size];
            int[][] predecessors = new int[size][size];
            int[] parents = new int[size];
            int whichAlg;
            System.out.println("enter 1 to find shortest path from source node to all other nodes");
            System.out.println("enter 2 to finds the shortest paths between all the pairs of nodes");
            System.out.println(ANSI_BLUE +"<-- enter -1 to exit"+ ANSI_RESET);
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
                                    System.out.println(ANSI_PURPLE+"--------Dijkstra's algorithm-------"+ANSI_RESET);
                                    System.out.println("enter number of source vertex ");
                                    System.out.println(ANSI_BLUE +"<-- enter -1 to return"+ ANSI_RESET);
                                    source = s.nextInt();
                                    if (source==-1)
                                        break;
                                    if(!sourceInBound(source,G)) {
                                        System.out.println(ANSI_RED+"source out of bound"+ANSI_RESET);

                                        continue;
                                    }
                                    long startTime = System.nanoTime();
                                    G.Dijkstra(source, costs, parents);
                                    long endTime = System.nanoTime();
                                    while (true) {
                                        System.out.println("enter destination node for source "+source);
                                        System.out.println(ANSI_BLUE +"<-- enter -1 to return"+ ANSI_RESET);
                                        destination = s.nextInt();
                                        if (destination == -1)
                                            break;
                                        else if(!destinationInBound(source,destination,G)) {
                                            System.out.println(ANSI_RED+"Destination out of bound !"+ANSI_RESET);
                                            continue;
                                        }
                                        System.out.print(ANSI_YELLOW);
                                        System.out.println("cost from "+source+" to "+destination+" = " +costs[destination]);
                                        long t=(endTime - startTime )/ 1000;
                                        System.out.println("time = "+ (float)t/1000+" ms\n");
                                        System.out.print(ANSI_RESET);
                                    }
                                }
                            }
                            case 1 -> {
                                while (true) {
                                    System.out.println(ANSI_PURPLE+"--------BellmanFords's algorithm-------"+ANSI_RESET);
                                    System.out.println("enter number of source vertex");
                                    System.out.println(ANSI_BLUE +"<-- enter -1 to return"+ ANSI_RESET);
                                    source = s.nextInt();
                                    if (source == -1)
                                        break;
                                    if(!sourceInBound(source,G)) {
                                        System.out.println(ANSI_RED+"source out of bound"+ANSI_RESET);
                                        continue;
                                    }
                                    long startTime = System.nanoTime();
                                    boolean Nocycle=G.BellmanFord(source, costs, parents);
                                    long endTime = System.nanoTime();
                                    while (true) {
                                        System.out.println("enter destination node for source "+source);
                                        System.out.println(ANSI_BLUE +"<-- enter -1 to return"+ ANSI_RESET);
                                        destination = s.nextInt();
                                        if (destination == -1)
                                            break;
                                        else if(!destinationInBound(source,destination,G)) {
                                            System.out.println(ANSI_RED+"Destination out of bound !"+ANSI_RESET);
                                            continue;
                                        }
                                        System.out.print(ANSI_YELLOW);
                                        System.out.println("cost from "+source+" to "+destination+" = " +costs[destination]);
                                        long t=(endTime - startTime )/ 1000;
                                        System.out.println("time = "+ (float)t/1000+" ms\n");
                                        System.out.println("can be solved "+Nocycle);
                                        System.out.print(ANSI_RESET);


                                    }
                                }
                            }
                            case 2 -> {
                                long startTime = System.nanoTime();
                                boolean Nocycle=G.FloydWarshall(costsF, predecessors);
                                long endTime = System.nanoTime();
                                System.out.println(ANSI_PURPLE+"--------Floyd Warshall's algorithm-------"+ANSI_RESET);
                                System.out.println("enter source");
                                System.out.println(ANSI_BLUE +"<-- enter -1 to return"+ ANSI_RESET);
                                source = s.nextInt();
                                if (source == -1)
                                    break;
                                if(!sourceInBound(source,G)) {

                                    continue;
                                }
                                while (true) {
                                    System.out.println("enter destination node for source "+source);
                                    System.out.println(ANSI_BLUE +"<-- enter -1 to return"+ ANSI_RESET);
                                    destination = s.nextInt();
                                    if (destination == -1)
                                        break;
                                    else if(!sourceInBound(destination,G)) {
                                        System.out.println(ANSI_RED+"Destination out of bound !"+ANSI_RESET);
                                        continue;
                                    }
                                    System.out.print(ANSI_YELLOW);
                                    System.out.println("cost from "+source+" to "+destination+" = " +costsF[source][destination]);
                                    long t=(endTime - startTime )/ 1000;
                                    System.out.println("time = "+ (float)t/1000+" ms\n");
                                    System.out.println("can be solved "+Nocycle);
                                    System.out.print(ANSI_RESET);

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
                                    System.out.println(ANSI_PURPLE+"--------Dijkstra's algorithm-------"+ANSI_RESET);
                                    System.out.println("enter source");
                                    System.out.println(ANSI_BLUE +"<-- enter -1 to return"+ ANSI_RESET);
                                    source = s.nextInt();
                                    if (source == -1)
                                        break;
                                    if(!sourceInBound(source,G)) {
                                        System.out.println(ANSI_RED+"source out of bound"+ANSI_RESET);
                                        continue;
                                    }
                                    long startTime = System.nanoTime();
                                    for(int i=0;i< G.size();i++){
                                        G.Dijkstra(i, costsF[i], parents);
                                    }
                                    long endTime = System.nanoTime();
                                    System.out.println("enter destination");
                                    System.out.println(ANSI_BLUE +"<-- enter -1 to return"+ ANSI_RESET);
                                    destination = s.nextInt();
                                    if (destination == -1)
                                        break;
                                    else if(!destinationInBound(source,destination,G)) {
                                        System.out.println(ANSI_RED+"Destination out of bound !"+ANSI_RESET);
                                        continue;
                                    }
                                    System.out.print(ANSI_YELLOW);
                                    System.out.println("cost from " + source + " to " + destination + " = "  + costsF[source][destination]);
                                    long t=(endTime - startTime )/ 1000;
                                    System.out.println("time = "+ (float)t/1000+" ms\n");
                                    System.out.print(ANSI_RESET);
                                    costsF=new int[G.size()][G.size()];
                                    parents=new int[G.size()];

                                }
                            }
                            case 1 -> {
                                while (true) {
                                    System.out.println(ANSI_PURPLE+"--------BellmanFords's algorithm-------"+ANSI_RESET);
                                    System.out.println("enter source");
                                    System.out.println(ANSI_BLUE +"<-- enter -1 to return"+ ANSI_RESET);
                                    source = s.nextInt();
                                    if (source == -1)
                                        break;
                                    if(!sourceInBound(source,G)) {
                                        System.out.println(ANSI_RED+"source out of bound"+ANSI_RESET);
                                        continue;
                                    }
                                    boolean Nocycle=true;
                                    long startTime = System.nanoTime();
                                    for(int i=0;i< G.size();i++){
                                        Nocycle=G.BellmanFord(i,costsF[i],parents);
                                    }
                                    long endTime = System.nanoTime();
                                    System.out.println("enter destination");
                                    System.out.println(ANSI_BLUE +"<-- enter -1 to return"+ ANSI_RESET);
                                    destination = s.nextInt();
                                    if (destination == -1)
                                        break;
                                    else if(!destinationInBound(source,destination,G)) {
                                        System.out.println(ANSI_RED+"Destination out of bound !"+ANSI_RESET);
                                        continue;
                                    }
                                    System.out.print(ANSI_YELLOW);
                                    System.out.println("cost from " + source + " to " + destination + " = " + costsF[source][destination]);
                                    long t=(endTime - startTime )/ 1000;
                                    System.out.println("time = "+ (float)t/1000+" ms\n");
                                    System.out.println("can be solved "+Nocycle);
                                    System.out.print(ANSI_RESET);
                                    costsF=new int[G.size()][G.size()];
                                    parents=new int[G.size()];

                                }
                            }
                            case 2 -> {
                                while (true) {
                                    System.out.println(ANSI_PURPLE+"--------Floyd Warshall's algorithm-------"+ANSI_RESET);
                                    System.out.println("enter source");
                                    System.out.println(ANSI_BLUE +"<-- enter -1 to return"+ ANSI_RESET);
                                    source = s.nextInt();
                                    if (source == -1)
                                        break;
                                    if(!sourceInBound(source,G)) {
                                        System.out.println(ANSI_RED+"source out of bound"+ANSI_RESET);
                                        continue;
                                    }
                                    long startTime = System.nanoTime();
                                    boolean Nocycle=G.FloydWarshall(costsF,predecessors);
                                    long endTime = System.nanoTime();
                                    System.out.println("enter destination ");
                                    System.out.println(ANSI_BLUE +"<-- enter -1 to return"+ ANSI_RESET);
                                    destination = s.nextInt();
                                    if (destination == -1)
                                        break;
                                    else if(!destinationInBound(source,destination,G)) {
                                        System.out.println(ANSI_RED+"Destination out of bound !"+ANSI_RESET);
                                        continue;
                                    }
                                    System.out.print(ANSI_YELLOW);
                                    System.out.println("cost from " + source + " to " + destination + " = " + costsF[source][destination]);
                                    long t=(endTime - startTime )/ 1000;
                                    System.out.println("time = "+ (float)t/1000+" ms\n");
                                    System.out.println("can be solved "+Nocycle);
                                    System.out.print(ANSI_RESET);
                                    costsF=new int[G.size()][G.size()];
                                    parents=new int[G.size()];

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
//        Graph sama=new Graph();
//
//        long costs[][]=new long[5][5];
//        long pre[][]={{0,3,8,100000,-4},{100000,0,100000,1,7},{100000,4,0,-5,100000},{2,100000,100000,6,0},{100000,100000,100000,6,0}};
//        sama.FloydWarshall(costs,pre);
//        System.out.println(sama.V);
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.print(costs[i][j] + " ");
//            }
//            System.out.print("\n");
//        }
    }
}
