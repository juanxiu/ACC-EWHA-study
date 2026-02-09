n = int(input())

# 상근이 숫자 
A = list(map(int, input().split()))

m = int(input())

B = list(map(int, input().split()))

# 개수를 키로 저장하기 위해 해시맵 사용 
count = {} 


#개수 세기 먼저 
for x in A: 
    if x in count:  #키에 있는가 
        count[x] += 1 
    else: 
        count[x] = 1  #하나 나온 것이므로 
        
# 상근이 숫자에 몇 개 갖고 있는지 
for x in B:
    result = count.get(x, 0) # 있다면 키 x의 값 출력, 없으면 0 출력 
    print(result, end=" ")
    
    