import java.io.*;

import java.io.BufferedReader;

public class Graph implements GraphIF {
    int v;
    int e;
    long[][] graphArray;
    long [][] costs;
    long INF=100000000;
    @Override
    public void initialize(String path) throws Exception{
        // TODO Auto-generated method stub
        File file = new File(path);
        BufferedReader br= new BufferedReader(new FileReader(file));
        String st;
         st=br.readLine();
         v=st.charAt(0)- '0';
         e=st.charAt(2)- '0';
         graphArray=new long[v][v];
  //       Double positiveInfinity = Double.POSITIVE_INFINITY;
  
         for(int i=0;i<v;i++)
         {
             for(int j=0;j<v;j++)
             {
                 if(i==j)
                     graphArray[i][j]=0;
                 else
                 graphArray[i][j]=INF;
             }
         }
         for(int i=0;i<e;i++)
         {
             st=br.readLine();
  
             if(st.charAt(4)=='-')
             {
                 graphArray[(st.charAt(0) - '0') - 1][(st.charAt(2) - '0') - 1] = -1*(st.charAt(5) - '0');
             }
            else {
                 graphArray[(st.charAt(0) - '0') - 1][(st.charAt(2) - '0') - 1] = st.charAt(4) - '0';
             }
  
         }
         br.close();
        
    }
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return v;
    }
    @Override
    public boolean Dijkstra(int s, int[] costs, int[] parentsi) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Dijkstra'");
    }
    @Override
    public boolean BellmanFord(int s, int[] costs, int[] parents) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'BellmanFord'");
    }
    @Override
    public boolean FloydWarshall(long[][] costs,long[][] predecessors) {
        // TODO Auto-generated method stub
        costs=new long[v][v];
        int i, j, k;
        for (i = 0; i < v; i++)
            for (j = 0; j < v; j++)
                costs[i][j] = predecessors[i][j];

//        for(i=0;i<v;i++)
//        {
//            for(j=0;j<v;j++)
//            {
//                System.out.println(costs[i][j]);
//            }
//        }

        // Adding vertices individually
        for (k = 0; k < v; k++) {
            for (i = 0; i < v; i++) {
                for (j = 0; j < v; j++) {
                    costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]);
                }
            }
        }

        for(i=0;i<v;i++)
       {
           for(j=0;j<v;j++)
           {
               System.out.println(costs[i][j]);
           }
       }
        for(i=0;i<v;i++)
        {
              if(costs[i][i]!=0)
                 return true;
        }
        return false;
    }
}