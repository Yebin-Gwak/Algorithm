T = int(input())

for i in range(1, T+1):
    size = int(input())
    arr = [[0] * size for _ in range(size)]
    w, h = 0, 0
    arr[h][w] = 1
    count = 1

    handle = 'right'

    while count != size*size:

        if handle == 'right':
            if w+1 == size or arr[h][w+1] != 0:
                handle = 'down'
                continue
            else:
                w += 1

        elif handle == 'down':
            if h+1 == size or arr[h+1][w] != 0:
                handle = 'left'
                continue
            else:
                h += 1

        elif handle == 'left':
            if w-1 == -1 or arr[h][w-1] != 0:
                handle = 'up'
                continue
            else:
                w -= 1

        elif handle == 'up':
            if h-1 == -1 or arr[h-1][w] != 0:
                handle = 'right'
                continue
            else:
                h -= 1

        count += 1
        arr[h][w] = count


    print('#'+str(i))
    for a in range(size):
        for b in range(size):
            print(arr[a][b], end=' ')
        print('')
