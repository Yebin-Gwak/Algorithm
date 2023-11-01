from itertools import combinations

T = int(input())

for test_case in range(1, T+1):
    N, M = map(int, input().split())
    arr = list(map(int, input().split()))
    result = 0

    for i in range(1, N+1):
        for j in combinations(arr, i):
            if sum(j) == M:
                result += 1

    print(f'#{test_case} {result}')