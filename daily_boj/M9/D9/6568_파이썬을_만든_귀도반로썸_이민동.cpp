// 구현 난이도는 낮으나 함정이 많은 문제.
// 내가 잘못 생각한 부분 2가지
// 1. 프로그램 카운터가 32를 벗어나면 종료라고 생각해서
// for(int pc=0; pc<32; pc++) 라고 작성했는데 잘못된 조건이었다.
// 2. 가산기 값이 0 이면 -1을 수행하지 않는다고 구현했었는데
// 11111111 로 넘어가게 처리해야 했다.

#include <cstdio>
#include <string>
using namespace std;
int main(){
    int mem[32];
    char input[9];
    while(scanf("%s",input)!=-1){
        int adder = 0;
        mem[0] = stoi(input,0,2);
        for(int i=1; i<32; i++) {
            scanf("%s",input);
            mem[i] = stoi(input,0,2);
        }
        int pc=0;
        while(true){
            int cmd = mem[pc];
            pc=(pc+1)%32;
            if(cmd>>5==7) break;
            switch(cmd>>5){
                case 0:
                    mem[cmd&31]=adder;
                    break;
                case 1:
                    adder=mem[cmd&31];
                    break;
                case 2:
                    if(adder==0) pc = cmd&31;
                    break;
                case 4:
                    adder = (adder-1)&255;
                    break;
                case 5: 
                    adder=(adder+1)&255;
                    break;
                case 6: 
                    pc = cmd&31;
                    break;
            }
        }
        for(int i=7; i>=0; i--)
            printf("%1d", (adder >> i) & 1);
        printf("\n");
    }
    return 0;
}