def solution(sticker):
    answer = 0
    if len(sticker) == 1 :
         return sticker[0]
    dp=[0 for _ in range(len(sticker))] #첫번째 스티커 선택
    dp2=[0 for _ in range(len(sticker))] #첫번째 스티커 선택X
    
    dp[0] = sticker[0]
    dp[1] = max(sticker[0], sticker[1])
    
    dp2[0] = 0
    dp2[1] =sticker[1]
    
    for i in range(2,len(sticker)):
        dp[i] = max(dp[i-2] + sticker[i], dp[i-1])
        dp2[i] = max(dp2[i-2] + sticker[i], dp2[i-1])

    dp[len(sticker) -1] = 0 #첫번째 스티커 선택 시 마지막 스티커는 뗄 수 없음
    answer = max(max(dp), max(dp2))
    
    return answer
