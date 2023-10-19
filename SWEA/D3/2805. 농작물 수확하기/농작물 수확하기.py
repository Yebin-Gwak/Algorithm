T = int(input())

for test_case in range(1, T+1):
    size = int(input())
    arr = [list(map(int, input())) for _ in range(size)]
    middle = size // 2
    line = 0
    answer = 0

    for i in range(middle):
        for j in range(middle-line, middle + line + 1):
            answer += arr[i][j]
        line += 1

    for i in arr[middle]:
        answer += i
    line -= 1

    for i in range(middle + 1, size):
        for j in range(middle-line, middle + line + 1):
            answer += arr[i][j]
        line -= 1

    print(f'#{test_case} {answer}')