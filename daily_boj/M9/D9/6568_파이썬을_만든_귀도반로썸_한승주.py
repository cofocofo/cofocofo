import sys
input = sys.stdin.readline

while True:
    memory = [0 for _ in range(32)]
    cal = 0
    pc = 0
    for i in range(32):
        try:
            memory[i] = int(input().rstrip(),2)
        except EOFError:
            exit()
    while True:
        adress = memory[pc]
        cmd = adress//32
        value = adress%32
        pc = (pc + 1)%32
        if cmd == 0:
            memory[value] = cal
        elif cmd == 1:
            cal = memory[value]
        elif cmd == 2:
            if not cal:
                pc = value
        elif cmd == 4:
            cal = (cal-1)%256
        elif cmd == 5:
            cal = (cal+1)%256
        elif cmd == 6:
            pc = value
        elif cmd == 7:
            break
    print(bin(cal)[2:].zfill(8))