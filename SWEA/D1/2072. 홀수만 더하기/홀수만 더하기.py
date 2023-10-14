T = int(input())
 
for i in range(1, T+1):
    arr = list(map(int, input().split()))
    answer = 0
    for j in arr:
        if j%2 == 1:
            answer += j
    print('#' + str(i), str(answer))