import sys
N = int(sys.stdin.readline().rstrip())
count = 0

while N >= 0:
    if N % 5 == 0:
        count += N//5
        print(count)
        break
    else:
        count += 1
        N -= 3
else:
    print(-1)