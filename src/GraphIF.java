
public interface GraphIF {
    void initialize(String path)throws Exception;
    int size();
    boolean Dijkstra(int s, int[]costs, int[]parentsi);
    boolean BellmanFord(int s, int[]costs, int[]parents);
    boolean FloydWarshall(long[][] costs,long[][] predecessors);
}
