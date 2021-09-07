//21.09.07
//2^(N-2)를 10^9+7로 나눈 나머지를 구하는 문제
//일반적인 거듭제곱은 O(N)의 시간복잡도를 가지는데
//현재 N은 10^9이므로 시간초과가 날 것이다.
//따라서 logN의 시간복잡도를 갖는 분할정복 방법을 이용한다.
#include <cstdio>
#define ull unsigned long long
int T,N,MOD=1e9+7;
ull myPow(int base, int num){
    if(num==0) return 1;
    if(num==1) return base;
    
    ull ret=myPow(base,num/2);
    
    if(num%2){
        return ((ret*ret)%MOD*base)%MOD;
    } else {
        return (ret*ret)%MOD;
    }
}
int main(){
    scanf("%d",&T);
    for(int t=0; t<T; t++){
        scanf("%d",&N);
        ull answer;
        if(N==1) answer=1;
        else answer = myPow(2,N-2);
        printf("%llu\n", answer);
    }
    return 0;
}