import sys
N = int(sys.stdin.readline().rstrip())

for i in range(1, N+1):
    nums = list(map(int, str(i)))
    add = sum(nums) + i
    if add == N:
        print(i)
        break
    if i == N:
        print(0)