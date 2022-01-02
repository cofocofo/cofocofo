for test in range(int(input())):
    k = int(input())
    # k의 좌표? 제곱수 안쪽
    pivot = int(k**0.5)
    # (0,pivot)부터 시작 (pivot,0까지) 총 2*pivot+1개.
    if not k - pivot**2:
        print(pivot,1)
    elif k - pivot**2 <= pivot:
        print(k - pivot**2, pivot+1)
    else:
        print(pivot+1, pivot - ((k - pivot**2)-(pivot+1))+1)