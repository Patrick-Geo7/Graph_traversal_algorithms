import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {
    Graph G=new Graph();

    @Test
    void dijkstraTest1() {
        try {
            G.initialize("src/testFiles/input1.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[] costs =new int[G.size()];
        int[] parents =new int[G.size()];
        G.Dijkstra(0,costs,parents);
        int[] expectedCosts=new int[]{0,3,4,6,8};
        int[] expectedParents1=new int[]{0,0,1,2,0};
        assertArrayEquals(expectedCosts,costs);

        assertArrayEquals(expectedParents1,parents);

    }
    @Test
    void dijkstraTest2() {
        try {
            G.initialize("src/testFiles/input2.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[] costs =new int[G.size()];
        int[] parents =new int[G.size()];
        G.Dijkstra(0,costs,parents);
        int[] expectedCosts=new int[]{0,4,3,6,8,14};
        int[] expectedParents=new int[]{0,0,0,1,3,4};
        assertArrayEquals(expectedCosts,costs);
        assertArrayEquals(expectedParents,parents);

    }
    @Test
    void dijkstraTest3() {
        try {
            G.initialize("src/testFiles/input6.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[] costs =new int[G.size()];
        int[] parents =new int[G.size()];
        G.Dijkstra(0,costs,parents);
        int[] expectedCosts=new int[]{0,105,26,99,38,73,152,60};
        int[] expectedParents=new int[]{0,5,0,7,0,4,3,2};
        assertArrayEquals(expectedCosts,costs);
        assertArrayEquals(expectedParents,parents);
    }
    @Test
    void dijkstraTest4() {
        try {
            G.initialize("src/testFiles/input4.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[] costs =new int[G.size()];
        int[] parents =new int[G.size()];
        G.Dijkstra(0,costs,parents);
        int[] expectedCosts=new int[]{0,10,15,20,20,5,15,100000000,100000000,100000000};
        int[] expectedParents1=new int[]{0,0,1,0,0,0,0,0,0,0};

        assertArrayEquals(expectedCosts,costs);

        assertArrayEquals(expectedParents1,parents);



    }

    @Test
    void dijkstraTest5() {
        try {
            G.initialize("src/testFiles/input5.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[] costs =new int[G.size()];
        int[] parents =new int[G.size()];
        G.Dijkstra(0,costs,parents);
        int[] expectedCosts=new int[]{0,5,4,8,7,100000000};
        int[] expectedParents=new int[]{0,2,0,1,2,0};
        assertArrayEquals(expectedCosts,costs);
        assertArrayEquals(expectedParents,parents);

    }
}