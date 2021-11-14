import sys
input = sys.stdin.readline

for test in range(int(input())):
    s = input().rstrip()
    char_set = {chr(i): 0 for i in range(97, 97+26)}
    for char in s:
        char_set[char] += 1
    flag = 0
    cnt = 0
    for char in char_set:
        if char_set[char] >= 2:
            cnt += 1
        elif char_set[char] == 1:
            if flag:
                cnt += 1
                flag = 0
            else:
                flag = 1
    print(cnt)