from collections import deque
N = int(input())
stand = deque(list(map(int, input().split())))
wait = []
target = 1

while stand:
    if stand[0] == target:
        stand.popleft()
        target += 1
    else:
        wait.append(stand.popleft())
    while wait:
        if wait[-1] == target:
            wait.pop()
            target += 1
        else:
            break

if wait:
    print('Sad')
else:
    print('Nice')
