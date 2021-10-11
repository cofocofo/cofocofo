import sys
input = sys.stdin.readline

for test in range(int(input())):
    s = input().rstrip()
    left = 0
    right = len(s) - 1
    # s의 마지막이 되어야할 문자의 아스키 코드값
    start = len(s) - 1  + ord('a')
    # 모든 s의 순회가 끝나면 종료
    while left <= right:
        flag = 0
        if s[right] == chr(start):
            right -= 1
            start -= 1
            flag = 1
        elif s[left] == chr(start):
            left += 1
            start -= 1
            flag = 1
        # 좌우에 내가 찾는 문자가 없으면 잘못된 문자열
        if not flag:
            print('NO')
            break
    else:
        print('YES')


    