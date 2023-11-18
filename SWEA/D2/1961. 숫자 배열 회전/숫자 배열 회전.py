def turn(list):
    templist = [[0] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            templist[i][j] = list[-1-j][i]
    return templist




T = int(input())

for test_case in range(1, T+1):
    N = int(input())

    arr = [list(map(int, input().split())) for _ in range(N)]
    arr90 = turn(arr)
    arr180 = turn(arr90)
    arr270 = turn(arr180)

    print(f'#{test_case} ')

    for i in range(N):
        print("".join(map(str,arr90[i])), "".join(map(str,arr180[i])), "".join(map(str,arr270[i])))