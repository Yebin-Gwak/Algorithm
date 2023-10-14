P, K = map(int, input().split())

now = K-1
count = 0
while now != P:
    if now == 999:
        now = -1
    now += 1
    count += 1
    
print(count)