import sys
input = sys.stdin.readline

for t in range(int(input())):
    s = input().rstrip()
    if len(s)&1:
        print('NO')
        continue
    count = 0
    for char in s:
        if char =='B':
            count += 1
    print('YES' if count == len(s)//2 else 'NO')
