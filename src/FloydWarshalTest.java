import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloydWarshalTest {
    Graph G=new Graph();
    int INF = 100000000;
    @Test
    void negativeEdgesTest() {
        try {
            G.initialize("src/testFiles/input3.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[][] costs =new int[G.size()][G.size()];
        int[][] predecessors =new int[G.size()][G.size()];
        boolean valid=G.FloydWarshall(costs,predecessors);
        int[][] expectedCosts=new int[][]{{0,INF,INF,INF,INF,INF,2,INF},
                {INF,0,-4,INF,1,INF,8,INF},
                {INF,INF,0,INF,INF,INF,INF,INF},
                {3,INF,INF,0,5,INF,5,INF},
                {INF,INF,INF,INF,0,INF,INF,INF},
                {INF,2,-2,INF,3,0,10,INF},
                {INF,INF,INF,INF,INF,INF,0,INF},
                {6,-2,-6,4,-1,-4,6,0}
        };
        assertArrayEquals(expectedCosts,costs);
        assertTrue(valid);
    }
    @Test
    void negativeCycleTest() {
        try {
            G.initialize("src/testFiles/input7.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[][] costs =new int[G.size()][G.size()];
        int[][] predecessors =new int[G.size()][G.size()];
        boolean valid=G.FloydWarshall(costs,predecessors);
        System.out.println(valid);
        assertFalse(valid);

    }
    @Test
    void negativeEdgesTest2() {
        try {
            G.initialize("src/testFiles/input3.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[][] costs =new int[G.size()][G.size()];
        int[][] predecessors =new int[G.size()][G.size()];
        boolean valid=G.FloydWarshall(costs,predecessors);
        int[][] expectedCosts=new int[][]{{0,100000000,100000000,100000000,100000000,100000000,2,100000000},
                {100000000,0,-4,100000000,1,100000000,8,100000000},
                {100000000,100000000,0,100000000,100000000,100000000,100000000,100000000},
                {3,100000000,100000000,0,5,100000000,5,100000000},
                {100000000,100000000,100000000,100000000,0,100000000,100000000,100000000},
                {100000000,2,-2,100000000,3,0,10,100000000},
                {100000000,100000000,100000000,100000000,100000000,100000000,0,100000000},
                {6,-2,-6,4,-1,-4,6,0,}
        };
        assertArrayEquals(expectedCosts,costs);
        assertTrue(valid);

    }
    @Test
    void BellmanFordTest1() {
        try {
            G.initialize("src/testFiles/input1.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[][] costs =new int[G.size()][G.size()];
        int[][] predecessors =new int[G.size()][G.size()];
        boolean valid=G.FloydWarshall(costs,predecessors);
        int[][] expectedCosts=new int[][]{{0, 3, 4, 7, 8},
                {INF, 0, 1, 4, INF},
                {INF, INF, 0, INF, INF},
                {INF, INF, 2, 0, INF},
                {INF, INF, 5, 3, 0}
        };
        assertArrayEquals(expectedCosts,costs);
        assertTrue(valid);


    }
    @Test
    void BellmanFordTest2() {
        try {
            G.initialize("src/testFiles/input2.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[][] costs =new int[G.size()][G.size()];
        int[][] predecessors =new int[G.size()][G.size()];
        boolean valid=G.FloydWarshall(costs,predecessors);
        int[][] expectedCosts=new int[][]{{0,4,3,6,8,14},
                {8,0,5,2,4,10},
                {13,13,0,7,9,15},
                {6,6,9,0,2,8},
                {4,4,7,6,0,6},
                {INF,INF,INF,INF,INF,0}
        };
        assertArrayEquals(expectedCosts,costs);
        assertTrue(valid);


    }
    @Test
    void BellmanFordTest3() {
        try {
            G.initialize("src/testFiles/input6.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[][] costs =new int[G.size()][G.size()];
        int[][] predecessors =new int[G.size()][G.size()];
        boolean valid=G.FloydWarshall(costs,predecessors);
        int[][] expectedCosts=new int[][]{{0,105,26,99,38,73,152,60},
                {140,0,122,29,175,184,82,156},
                {184,94,0,73,97,62,126,34},
                {111,187,93,0,146,155,53,127},
                {187,67,169,76,0,35,129,37},
                {172,32,154,61,35,0,114,28},
                {58,134,40,113,93,102,0,74},
                {150,60,132,39,63,28,92,0}
        };
        assertArrayEquals(expectedCosts,costs);
        assertTrue(valid);

    }

    @Test
    void BellmanFordTest4() {
        try {
            G.initialize("src/testFiles/input4.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[][] costs =new int[G.size()][G.size()];
        int[][] predecessors =new int[G.size()][G.size()];
        boolean valid=G.FloydWarshall(costs,predecessors);
        int[][] expectedCosts=new int[][]{{0,10,15,20,20,5,15,100000000,100000000,100000000},
                {100000000,0,5,10,20,25,100000000,100000000,100000000,100000000},
                {100000000,15,0,5,15,20,100000000,100000000,100000000,100000000},
                {100000000,100000000,100000000,0,10,15,100000000,100000000,100000000,100000000},
                {100000000,100000000,100000000,100000000,0,5,100000000,100000000,100000000,100000000},
                {100000000,100000000,100000000,100000000,100000000,0,100000000,100000000,100000000,100000000},
                {100000000,100000000,100000000,100000000,100000000,10,0,100000000,100000000,100000000},
                {5,15,20,25,25,10,5,0,100000000,100000000},
                {25,15,20,25,35,30,25,20,0,10},
                {100000000,5,10,15,25,30,100000000,100000000,100000000,0}

        };
        assertArrayEquals(expectedCosts,costs);
        assertTrue(valid);


    }
    @Test
    void FloydWarshalTest5() {
        try {
            G.initialize("src/testFiles/input5.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[][] costs =new int[G.size()][G.size()];
        int[][] predecessors =new int[G.size()][G.size()];
        boolean valid=G.FloydWarshall(costs,predecessors);
        int[][] expectedCosts=new int[][]{{0, 5, 4, 8, 7},
                {12, 0, 2, 3, 5},
                {10, 1, 0, 4, 3},
                {11, 16, 15, 0, 4},
                {7, 12, 11, 5, 0},
        };
        assertArrayEquals(expectedCosts,costs);
        assertTrue(valid);
    }
    /*
    0	5	4	8	7
j	12	0	2	3	5
k	10	1	0	4	3
l	11	16	15	0	4
m	7	12	11	5	0

     */
}