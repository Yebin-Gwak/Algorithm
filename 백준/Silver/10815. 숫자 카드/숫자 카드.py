N = int(input())
arr = sorted(list(map(int, input().split())))
M = int(input())
find = list(map(int, input().split()))
result = [0 for _ in range(M)]

for i in range(M):
    start = 0
    end = N - 1

    while start <= end:
        middle = (start + end) // 2
        if arr[middle] == find[i]:
            result[i] = 1
            break
        elif arr[middle] > find[i]:
            end = middle - 1
        elif arr[middle] < find[i]:
            start = middle + 1

for i in result:
    print(i, end=' ')
