T = int(input())

for i in range(1, T+1):
    arr = list(map(int, input().split()))
    print('#'+str(i), str(max(arr)))
