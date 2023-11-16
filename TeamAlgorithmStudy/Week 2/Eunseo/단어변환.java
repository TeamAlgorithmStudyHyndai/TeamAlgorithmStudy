class Solution {
    static int result = 0;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int[] check = new int[words.length];
        dfs(begin, target, words, 0, check);
        answer = result;
        return answer;
    }
    public static void dfs(String s, String target, String[] words, int cnt, int[] check){
        if(target.equals(s)) result = cnt;
        for(int i = 0; i< words.length; i++){
            if(check[i] == 0 && diff(s, words[i])){
                check[i] = 1;
                dfs(words[i], target, words, cnt + 1, check);
                check[i] = 0; 
            }
        }
    }
    public static boolean diff(String a, String b){
        int c = 0;
        for(int i =0; i< a.length(); i++){
            if(a.charAt(i) != b.charAt(i))c++;
        }
        if(c == 1) return true;
        return false;
    }
}

