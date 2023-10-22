arr = [list(input()) for _ in range(5)]
repeat = max(len(arr[0]), len(arr[1]), len(arr[2]), len(arr[3]), len(arr[4]))

for i in range(repeat):
    for j in range(5):
        if i > len(arr[j])-1:
            continue
        else:
            print(arr[j][i], end='')
