
n = int(input())
A = set(map(int, input().split())) 


m = int(input())
#이건 셋이면 안됨. 중복을 제거하기 때문 
B = list(map(int, input().split())) 

# 각각 셋(리스트와 유사) 에 저장해두었음. 이제 비교하면 됨 

# 모르는 변수 x, 리스트B에 있는 값이 x에 대입될 것 
for x in B: 
    if(x in A): 
        print(1); 
    else:
        print(0) 