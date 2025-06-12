n = int(input())
ans = 1
for a in range(n, 0, -1):
    ans *= a
print(ans)