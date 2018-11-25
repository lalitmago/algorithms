package hackerrank.codesprint.university;

import java.io.*;
import java.util.*;

public class ABSpecialPoints {

    private static List<Integer> lstVertices = new ArrayList<>();
    private static Map<Integer, Integer> mapVertexAdjacency =  new HashMap<>();
    private static Map<Integer, HashSet<Integer>> mapReachableNodes = new HashMap<>();

    private static void setUp(int n, List<List<Integer>> edges) {

        int adjacency;

        HashSet<Integer> setReachableNodes;

        for(int i = 1; i <= n; i++) {

            setReachableNodes = new HashSet<>();
            setReachableNodes.add(i);
            lstVertices.add(i);
            mapVertexAdjacency.put(i, 0);
            mapReachableNodes.put(i, setReachableNodes);
        }

        for(List<Integer> eachEdge : edges) {
            setReachableNodes = mapReachableNodes.get(eachEdge.get(0));
            setReachableNodes.add(eachEdge.get(1));
            mapReachableNodes.put(eachEdge.get(0), setReachableNodes);

            setReachableNodes = mapReachableNodes.get(eachEdge.get(1));
            setReachableNodes.add(eachEdge.get(0));
            mapReachableNodes.put(eachEdge.get(1), setReachableNodes);

            for(Integer eachVertex : eachEdge){
                adjacency = mapVertexAdjacency.get(eachVertex);
                adjacency++;
                mapVertexAdjacency.replace(eachVertex, adjacency);
            }
        }
    }

    private static int checkForABSpeciality(int vertex, int a, int b) {

        Set<Integer> uVertex = mapReachableNodes.get(vertex);
        Set<Integer> uPrimeVertex = mapReachableNodes.get(vertex);

        long leftSide;
        long rightSide;

        int count = 0;

        for(int u : uVertex) {
            for(int uPrime : uPrimeVertex) {
                if(u != uPrime){
                    leftSide = a * mapVertexAdjacency.get(u);
                    rightSide = b * mapVertexAdjacency.get(uPrime);
                    if(mapVertexAdjacency.get(vertex) > leftSide && mapVertexAdjacency.get(vertex) < rightSide) {
                        count++;
                    }
                }

            }
        }

        return count;
    }

    private static int solve(int n, List<List<Integer>> edges, int a, int b) {

        setUp(n, edges);

        int count = 0;

        for(int v : lstVertices) {
            count = count + checkForABSpeciality(v, a, b);
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nmab = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nmab[0]);

        int m = Integer.parseInt(nmab[1]);

        int a = Integer.parseInt(nmab[2]);

        int b = Integer.parseInt(nmab[3]);

        List<List<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] edgesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> edgesRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int edgesItem = Integer.parseInt(edgesRowTempItems[j]);
                edgesRowItems.add(edgesItem);
            }

            edges.add(edgesRowItems);
        }

        int result = solve(n, edges, a, b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


/*for(int eachVertex : mapVertexAdjacency.keySet()) {
            System.out.println("Vertex : " + eachVertex + ", Adjacency : " + mapVertexAdjacency.get(eachVertex) + ", Reachable Nodes : " + mapReachableNodes.get(eachVertex));
        }*/
