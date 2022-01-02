import sys
input = sys.stdin.readline

for test in range(int(input())):
    red, blue, a, b = map(int, input().split())
    cnt = 0
    if a > b:
        a, b = b, a
    while red or blue:
        if red > blue:
            red, blue = blue, red
        if red // a and blue // b:
            cnt += min(red//a, blue//b)
            red -= a * cnt
            blue  -= b * cnt
        if red < a or blue < b:
            break
    print(cnt)