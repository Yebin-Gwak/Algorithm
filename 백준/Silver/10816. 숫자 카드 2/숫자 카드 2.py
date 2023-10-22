import sys
from collections import Counter
N = int(input())

firstList = list(map(int, sys.stdin.readline().split()))

M = int(input())
secondList = list(map(int, sys.stdin.readline().split()))

c = Counter(firstList)

for i in secondList:
    print(c[i], end=' ')

