T = int(input())

for test_case in range(1, T+1):
    N, K = map(int, input().split())
    arr = list(map(int, input().split()))
    result = 0
    arr.sort()

    for i in range(K):
        result += arr.pop()
    
    print(f'#{test_case} {result}')
