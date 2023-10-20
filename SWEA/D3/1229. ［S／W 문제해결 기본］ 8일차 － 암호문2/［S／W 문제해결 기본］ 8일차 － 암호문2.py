for test_case in range(1, 11):
    N = int(input())
    arr = list(map(int, input().split()))
    M = int(input())
    cmdList = list(input().split())
    index = 0

    for i in range(M):
        cmd = cmdList[index]
        if cmd == 'I':
            x = int(cmdList[index + 1])
            y = int(cmdList[index + 2])
            for j in range(index + 2 + y, index + 2, -1):
                arr.insert(x, cmdList[j])
            index += 3 + y
            
        if cmd == 'D':
            x = int(cmdList[index + 1])
            y = int(cmdList[index + 2])
            for j in range(y):
                arr.pop(x)
            index += 3
            
    print(f'#{test_case}', end=' ')
    for k in range(10):
        print(arr[k], end=' ')
    print()
