H,W = map(int, input().split())
blocks = list(map(int, input().split()))

answer = 0

# 양 끝(0, W-1 인덱스)는 물이 안 고이므로 1부터 W-2까지 검사 
for i in range(1, W-1):
    # blocks 배열의 시작:끝(끝 인덱스는 포함X) 
    left = max(blocks[:i])
    right = max(blocks[i+1:])
    
    #현재 블록 높이 blocks[i]
    water = min(left, right) - blocks[i]
    
    if water >0:
        answer +=water

print(answer)
    
    
    
 





