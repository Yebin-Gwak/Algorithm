arr = [[0] for _ in range(9)]
result = 0
x, y = 1, 1

for i in range(9):
    arr[i] = list(map(int, input().split()))

for i in range(9):
    for j in range(9):
        if arr[i][j] > result:
            result = arr[i][j]
            x = i+1
            y = j+1

print(result)
print(x, y)
