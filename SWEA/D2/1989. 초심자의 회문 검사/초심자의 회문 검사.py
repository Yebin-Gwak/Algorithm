T = int(input())

for i in range(1, T+1):
    word = input().rstrip()
    half = len(word)//2
    check = True

    for j in range(half):
        if word[j] != word[-j-1]:
            check = False
            break

    if check:
        print('#'+str(i), '1')
    else:
        print('#'+str(i), '0')