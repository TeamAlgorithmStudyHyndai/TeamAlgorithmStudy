import java.util.*;
class Solution {
  
    public int solution(int N, int number) {
        ArrayList<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
        
        //배열 만들기
        for(int i = 0 ; i < 9 ; i++){
            list.add(new HashSet<Integer>());
        }
        //N이 1일때
        list.get(1).add(N);
        
        StringBuilder sb = new StringBuilder();
        sb.append(N);
        
        //2이상 숫자 N을 이용해서 만들 수 있는 경우의 수
        for(int i= 2; i < list.size() ; i++){
            sb.append(N);
            Set<Integer> newSet = list.get(i); // i번째 set을 얻음
            newSet.add(Integer.parseInt(sb.toString()));
            
            for(int j= 1; j<= i; j++){
                //i에서 j번째 숫자를 사용하는 경우
                Set<Integer> set1 = list.get(j);
                //i에서 나머지 숫자를 사용하는 경우
                Set<Integer> set2 = list.get(i-j);
                
                for(Integer num1 : set1){
                    for(Integer num2 : set2){
                        newSet.add(num1 + num2);
                        newSet.add(num1 - num2);
                        newSet.add(num1 * num2);
                        
                        if(num1!=0 && num2 !=0 ){
                            newSet.add(num1 / num2);
                        }
                     }
                }
            }
        }
        
        //목표 숫자를 number를 포함하는 Set을 찾기 위해 반복문
        for (Set<Integer> set : list) {
            //목표 숫자를 찾는다면 그대로 바로 return
            if(set.contains(number)) return list.indexOf(set);
        }
        
        //최솟값이 8보다 큰 경우 -1 return
        return -1;
    }
}