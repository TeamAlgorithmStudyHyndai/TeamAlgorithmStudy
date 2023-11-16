class Solution {
    static boolean[] vistied;

    public void dfs(int comIndex, int[][] computers){
        vistied[comIndex] = true;
        int n = 0;
        for(int node : computers[comIndex]){
            
            if(!vistied[n] && (node == 1)){
                dfs(n, computers);
            }
            n++;
        }

    }

    public int solution(int n, int[][] computers) {
        this.vistied = new boolean[n];
        int answer = 0;
        for (int i =0; i<n; i++){
            if (vistied[i] == false){
                dfs(i, computers);
                answer +=1;
            }
        }

        return answer;
    }
}