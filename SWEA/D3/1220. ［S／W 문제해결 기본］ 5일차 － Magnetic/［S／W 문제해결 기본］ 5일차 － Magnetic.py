for test_case in range(1, 11):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]
    ans = 0
    arr_t = list(zip(*arr))

    for lst in arr_t:
        prev = 0
        for n in lst:
            if n:
                if n == 2 and prev == 1:
                    ans += 1
                prev = n

    print(f'#{test_case} {ans}')