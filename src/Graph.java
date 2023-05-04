import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.util.Collections;
import java.util.PriorityQueue;

import static java.lang.Integer.parseInt;

public class Graph implements GraphIF {
    int V;
    int E;
    int[][] graphArray; //adjacency matrix
    int[][] edgeList;
    boolean hasNegative;
    int INF = 100000000;

    ArrayList<ArrayList<Integer>> edges;


    @Override
    public void initialize(String path) throws Exception {
        // TODO Auto-generated method stub
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        st = br.readLine();
        String[] input = st.split(" ");
        V = parseInt(input[0]);
        E = parseInt(input[1]);
        graphArray = new int[V][V];
        edgeList = new int[E][3];
        edges = new ArrayList<>(this.V);
        edges.addAll(Collections.nCopies(this.V,null));
        //       Double positiveInfinity = Double.POSITIVE_INFINITY;
        //initializing the adjacency matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j)
                    graphArray[i][j] = 0;
                else
                    graphArray[i][j] = INF;
            }
        }
        //reading the edges
        for (int i = 0; i < E; i++) {
            st = br.readLine();
            String[] line = st.split(" ");
            for (int j = 0; j < 3; j++) {
                edgeList[i][j] = parseInt(line[j]);
            }
            graphArray[parseInt(line[0])][parseInt(line[1])] = parseInt(line[2]);
            if(parseInt(line[2])<0){
                this.hasNegative=true;
            }

            ArrayList<Integer> temp = edges.get(parseInt(line[0]));

            if(temp == null){
                ArrayList<Integer> a = new ArrayList<>();
                a.add(parseInt(line[1]));
                edges.set(parseInt(line[0]), a);
            }
            else{
                temp.add(parseInt(line[1]));
                edges.set(parseInt(line[0]),temp);
            }
//            System.out.println(edges.size());
        }
        System.out.println("--------------------------------------------");
        for(int i=0; i<this.V; i++){
            System.out.println();
            System.out.print(i+")  ");
            ArrayList<Integer> t = edges.get(i);
            if(t == null){continue;}
            for(int j: t){
                System.out.print(j+"-");
            }

        }


        br.close();
//        for (int i = 0; i < V; i++) {
//            for (int j = 0; j < V; j++) {
//                System.out.print(graphArray[i][j]+" ");
//            }
//            System.out.print("\n");
//        }
    }
//             if(st.charAt(4)=='-')
//             {
//                 graphArray[(st.charAt(0) - '0') - 1][(st.charAt(2) - '0') - 1] = -1*(st.charAt(5) - '0');
//             }
//            else {
//                 graphArray[(st.charAt(0) - '0') - 1][(st.charAt(2) - '0') - 1] = st.charAt(4) - '0';
//             }

    //         }
    public void printEdgeList() {
        for (int[] e : edgeList) {
            System.out.println(e[0] + " " + e[1] + " " + e[2]);
        }
    }

    public void printAdjacencyMatrix() {
        for (int[] r : graphArray) {
            String s = "";
            for (int i : r) {
                s += i + " ";
            }
            System.out.println(s);
        }
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return V;
    }

    @Override
    public boolean Dijkstra(int s, int[] costs, int[] parents) {
        // O(Vlog(V)+m)

        // make all the nodes paths infinity ... and all of them unsure
        // make the start node = 0
        // recursion loop for all vertices
        // select the minimum node [v]
        // go to all their neighbours [u] ... if [v] + weight < [u] ... then [u] = [v] + weight
        // make [v] sure
        // go to recursion
        Arrays.fill(costs, INF);  //O(V)
        costs[s] = 0;
        parents[s] = s;
        PriorityQueue<Node> heap = new PriorityQueue<>(this.V);
        heap.offer(new Node(s, 0));  //O(log V)
        boolean[] visited = new boolean[this.V];

        // while loop O(V)
        while (!heap.isEmpty()) {
            Node curr = heap.poll();  // O(log V)

            if (visited[curr.vertex]) {
                continue;
            }

            visited[curr.vertex] = true;

            ArrayList<Integer> vertex = this.edges.get(curr.vertex);

            if(vertex == null){
                continue;
            }

            //O(nv)  nv = neighbours of V
            for (int neighbor: vertex) {

                int neighborGain = this.graphArray[curr.vertex][neighbor];
                if (neighbor != curr.vertex) {

                    // if there is a negative edge return false
                    if (neighborGain < 0) {
                        return false;
                    }
                    // --------------------------------

                    long weight = this.graphArray[curr.vertex][neighbor];
                    if (weight != INF && !visited[neighbor] && costs[curr.vertex] + weight < costs[neighbor]) {
                        costs[neighbor] = (int) (costs[curr.vertex] + weight);
                        parents[neighbor] = curr.vertex;
                        heap.offer(new Node(neighbor, costs[neighbor])); // O(log V)
                    }
                }
            }
        }

        return true;

    }

    public void dist1d(int[] arr, int s) {
        int i = 0;
        System.out.println("distances array");
        for (int node : arr) {
            System.out.println("distance from " + s + "to " + i + " = " + node);
            i++;
        }
    }

    public void printParents(int[] arr) {
        int i = 0;
        System.out.println("parents array");
        for (int node : arr) {
            System.out.println("parent of " + i + " is " + node);
            i++;
        }
    }

    @Override
    public boolean BellmanFord(int s, int[] costs, int[] parents) {
        //this function returns False if a negative cycle is found and True otherwise.
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //BELLMAN ALGORITHM STEPS: O(V*E)
        //1)init dist[vertices]=INT_MAX and dist[src]=0
        //2)relax all edges v-1 times :for every edge (u -> v) of weight (wt) if dist[u]+wt<dist[v] update dist[v]
        //>>>>>> step 2 is repeated v-1 times because at iteration i we guarantee we have got the shortest path for
        //>>>>>> the nodes i-levels away from the source (so we will need (V-1) iteration for the worst case scenario
        //>>>>>> when the edge list is totally reversed)
        //3)check for a negative wt cycle : if the result changes in the Vth cycle (unfeasible)
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        Arrays.fill(costs, INF);
        costs[s] = 0;
        parents[s] = s;
        for (int i = 0; i < V - 1; i++) {

            boolean finished = true;
            for (int[] e : edgeList) {
                int u = e[0];
                int v = e[1];
                int wt = e[2];
                //relaxation step
                if (costs[u] != INF && costs[u] + wt < costs[v]) {
                    costs[v] = costs[u] + wt;
                    parents[v] = u;
                    finished = false;
                }
            }
//            if (finished)
//                return true;
        }
        // one more iteration to check for negative wt cycles
        for (int[] e : edgeList) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            //relaxation step
            if (costs[u] != INF && (costs[u] + wt < costs[v])) {
                System.out.println("\ninfeasible:negative wt cycle detected");
                return false;
            }
        }
        return true;
    }

   // @Override
//    public boolean FloydWarshall(long[][] costs, long[][] predecessors) {
//        //ODO Auto-generated method stub
//        costs = new long[V][V];
//        int i, j, k;
//        for (i = 0; i < V; i++)
//            for (j = 0; j < V; j++)
//                costs[i][j] = predecessors[i][j];
//
////        for(i=0;i<V;i++)
////        {
////            for(j=0;j<V;j++)
////            {
////                System.out.println(costs[i][j]);
////            }
////        }
//
//        // Adding vertices individually
//        for (k = 0; k < V; k++) {
//            for (i = 0; i < V; i++) {
//                for (j = 0; j < V; j++) {
//                    costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]);
//                }
//            }
//        }
//        for (i = 0; i < V; i++) {
//            for (j = 0; j < V; j++) {
//                System.out.println(costs[i][j]);
//            }
//        }
//        for (i = 0; i < V; i++) {
//            if (costs[i][i] != 0)
//                return true;
//        }
//        return false;
//    }
   public boolean FloydWarshall(int[][] costs,int[][] predecessors)
   {
//       costs=new long[V][V];
       int i, j, k;
       for (i = 0; i < V; i++)
           for (j = 0; j < V; j++)
               costs[i][j] = graphArray[i][j];
       // Adding vertices individually
       for (k = 0; k < V; k++) {
           for (i = 0; i < V; i++) {
               for (j = 0; j < V; j++) {
                   if(costs[i][k]!=INF &&costs[k][j]!=INF) {
                       costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]);
                       predecessors[i][k] = predecessors[k][j];
                   }
               }
           }
       }
//       for(int s=0;s<costs.length;s++){
//           System.out.print("{");
//           for(int m=0;m<costs[0].length;m++){
//               System.out.print(costs[s][m]+",");
//
//           }
//           System.out.print("},\n");
//       }
       for(i=0;i<V;i++)
       {
           if(costs[i][i]<0)
               return false;
       }
       return true;
   }
    class Node implements Comparable<Node> {
        int vertex;
        int dist;

        Node(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }

        public int compareTo(Node other) {
            return Integer.compare(dist, other.dist);
        }
    }
}


