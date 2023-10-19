for test_case in range(1, 11):
    N, M = input().split()
    arr = list(map(int, M))
    index = 0

    while True:
        if index == len(arr)-1:
            break
        elif arr[index] == arr[index+1]:
            arr.pop(index)
            arr.pop(index)
            index -= 1
            if index < 0:
                index = 0
        else:
            index += 1

    print(f'#{test_case}', end=' ')

    for i in arr:
        print(i, end='')
    print()

