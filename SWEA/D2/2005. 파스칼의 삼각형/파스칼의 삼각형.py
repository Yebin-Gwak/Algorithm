T = int(input())

for test_case in range(1, T+1):
    N = int(input())
    arr = [[0] * i for i in range(1, N+1)]
    arr[0][0] = 1

    for i in range(1, len(arr)):
        arr[i][0], arr[i][-1] = 1, 1
        for j in range(1, i):
            arr[i][j] = arr[i-1][j-1] + arr[i-1][j]

    print('#'+str(test_case))
    for i in arr:
        for j in i:
            print(j, end=' ')
        print()