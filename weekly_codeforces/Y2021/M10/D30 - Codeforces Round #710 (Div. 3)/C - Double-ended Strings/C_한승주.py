import sys
input = sys.stdin.readline
from collections import deque


def make_set(s):
    if s in b_set:
        return
    if not s:
        return
    b_set.add(s)
    make_set(s[1:])
    make_set(s[:-1])


for test in range(int(input())):
    a = input().rstrip()
    b = input().rstrip()
    if a == b:
        print(0)
        continue
    if len(a) > len(b):
        a, b = b, a
    b_set = set()
    answer = float('inf')
    make_set(b)
    start = -1
    end = -2
    for i in range(len(a)):
        if a[i] in b_set:
            start = i
            break
    for j in range(len(a) - 1, -1, -1):
        if a[j] in b_set:
            end = j
            break
    if start == end:
        print(len(a) + len(b) - 2)
        continue
    elif start == -1 and end == -2:
        print(len(a) + len(b))
    else:
        new_a = a[start: end + 1]
        if new_a in b_set:
            print(len(a) + len(b) - len(new_a) * 2)
            continue
        q = deque()
        q.append(new_a)
        while q:
            s = q.popleft()
            left = s[1:]
            right = s[:-1]
            if left in b_set or right in b_set:
                print(len(a) + len(b) - len(left) * 2)
                break
            else:
                q.append(left)
                q.append(right)
