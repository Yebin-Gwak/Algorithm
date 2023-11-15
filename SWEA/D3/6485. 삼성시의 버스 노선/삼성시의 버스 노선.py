T = int(input())

for test_case in range(1, T+1):
    N = int(input())
    arr = [0] * 5001
    for i in range(N):
        start, end = map(int, input().split())
        for j in range(start, end+1):
            arr[j] += 1
    P = int(input())
    arr2 = []
    for i in range(P):
        arr2.append(int(input()))

    print(f'#{test_case}',end=' ')
    for i in arr2:
        print(arr[i],end=' ')
    print()
