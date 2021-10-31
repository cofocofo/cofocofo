import sys
input = sys.stdin.readline

for test in range(int(input())):
    t = input().rstrip()
    re_t = t[::-1]
    tmp = 'cab'
    idx = 0
    check = 0
    while idx < len(t):
        if re_t[idx] not in tmp:
            tmp = re_t[idx] + tmp
            check = idx
        idx += 1
    print(re_t[check][::-1], tmp)