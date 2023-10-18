T = int(input())

for test_case in range(1, T + 1):
    memory = str(input())
    arr = ['0' for _ in range(len(memory))]
    count = 0

    for i in range(len(memory)):
        if arr[i] == memory[i]:
            continue
        else:
            count += 1
            for j in range(i, len(memory)):
                if arr[j] == '0':
                    arr[j] = '1'
                else:
                    arr[j] = '0'
            
    print(f'#{test_case} {count}')