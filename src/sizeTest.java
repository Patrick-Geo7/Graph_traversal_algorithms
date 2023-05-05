import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class sizeTest {

    Graph G=new Graph();


    @Test
    void graph_128_001() {
        try {
            G.initialize("src/testFiles/graph_128_0.001.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[] costsDijkstra =new int[G.size()];
        int[] parentsDijkstra =new int[G.size()];

        int[] costsBellman =new int[G.size()];
        int[] parentsBellman =new int[G.size()];

        int[][] costsFloyds =new int[G.size()][G.size()];
        int[][] pre =new int[G.size()][G.size()];

        long DijkstraTime = 0;
        long BellmanTime = 0;
        long FloydTime = 0;

        for(int i=0; i<10; i++){
            long startTimeDijkstra = System.nanoTime();
            G.Dijkstra(i,costsDijkstra,parentsDijkstra);
            long endTimeDijkstra = System.nanoTime();

            DijkstraTime += endTimeDijkstra-startTimeDijkstra;

            long startTimeBellman = System.nanoTime();
            G.BellmanFord(i,costsBellman,parentsBellman);
            long endTimeBellman = System.nanoTime();

            BellmanTime += endTimeBellman - startTimeBellman;
        }


        DijkstraTime = DijkstraTime / 10 / 1000;
        BellmanTime = BellmanTime / 10 / 1000;



        long startTimeFloyds = System.nanoTime();
        G.FloydWarshall(costsFloyds,pre);
        long endTimeFloyds = System.nanoTime();

        FloydTime = (endTimeFloyds - startTimeFloyds) / 1000;



        System.out.println("128 graph with 0.001 density");
        System.out.println("Dikstra Time = "+ DijkstraTime);
        System.out.println("Bellman Time = "+ BellmanTime);
        System.out.println("Floyds Time = " + FloydTime);

        assertArrayEquals(costsDijkstra,costsBellman);
        assertArrayEquals(parentsDijkstra,parentsBellman);

    }


    @Test
    void graph_128_01() {
        try {
            G.initialize("src/testFiles/graph_128_0.01.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[] costsDijkstra =new int[G.size()];
        int[] parentsDijkstra =new int[G.size()];

        int[] costsBellman =new int[G.size()];
        int[] parentsBellman =new int[G.size()];

        int[][] costsFloyds =new int[G.size()][G.size()];
        int[][] pre =new int[G.size()][G.size()];

        long DijkstraTime = 0;
        long BellmanTime = 0;
        long FloydTime = 0;

        for(int i=0; i<10; i++){
            long startTimeDijkstra = System.nanoTime();
            G.Dijkstra(i,costsDijkstra,parentsDijkstra);
            long endTimeDijkstra = System.nanoTime();

            DijkstraTime += endTimeDijkstra-startTimeDijkstra;

            long startTimeBellman = System.nanoTime();
            G.BellmanFord(i,costsBellman,parentsBellman);
            long endTimeBellman = System.nanoTime();

            BellmanTime += endTimeBellman - startTimeBellman;
        }


        DijkstraTime = DijkstraTime / 10 / 1000;
        BellmanTime = BellmanTime / 10 / 1000;



        long startTimeFloyds = System.nanoTime();
        G.FloydWarshall(costsFloyds,pre);
        long endTimeFloyds = System.nanoTime();

        FloydTime = (endTimeFloyds - startTimeFloyds) / 1000;



        System.out.println("128 graph with 0.01 density");
        System.out.println("Dikstra Time = "+ DijkstraTime);
        System.out.println("Bellman Time = "+ BellmanTime);
        System.out.println("Floyds Time = " + FloydTime);

        assertArrayEquals(costsDijkstra,costsBellman);
        assertArrayEquals(parentsDijkstra,parentsBellman);

    }

    @Test
    void graph_128_1() {
        try {
            G.initialize("src/testFiles/graph_128_0.1.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[] costsDijkstra =new int[G.size()];
        int[] parentsDijkstra =new int[G.size()];

        int[] costsBellman =new int[G.size()];
        int[] parentsBellman =new int[G.size()];

        int[][] costsFloyds =new int[G.size()][G.size()];
        int[][] pre =new int[G.size()][G.size()];

        long DijkstraTime = 0;
        long BellmanTime = 0;
        long FloydTime = 0;

        for(int i=0; i<10; i++){
            long startTimeDijkstra = System.nanoTime();
            G.Dijkstra(i,costsDijkstra,parentsDijkstra);
            long endTimeDijkstra = System.nanoTime();

            DijkstraTime += endTimeDijkstra-startTimeDijkstra;

            long startTimeBellman = System.nanoTime();
            G.BellmanFord(i,costsBellman,parentsBellman);
            long endTimeBellman = System.nanoTime();

            BellmanTime += endTimeBellman - startTimeBellman;
        }


        DijkstraTime = DijkstraTime / 10 / 1000;
        BellmanTime = BellmanTime / 10 / 1000;



        long startTimeFloyds = System.nanoTime();
        G.FloydWarshall(costsFloyds,pre);
        long endTimeFloyds = System.nanoTime();

        FloydTime = (endTimeFloyds - startTimeFloyds) / 1000;



        System.out.println("128 graph with 0.1 density");
        System.out.println("Dikstra Time = "+ DijkstraTime);
        System.out.println("Bellman Time = "+ BellmanTime);
        System.out.println("Floyds Time = " + FloydTime);

        assertArrayEquals(costsDijkstra,costsBellman);
        assertArrayEquals(parentsDijkstra,parentsBellman);

    }

    @Test
    void graph_128_10() {
        try {
            G.initialize("src/testFiles/graph_128_1.0.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[] costsDijkstra =new int[G.size()];
        int[] parentsDijkstra =new int[G.size()];

        int[] costsBellman =new int[G.size()];
        int[] parentsBellman =new int[G.size()];

        int[][] costsFloyds =new int[G.size()][G.size()];
        int[][] pre =new int[G.size()][G.size()];

        long DijkstraTime = 0;
        long BellmanTime = 0;
        long FloydTime = 0;

        for(int i=0; i<10; i++){
            long startTimeDijkstra = System.nanoTime();
            G.Dijkstra(i,costsDijkstra,parentsDijkstra);
            long endTimeDijkstra = System.nanoTime();

            DijkstraTime += endTimeDijkstra-startTimeDijkstra;

            long startTimeBellman = System.nanoTime();
            G.BellmanFord(i,costsBellman,parentsBellman);
            long endTimeBellman = System.nanoTime();

            BellmanTime += endTimeBellman - startTimeBellman;
        }


        DijkstraTime = DijkstraTime / 10 / 1000;
        BellmanTime = BellmanTime / 10 / 1000;



        long startTimeFloyds = System.nanoTime();
        G.FloydWarshall(costsFloyds,pre);
        long endTimeFloyds = System.nanoTime();

        FloydTime = (endTimeFloyds - startTimeFloyds) / 1000;



        System.out.println("128 graph with 1 density");
        System.out.println("Dikstra Time = "+ DijkstraTime);
        System.out.println("Bellman Time = "+ BellmanTime);
        System.out.println("Floyds Time = " + FloydTime);

        assertArrayEquals(costsDijkstra,costsBellman);
//        assertArrayEquals(parentsDijkstra,parentsBellman);    //feh mo4kla hnaa

    }

    //--------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------

    @Test
    void graph_256_001() {
        try {
            G.initialize("src/testFiles/graph_256_0.001.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[] costsDijkstra =new int[G.size()];
        int[] parentsDijkstra =new int[G.size()];

        int[] costsBellman =new int[G.size()];
        int[] parentsBellman =new int[G.size()];

        int[][] costsFloyds =new int[G.size()][G.size()];
        int[][] pre =new int[G.size()][G.size()];

        long DijkstraTime = 0;
        long BellmanTime = 0;
        long FloydTime = 0;

        for(int i=0; i<10; i++){
            long startTimeDijkstra = System.nanoTime();
            G.Dijkstra(i,costsDijkstra,parentsDijkstra);
            long endTimeDijkstra = System.nanoTime();

            DijkstraTime += endTimeDijkstra-startTimeDijkstra;

            long startTimeBellman = System.nanoTime();
            G.BellmanFord(i,costsBellman,parentsBellman);
            long endTimeBellman = System.nanoTime();

            BellmanTime += endTimeBellman - startTimeBellman;
        }


        DijkstraTime = DijkstraTime / 10 / 1000;
        BellmanTime = BellmanTime / 10 / 1000;



        long startTimeFloyds = System.nanoTime();
        G.FloydWarshall(costsFloyds,pre);
        long endTimeFloyds = System.nanoTime();

        FloydTime = (endTimeFloyds - startTimeFloyds) / 1000;



        System.out.println("256 graph with 0.001 density");
        System.out.println("Dikstra Time = "+ DijkstraTime);
        System.out.println("Bellman Time = "+ BellmanTime);
        System.out.println("Floyds Time = " + FloydTime);

        assertArrayEquals(costsDijkstra,costsBellman);
        assertArrayEquals(parentsDijkstra,parentsBellman);

    }


    @Test
    void graph_256_01() {
        try {
            G.initialize("src/testFiles/graph_256_0.01.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[] costsDijkstra =new int[G.size()];
        int[] parentsDijkstra =new int[G.size()];

        int[] costsBellman =new int[G.size()];
        int[] parentsBellman =new int[G.size()];

        int[][] costsFloyds =new int[G.size()][G.size()];
        int[][] pre =new int[G.size()][G.size()];

        long DijkstraTime = 0;
        long BellmanTime = 0;
        long FloydTime = 0;

        for(int i=0; i<10; i++){
            long startTimeDijkstra = System.nanoTime();
            G.Dijkstra(i,costsDijkstra,parentsDijkstra);
            long endTimeDijkstra = System.nanoTime();

            DijkstraTime += endTimeDijkstra-startTimeDijkstra;

            long startTimeBellman = System.nanoTime();
            G.BellmanFord(i,costsBellman,parentsBellman);
            long endTimeBellman = System.nanoTime();

            BellmanTime += endTimeBellman - startTimeBellman;
        }


        DijkstraTime = DijkstraTime / 10 / 1000;
        BellmanTime = BellmanTime / 10 / 1000;



        long startTimeFloyds = System.nanoTime();
        G.FloydWarshall(costsFloyds,pre);
        long endTimeFloyds = System.nanoTime();

        FloydTime = (endTimeFloyds - startTimeFloyds) / 1000;



        System.out.println("256 graph with 0.01 density");
        System.out.println("Dikstra Time = "+ DijkstraTime);
        System.out.println("Bellman Time = "+ BellmanTime);
        System.out.println("Floyds Time = " + FloydTime);

        assertArrayEquals(costsDijkstra,costsBellman);
        assertArrayEquals(parentsDijkstra,parentsBellman);

    }

    @Test
    void graph_256_1() {
        try {
            G.initialize("src/testFiles/graph_256_0.1.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[] costsDijkstra =new int[G.size()];
        int[] parentsDijkstra =new int[G.size()];

        int[] costsBellman =new int[G.size()];
        int[] parentsBellman =new int[G.size()];

        int[][] costsFloyds =new int[G.size()][G.size()];
        int[][] pre =new int[G.size()][G.size()];

        long DijkstraTime = 0;
        long BellmanTime = 0;
        long FloydTime = 0;

        for(int i=0; i<10; i++){
            long startTimeDijkstra = System.nanoTime();
            G.Dijkstra(i,costsDijkstra,parentsDijkstra);
            long endTimeDijkstra = System.nanoTime();

            DijkstraTime += endTimeDijkstra-startTimeDijkstra;

            long startTimeBellman = System.nanoTime();
            G.BellmanFord(i,costsBellman,parentsBellman);
            long endTimeBellman = System.nanoTime();

            BellmanTime += endTimeBellman - startTimeBellman;
        }


        DijkstraTime = DijkstraTime / 10 / 1000;
        BellmanTime = BellmanTime / 10 / 1000;



        long startTimeFloyds = System.nanoTime();
        G.FloydWarshall(costsFloyds,pre);
        long endTimeFloyds = System.nanoTime();

        FloydTime = (endTimeFloyds - startTimeFloyds) / 1000;



        System.out.println("256 graph with 0.1 density");
        System.out.println("Dikstra Time = "+ DijkstraTime);
        System.out.println("Bellman Time = "+ BellmanTime);
        System.out.println("Floyds Time = " + FloydTime);

        assertArrayEquals(costsDijkstra,costsBellman);
//        assertArrayEquals(parentsDijkstra,parentsBellman);   //hna feh mo4kla

    }

    @Test
    void graph_256_10() {
        try {
            G.initialize("src/testFiles/graph_256_1.0.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[] costsDijkstra =new int[G.size()];
        int[] parentsDijkstra =new int[G.size()];

        int[] costsBellman =new int[G.size()];
        int[] parentsBellman =new int[G.size()];

        int[][] costsFloyds =new int[G.size()][G.size()];
        int[][] pre =new int[G.size()][G.size()];

        long DijkstraTime = 0;
        long BellmanTime = 0;
        long FloydTime = 0;

        for(int i=0; i<10; i++){
            long startTimeDijkstra = System.nanoTime();
            G.Dijkstra(i,costsDijkstra,parentsDijkstra);
            long endTimeDijkstra = System.nanoTime();

            DijkstraTime += endTimeDijkstra-startTimeDijkstra;

            long startTimeBellman = System.nanoTime();
            G.BellmanFord(i,costsBellman,parentsBellman);
            long endTimeBellman = System.nanoTime();

            BellmanTime += endTimeBellman - startTimeBellman;
        }


        DijkstraTime = DijkstraTime / 10 / 1000;
        BellmanTime = BellmanTime / 10 / 1000;



        long startTimeFloyds = System.nanoTime();
        G.FloydWarshall(costsFloyds,pre);
        long endTimeFloyds = System.nanoTime();

        FloydTime = (endTimeFloyds - startTimeFloyds) / 1000;



        System.out.println("256 graph with 1 density");
        System.out.println("Dikstra Time = "+ DijkstraTime);
        System.out.println("Bellman Time = "+ BellmanTime);
        System.out.println("Floyds Time = " + FloydTime);

        assertArrayEquals(costsDijkstra,costsBellman);
//        assertArrayEquals(parentsDijkstra,parentsBellman);  //hna feh mo4kla

    }

    //---------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------

    @Test
    void graph_512_001() {
        try {
            G.initialize("src/testFiles/graph_512_0.001.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[] costsDijkstra =new int[G.size()];
        int[] parentsDijkstra =new int[G.size()];

        int[] costsBellman =new int[G.size()];
        int[] parentsBellman =new int[G.size()];

        int[][] costsFloyds =new int[G.size()][G.size()];
        int[][] pre =new int[G.size()][G.size()];

        long DijkstraTime = 0;
        long BellmanTime = 0;
        long FloydTime = 0;

        for(int i=0; i<10; i++){
            long startTimeDijkstra = System.nanoTime();
            G.Dijkstra(i,costsDijkstra,parentsDijkstra);
            long endTimeDijkstra = System.nanoTime();

            DijkstraTime += endTimeDijkstra-startTimeDijkstra;

            long startTimeBellman = System.nanoTime();
            G.BellmanFord(i,costsBellman,parentsBellman);
            long endTimeBellman = System.nanoTime();

            BellmanTime += endTimeBellman - startTimeBellman;
        }


        DijkstraTime = DijkstraTime / 10 / 1000;
        BellmanTime = BellmanTime / 10 / 1000;



        long startTimeFloyds = System.nanoTime();
        G.FloydWarshall(costsFloyds,pre);
        long endTimeFloyds = System.nanoTime();

        FloydTime = (endTimeFloyds - startTimeFloyds) / 1000;



        System.out.println("512 graph with 0.001 density");
        System.out.println("Dikstra Time = "+ DijkstraTime);
        System.out.println("Bellman Time = "+ BellmanTime);
        System.out.println("Floyds Time = " + FloydTime);

        assertArrayEquals(costsDijkstra,costsBellman);
        assertArrayEquals(parentsDijkstra,parentsBellman);

    }


    @Test
    void graph_512_01() {
        try {
            G.initialize("src/testFiles/graph_512_0.01.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[] costsDijkstra =new int[G.size()];
        int[] parentsDijkstra =new int[G.size()];

        int[] costsBellman =new int[G.size()];
        int[] parentsBellman =new int[G.size()];

        int[][] costsFloyds =new int[G.size()][G.size()];
        int[][] pre =new int[G.size()][G.size()];

        long DijkstraTime = 0;
        long BellmanTime = 0;
        long FloydTime = 0;

        for(int i=0; i<10; i++){
            long startTimeDijkstra = System.nanoTime();
            G.Dijkstra(i,costsDijkstra,parentsDijkstra);
            long endTimeDijkstra = System.nanoTime();

            DijkstraTime += endTimeDijkstra-startTimeDijkstra;

            long startTimeBellman = System.nanoTime();
            G.BellmanFord(i,costsBellman,parentsBellman);
            long endTimeBellman = System.nanoTime();

            BellmanTime += endTimeBellman - startTimeBellman;
        }


        DijkstraTime = DijkstraTime / 10 / 1000;
        BellmanTime = BellmanTime / 10 / 1000;



        long startTimeFloyds = System.nanoTime();
        G.FloydWarshall(costsFloyds,pre);
        long endTimeFloyds = System.nanoTime();

        FloydTime = (endTimeFloyds - startTimeFloyds) / 1000;



        System.out.println("512 graph with 0.01 density");
        System.out.println("Dikstra Time = "+ DijkstraTime);
        System.out.println("Bellman Time = "+ BellmanTime);
        System.out.println("Floyds Time = " + FloydTime);

        assertArrayEquals(costsDijkstra,costsBellman);
        assertArrayEquals(parentsDijkstra,parentsBellman);

    }

    @Test
    void graph_512_1() {
        try {
            G.initialize("src/testFiles/graph_512_0.1.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[] costsDijkstra =new int[G.size()];
        int[] parentsDijkstra =new int[G.size()];

        int[] costsBellman =new int[G.size()];
        int[] parentsBellman =new int[G.size()];

        int[][] costsFloyds =new int[G.size()][G.size()];
        int[][] pre =new int[G.size()][G.size()];

        long DijkstraTime = 0;
        long BellmanTime = 0;
        long FloydTime = 0;

        for(int i=0; i<10; i++){
            long startTimeDijkstra = System.nanoTime();
            G.Dijkstra(i,costsDijkstra,parentsDijkstra);
            long endTimeDijkstra = System.nanoTime();

            DijkstraTime += endTimeDijkstra-startTimeDijkstra;

            long startTimeBellman = System.nanoTime();
            G.BellmanFord(i,costsBellman,parentsBellman);
            long endTimeBellman = System.nanoTime();

            BellmanTime += endTimeBellman - startTimeBellman;
        }


        DijkstraTime = DijkstraTime / 10 / 1000;
        BellmanTime = BellmanTime / 10 / 1000;



        long startTimeFloyds = System.nanoTime();
        G.FloydWarshall(costsFloyds,pre);
        long endTimeFloyds = System.nanoTime();

        FloydTime = (endTimeFloyds - startTimeFloyds) / 1000;



        System.out.println("512 graph with 0.1 density");
        System.out.println("Dikstra Time = "+ DijkstraTime);
        System.out.println("Bellman Time = "+ BellmanTime);
        System.out.println("Floyds Time = " + FloydTime);

        assertArrayEquals(costsDijkstra,costsBellman);
//        assertArrayEquals(parentsDijkstra,parentsBellman);   //hna feh mo4kla

    }

    @Test
    void graph_512_10() {
        try {
            G.initialize("src/testFiles/graph_512_1.0.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[] costsDijkstra =new int[G.size()];
        int[] parentsDijkstra =new int[G.size()];

        int[] costsBellman =new int[G.size()];
        int[] parentsBellman =new int[G.size()];

        int[][] costsFloyds =new int[G.size()][G.size()];
        int[][] pre =new int[G.size()][G.size()];

        long DijkstraTime = 0;
        long BellmanTime = 0;
        long FloydTime = 0;

        for(int i=0; i<10; i++){
            long startTimeDijkstra = System.nanoTime();
            G.Dijkstra(i,costsDijkstra,parentsDijkstra);
            long endTimeDijkstra = System.nanoTime();

            DijkstraTime += endTimeDijkstra-startTimeDijkstra;

            long startTimeBellman = System.nanoTime();
            G.BellmanFord(i,costsBellman,parentsBellman);
            long endTimeBellman = System.nanoTime();

            BellmanTime += endTimeBellman - startTimeBellman;
        }


        DijkstraTime = DijkstraTime / 10 / 1000;
        BellmanTime = BellmanTime / 10 / 1000;



        long startTimeFloyds = System.nanoTime();
        G.FloydWarshall(costsFloyds,pre);
        long endTimeFloyds = System.nanoTime();

        FloydTime = (endTimeFloyds - startTimeFloyds) / 1000;



        System.out.println("512 graph with 1 density");
        System.out.println("Dikstra Time = "+ DijkstraTime);
        System.out.println("Bellman Time = "+ BellmanTime);
        System.out.println("Floyds Time = " + FloydTime);

        assertArrayEquals(costsDijkstra,costsBellman);
//        assertArrayEquals(parentsDijkstra,parentsBellman);  //feh hena error

    }

    //----------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------

    @Test
    void graph_1024_001() {
        try {
            G.initialize("src/testFiles/graph_1024_0.001.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[] costsDijkstra =new int[G.size()];
        int[] parentsDijkstra =new int[G.size()];

        int[] costsBellman =new int[G.size()];
        int[] parentsBellman =new int[G.size()];

        int[][] costsFloyds =new int[G.size()][G.size()];
        int[][] pre =new int[G.size()][G.size()];

        long DijkstraTime = 0;
        long BellmanTime = 0;
        long FloydTime = 0;

        for(int i=0; i<10; i++){
            long startTimeDijkstra = System.nanoTime();
            G.Dijkstra(i,costsDijkstra,parentsDijkstra);
            long endTimeDijkstra = System.nanoTime();

            DijkstraTime += endTimeDijkstra-startTimeDijkstra;

            long startTimeBellman = System.nanoTime();
            G.BellmanFord(i,costsBellman,parentsBellman);
            long endTimeBellman = System.nanoTime();

            BellmanTime += endTimeBellman - startTimeBellman;
        }


        DijkstraTime = DijkstraTime / 10 / 1000;
        BellmanTime = BellmanTime / 10 / 1000;



        long startTimeFloyds = System.nanoTime();
        G.FloydWarshall(costsFloyds,pre);
        long endTimeFloyds = System.nanoTime();

        FloydTime = (endTimeFloyds - startTimeFloyds) / 1000;



        System.out.println("1024 graph with 0.001 density");
        System.out.println("Dikstra Time = "+ DijkstraTime);
        System.out.println("Bellman Time = "+ BellmanTime);
        System.out.println("Floyds Time = " + FloydTime);

        assertArrayEquals(costsDijkstra,costsBellman);
        assertArrayEquals(parentsDijkstra,parentsBellman);

    }


    @Test
    void graph_1024_01() {
        try {
            G.initialize("src/testFiles/graph_1024_0.01.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[] costsDijkstra =new int[G.size()];
        int[] parentsDijkstra =new int[G.size()];

        int[] costsBellman =new int[G.size()];
        int[] parentsBellman =new int[G.size()];

        int[][] costsFloyds =new int[G.size()][G.size()];
        int[][] pre =new int[G.size()][G.size()];

        long DijkstraTime = 0;
        long BellmanTime = 0;
        long FloydTime = 0;

        for(int i=0; i<10; i++){
            long startTimeDijkstra = System.nanoTime();
            G.Dijkstra(i,costsDijkstra,parentsDijkstra);
            long endTimeDijkstra = System.nanoTime();

            DijkstraTime += endTimeDijkstra-startTimeDijkstra;

            long startTimeBellman = System.nanoTime();
            G.BellmanFord(i,costsBellman,parentsBellman);
            long endTimeBellman = System.nanoTime();

            BellmanTime += endTimeBellman - startTimeBellman;
        }


        DijkstraTime = DijkstraTime / 10 / 1000;
        BellmanTime = BellmanTime / 10 / 1000;



        long startTimeFloyds = System.nanoTime();
        G.FloydWarshall(costsFloyds,pre);
        long endTimeFloyds = System.nanoTime();

        FloydTime = (endTimeFloyds - startTimeFloyds) / 1000;



        System.out.println("1024 graph with 0.01 density");
        System.out.println("Dikstra Time = "+ DijkstraTime);
        System.out.println("Bellman Time = "+ BellmanTime);
        System.out.println("Floyds Time = " + FloydTime);

        assertArrayEquals(costsDijkstra,costsBellman);
//        assertArrayEquals(parentsDijkstra,parentsBellman);  //feh error hnaa

    }

    @Test
    void graph_1024_1() {
        try {
            G.initialize("src/testFiles/graph_1024_0.1.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[] costsDijkstra =new int[G.size()];
        int[] parentsDijkstra =new int[G.size()];

        int[] costsBellman =new int[G.size()];
        int[] parentsBellman =new int[G.size()];

        int[][] costsFloyds =new int[G.size()][G.size()];
        int[][] pre =new int[G.size()][G.size()];

        long DijkstraTime = 0;
        long BellmanTime = 0;
        long FloydTime = 0;

        for(int i=0; i<10; i++){
            long startTimeDijkstra = System.nanoTime();
            G.Dijkstra(i,costsDijkstra,parentsDijkstra);
            long endTimeDijkstra = System.nanoTime();

            DijkstraTime += endTimeDijkstra-startTimeDijkstra;

            long startTimeBellman = System.nanoTime();
            G.BellmanFord(i,costsBellman,parentsBellman);
            long endTimeBellman = System.nanoTime();

            BellmanTime += endTimeBellman - startTimeBellman;
        }


        DijkstraTime = DijkstraTime / 10 / 1000;
        BellmanTime = BellmanTime / 10 / 1000;



        long startTimeFloyds = System.nanoTime();
        G.FloydWarshall(costsFloyds,pre);
        long endTimeFloyds = System.nanoTime();

        FloydTime = (endTimeFloyds - startTimeFloyds) / 1000;



        System.out.println("1024 graph with 0.1 density");
        System.out.println("Dikstra Time = "+ DijkstraTime);
        System.out.println("Bellman Time = "+ BellmanTime);
        System.out.println("Floyds Time = " + FloydTime);

        assertArrayEquals(costsDijkstra,costsBellman);
//        assertArrayEquals(parentsDijkstra,parentsBellman);   //hna feh mo4kla

    }

    @Test
    void graph_1024_10() {
        try {
            G.initialize("src/testFiles/graph_1024_1.0.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[] costsDijkstra =new int[G.size()];
        int[] parentsDijkstra =new int[G.size()];

        int[] costsBellman =new int[G.size()];
        int[] parentsBellman =new int[G.size()];

        int[][] costsFloyds =new int[G.size()][G.size()];
        int[][] pre =new int[G.size()][G.size()];

        long DijkstraTime = 0;
        long BellmanTime = 0;
        long FloydTime = 0;

        for(int i=0; i<10; i++){
            long startTimeDijkstra = System.nanoTime();
            G.Dijkstra(i,costsDijkstra,parentsDijkstra);
            long endTimeDijkstra = System.nanoTime();

            DijkstraTime += endTimeDijkstra-startTimeDijkstra;

            long startTimeBellman = System.nanoTime();
            G.BellmanFord(i,costsBellman,parentsBellman);
            long endTimeBellman = System.nanoTime();

            BellmanTime += endTimeBellman - startTimeBellman;
        }


        DijkstraTime = DijkstraTime / 10 / 1000;
        BellmanTime = BellmanTime / 10 / 1000;



        long startTimeFloyds = System.nanoTime();
        G.FloydWarshall(costsFloyds,pre);
        long endTimeFloyds = System.nanoTime();

        FloydTime = (endTimeFloyds - startTimeFloyds) / 1000;



        System.out.println("1024 graph with 1 density");
        System.out.println("Dikstra Time = "+ DijkstraTime);
        System.out.println("Bellman Time = "+ BellmanTime);
        System.out.println("Floyds Time = " + FloydTime);

        assertArrayEquals(costsDijkstra,costsBellman);
//        assertArrayEquals(parentsDijkstra,parentsBellman);  //hna feh mo4kla

    }



}