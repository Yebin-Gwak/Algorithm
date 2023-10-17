T = int(input())

for test_case in range(1, T + 1):
    TC = int(input())
    arr = [0] * 1001
    inputs = list(map(int, input().split()))

    max_count = 0
    index = 0
    for i in inputs:
        arr[i] += 1

    for i in range(len(arr)):
        if arr[i] >= max_count:
            max_count = arr[i]
            index = i

    print('#'+str(TC), index)
