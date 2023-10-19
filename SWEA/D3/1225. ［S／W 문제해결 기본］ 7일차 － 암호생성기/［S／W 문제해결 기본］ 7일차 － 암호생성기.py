from collections import deque

for test_case in range(10):
    T = int(input())
    arr = deque(map(int, input().split()))

    while arr[-1] > 0:
        for i in range(1, 6):
            arr[0] -= i
            arr.append(arr.popleft())
            if arr[-1] <= 0:
                arr[-1] = 0
                break

    print(f'#{T}', end=' ')

    for i in arr:
        print(i, end=' ')
    print()