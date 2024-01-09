import sys
import heapq
input = sys.stdin.readline

n = int(input())
time = [list(map(int, input().split())) for _ in range(n)]
time.sort(key=lambda x: x[0])

pq = [] 

heapq.heappush(pq, time[0][1])
for i in range(1, n):
    if pq:  
        end = heapq.heappop(pq)  # 가장 빨리 끝나는 강의 시간
        if time[i][0] >= end:
            heapq.heappush(pq, time[i][1])
        else:
            heapq.heappush(pq, end)
            heapq.heappush(pq, time[i][1])  # 서로 다른 강의실 할당
    else:
        heapq.heappush(pq, time[i][1])

print(len(pq))
