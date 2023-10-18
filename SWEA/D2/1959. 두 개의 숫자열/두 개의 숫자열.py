T = int(input())

for test_case in range(1, T + 1):
    arr = [[0] for _ in range(2)]
    N, M = map(int, input().split())

    arr[0] = list(map(int, input().split()))
    arr[1] = list(map(int, input().split()))
    if N < M:
        shortArr = 0
    else:
        shortArr = 1

    answer = 0

    for i in range((len(arr[shortArr-1]) - len(arr[shortArr]))+1):
        temp = 0
        for j in range(len(arr[shortArr])):
            temp += arr[shortArr][j] * arr[shortArr-1][i+j]

        if temp > answer:
            answer = temp

    print(f'#{test_case} {answer}')
