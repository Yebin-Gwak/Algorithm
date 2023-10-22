arr = [[0] * 101 for _ in range(101)]
repeat = int(input())
result = 0

for i in range(repeat):
    x, y = map(int, input().split())
    for j in range(x, x + 10):
        for k in range(y, y + 10):
            if arr[j][k] == 0:
                arr[j][k] = 1
                result += 1
                
print(result)
