public class Main{
    public static void main(String[] args){
        int[][] prereqs = {{0, 1}, {1, 0}};
        int ans = TP.topoSort(2, prereqs);
        System.out.println(ans);

    }
}
