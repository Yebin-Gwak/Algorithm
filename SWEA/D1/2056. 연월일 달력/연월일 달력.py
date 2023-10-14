T = int(input())
month = {1:31, 2:28, 3:31, 4:30, 5:31, 6:30, 7:31, 8:31, 9:30, 10:31, 11:30, 12:31}

for i in range(1, T+1):
    N = str(input())
    y = int(N[:4])
    m = int(N[4:6])
    d = int(N[6:])

    if y == 0 or m not in month.keys() or d == 0 or d > month[m]:
        print('#'+str(i), -1)
    else:
        print('#'+str(i), end=' ')
        print(N[:4],N[4:6],N[6:],sep='/')
