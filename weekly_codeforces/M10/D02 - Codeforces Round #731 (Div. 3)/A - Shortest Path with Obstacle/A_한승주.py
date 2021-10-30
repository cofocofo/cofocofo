import sys
input = sys.stdin.readline

for test in range(int(input())):
    input()
    a_x, a_y = map(int, input().split())
    b_x, b_y = map(int, input().split())
    if a_x < b_x:
        a_x, b_x = b_x, a_x
    if a_y < b_y:
        a_y, b_y = b_y, a_y
    f_x, f_y = map(int, input().split())
    answer = a_x-b_x + a_y-b_y
    # 사이검증
    if a_x == b_x == f_x and a_y > f_y > b_y:
        answer += 2
    if a_y == b_y == f_y and a_x > f_x > b_x:
        answer += 2
    print(answer)
    