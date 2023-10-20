from itertools import combinations

T = int(input())

for test_case in range(1, T+1):
    arr = list(map(int, input().split()))
    com = list(combinations(arr, 3))
    result = []
    
    for i in com:
        result.append(sum(i))

    result = list(set(result))
    result.sort(reverse=True)

    print(f'#{test_case} {result[4]}')
