for test_case in range(1, 11):
    T = int(input())
    arr = [list(map(int, input().split())) for _ in range(100)]
    maximum = 0
    temp = 0

    for i in range(100):
        temp = sum(arr[i])
        if temp > maximum:
            maximum = temp

    for i in range(100):
        temp = 0
        for j in range(100):
            temp += arr[j][i]
        if temp > maximum:
            maximum = temp

    temp = 0
    for i in range(100):
        temp += arr[i][i]
    if temp > maximum:
        maximum = temp

    temp = 0

    for i in range(99, -1, -1):
        temp += arr[99-i][i]
    if temp > maximum:
        maximum = temp

    print(f'#{test_case} {maximum}')
    