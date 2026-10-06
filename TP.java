import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class TP{
    public static int topoSort(int n, int[][] prereq){
        // calculate the indegrees and the outdegrees
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        int[] indegrees = new int[n];
        Arrays.fill(indegrees, 0);

        // get the adj and indegrees
        for(int i=0; i<prereq.length; i++){
            indegrees[prereq[i][0]]++;
            adj.computeIfAbsent(prereq[i][1], k -> new ArrayList<>()).add(prereq[i][0]);
        }
        // queue
        ArrayDeque<Integer> q = new ArrayDeque<>();
        // complete all the prereqs
        int completed = 0;
        for(int i=0; i<n; i++){
            if(indegrees[i]==0){
                q.push(i);
            }
        }

        // walk the queue
        while(!q.isEmpty()){
            int t = q.getFirst();
            q.pop();

            completed++;
            for(int i: adj.get(t)){
                // null shouldnt happen here
                indegrees[i]--;
                if(indegrees[i]==0){
                    // yaya
                    q.push(i);
                }
            }
        }
        return completed==n?1:0;
    }
}
