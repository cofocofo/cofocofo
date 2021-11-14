for test in range(int(input())):
    a, b, c = map(int, input().split())
    # a 건너편에 b 일때 c의 건너편은?
    if a > b:
        a, b = b, a
    cnt = (b - a)*2
    # c가 범위 밖이거나 a, b가 규칙을 깨거나.
    if c > cnt or b > cnt:
        print(-1)
    else:
        print((c + cnt//2-1)%cnt+1)
    