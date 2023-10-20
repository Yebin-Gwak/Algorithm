T = int(input())

for test_case in range(1, T+1):
    N, A, B = map(int, input().split())
    if (A + B) - N < 0:
        minimum = 0
    else:
        minimum = (A + B) - N

    maximum = min(A, B)

    print(f'#{test_case} {maximum} {minimum}')