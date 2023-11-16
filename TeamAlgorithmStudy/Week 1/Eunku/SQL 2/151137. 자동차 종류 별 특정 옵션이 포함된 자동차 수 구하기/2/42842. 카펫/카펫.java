class Solution {
    public int[] solution(int brown, int yellow) {
        int x,y; // x는 가로, y는 세로-2
        int middle; // 가운데 노란색 넓이
        int total = brown + yellow; // 전체 넓이
        int[] answer = new int[2];
        for (int i = brown /2 -1; i > 1 ; i--){
            x = i;
            y = brown/2 - i;
            middle = (x-2) * y;
            if (middle == yellow){
                answer[0] = x;
                answer[1] = y+2;
                return answer;
            }
        }
        return answer;
    }
}