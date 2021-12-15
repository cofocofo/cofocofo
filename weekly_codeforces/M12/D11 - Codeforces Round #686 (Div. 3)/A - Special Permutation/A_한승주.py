import sys
input = sys.stdin.readline
 
 
for test in range(int(input())):
    n = int(input())
    answer = [i for i in range(n, 0, -1)]
    if n & 1:
        answer.append(answer.pop(n//2))
    print(*answer)