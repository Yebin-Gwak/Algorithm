T = int(input())

for test_case in range(1, T+1):
    N, D = map(int, input().split())
    result = N // (D*2 + 1)
    if N % (D*2 + 1) != 0:
        result += 1
    print(f'#{test_case} {result}')
