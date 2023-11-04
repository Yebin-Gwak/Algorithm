N = 1000001
result = [True] * N
result[0], result[1] = False, False

for i in range(2, N):
    if result[i] == True:
        for j in range(i*2, N, i):
            result[j] = False

for i in range(N):
    if result[i] == True:
        print(i,end=' ')
