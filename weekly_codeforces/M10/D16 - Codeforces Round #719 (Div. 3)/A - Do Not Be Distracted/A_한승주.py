import sys
input = sys.stdin.readline

for test in range(int(input())):
    n = int(input())
    a = list(input().rstrip())
    char_set = {a[0]: True}
    for i in range(1, n):
        if a[i - 1] != a[i]:
            if a[i] in char_set:
                print('NO')
                break
            else:
                char_set[a[i]] = True
    else:
        print('YES')