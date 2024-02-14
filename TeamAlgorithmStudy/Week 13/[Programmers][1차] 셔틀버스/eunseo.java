import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        //String answer = "";
        int crew = timetable.length; //셔틀 기다리는 인원
        Arrays.sort(timetable);
        int time = 9 * 60; //시간을 분으로 표현
        int lastTime = time + (n - 1) * t; // 마지막 셔틀 운행 시간
        
        int idx = 0;
        for(int i = 0; i<n; i++){
            int seat = 0;
            while(idx < crew && timetable[idx].compareTo(toTime(time)) <= 0){
                if(seat == m)break;
                else{
                    idx++;
                    seat++;
                }
            }
            
            if(i == n - 1){ //마지막 셔틀
                if(seat < m) return toTime(lastTime); //남은 자리 있으면 마지막 셔틀 탑승
                else {// 자리 없으면 마지막 탄 사람 시간 -1분
                    int hour = Integer.parseInt(timetable[idx -1].substring(0,2));
                    int minute = Integer.parseInt(timetable[idx-1].substring(3,5)) - 1;
                    return(toTime(hour * 60 + minute));
                }
            } 
            time += t;   
        }
        return toTime(lastTime);
    }
        
    public String toTime(int time){
        int hour = time / 60;
        int minute = time % 60;
        String answer;
        if(minute < 0){
            hour -= 1;
            minute = 59;
        }
        if(hour < 10) answer = "0" + String.valueOf(hour);
        else answer = String.valueOf(hour);
        if(minute < 10) answer += ":0"+ String.valueOf(minute);
        else answer += ":"+ String.valueOf(minute);
        return answer;
    }
}
