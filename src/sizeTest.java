import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class sizeTest {

    Graph G=new Graph();


    @Test
    void size_64_32() {
        try {
            G.initialize("src/testFiles/weighted_graph1.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[] costsDijkstra =new int[G.size()];
        int[] parentsDijkstra =new int[G.size()];

        int[] costsBellman =new int[G.size()];
        int[] parentsBellman =new int[G.size()];

        int[] costsFloyds =new int[G.size()];
        int[] parentsFloyds =new int[G.size()];

        long startTimeDijkstra = System.nanoTime();
        G.Dijkstra(0,costsDijkstra,parentsDijkstra);
        long endTimeDijkstra = System.nanoTime();

        long startTimeBellman = System.nanoTime();
        G.BellmanFord(0,costsBellman,parentsBellman);
        long endTimeBellman = System.nanoTime();

//        long startTimeFloyds = System.nanoTime();
//        G.FloydWarshall(0,costsFloyds,parentsFloyds);
//        long endTimeDijkstra = System.nanoTime();

        assertArrayEquals(costsDijkstra,costsBellman);
        assertArrayEquals(parentsDijkstra,parentsFloyds);

        System.out.println("Dikstra Time = "+ (endTimeDijkstra - startTimeDijkstra));
        System.out.println("Bellman Time = "+ (endTimeBellman - startTimeBellman));

    }

    @Test
    void size_64_64() {
        try {
            G.initialize("src/testFiles/weighted_graph2l.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[] costsDijkstra =new int[G.size()];
        int[] parentsDijkstra =new int[G.size()];

        int[] costsBellman =new int[G.size()];
        int[] parentsBellman =new int[G.size()];

        int[] costsFloyds =new int[G.size()];
        int[] parentsFloyds =new int[G.size()];

        long startTimeDijkstra = System.nanoTime();
        G.Dijkstra(0,costsDijkstra,parentsDijkstra);
        long endTimeDijkstra = System.nanoTime();

        long startTimeBellman = System.nanoTime();
        G.BellmanFord(0,costsBellman,parentsBellman);
        long endTimeBellman = System.nanoTime();

//        long startTimeFloyds = System.nanoTime();
//        G.FloydWarshall(0,costsFloyds,parentsFloyds);
//        long endTimeDijkstra = System.nanoTime();

        System.out.println("Dikstra Time = "+ (endTimeDijkstra - startTimeDijkstra));
        System.out.println("Bellman Time = "+ (endTimeBellman - startTimeBellman));

        assertArrayEquals(costsDijkstra,costsBellman);
        assertArrayEquals(parentsDijkstra,parentsFloyds);


        System.out.println("Dikstra Time = "+ (endTimeDijkstra - startTimeDijkstra));
        System.out.println("Bellman Time = "+ (endTimeBellman - startTimeBellman));

    }


}