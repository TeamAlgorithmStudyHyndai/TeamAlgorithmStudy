import heapq
def solution(n, s, a, b, fares):
    MM = 2_100_000_000
    #다익스트라
    #A - 모든지점
    #B - 모든지점
    #S - 모든지점
    
    node = [[-1 for _ in range(n + 1)]for _ in range(n + 1)]
    for i in range(1, n+1): node[i][i] = 0
    
    for f in fares:
        node[f[0]][f[1]] = f[2]
        node[f[1]][f[0]] = f[2]
    
    dis_a = [MM for _ in range(n + 1)]
    dis_b = [MM for _ in range(n + 1)]
    dis_s = [MM for _ in range(n + 1)]
    
    dis_a[a] = 0
    dis_b[b] = 0
    dis_s[s] = 0

    pq = []
    heapq.heappush(pq, (0,s))
    while pq:
        xy = heapq.heappop(pq)
        cost = -xy[0]
        pos = xy[1]
        if dis_s[pos] < cost : continue
        
        for i in range(1,n + 1):
            if node[pos][i] == -1 : continue
            new_cost = cost + node[pos][i]
            if new_cost < dis_s[i] :
                dis_s[i] = new_cost
                heapq.heappush(pq, (-new_cost, i))
                
    pq = []
    heapq.heappush(pq, (0,a))
    while pq:
        xy = heapq.heappop(pq)
        cost = -xy[0]
        pos = xy[1]
        if dis_a[pos] < cost : continue
        
        for i in range(1,n + 1):
            if node[pos][i] == -1 : continue
            new_cost = cost + node[pos][i]
            if new_cost < dis_a[i] :
                dis_a[i] = new_cost
                heapq.heappush(pq, (-new_cost, i))
                
    pq = []
    heapq.heappush(pq, (0,b))
    while pq:
        xy = heapq.heappop(pq)
        cost = -xy[0]
        pos = xy[1]
        if dis_b[pos] < cost : continue
        
        for i in range(1,n + 1):
            if node[pos][i] == -1 : continue
            new_cost = cost + node[pos][i]
            if new_cost < dis_b[i] :
                dis_b[i] = new_cost
                heapq.heappush(pq, (-new_cost, i))
    
    
    answer = MM
    for i in range(1, n + 1):
        answer = min(answer, dis_s[i] + dis_a[i] + dis_b[i])
    return answer
