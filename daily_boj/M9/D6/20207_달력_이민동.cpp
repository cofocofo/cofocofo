#include <cstdio>
int arr[366],ret; //일정을 저장하는 배열과 출력값
int main(){
    int N; //일정의 개수 N
    scanf("%d",&N);
    int s,e; // 시작일(s), 종료일(e)
    for(int i=0; i<N; i++){
        scanf("%d %d",&s,&e);
        for(int j=s; j<=e; j++) arr[j]++;
    }
    // 연속된 일정을 모두 감싸는 직사각형이 되려면
    // 일정이 연속되는 기간 과 그 기간 중 가장 일정이 많은 날을 곱하면 된다.
    
    int index=1; //1일부터 살펴본다.
    while(index<=365){
        if(arr[index]>0){ //만약 일정이 하나라도 있다면,
            int startidx=index; // 그 인덱스를 시작일로 삼고
            int maxval = 0; 
            while(index<=365 && arr[index]>0){ // 연속되는 기간을 더하면서 동시에
                maxval = (maxval>=arr[index]) ? maxval : arr[index]; //일정이 가장 많은 날을 구한다.
                index++;
            }
            ret+=maxval*(index-startidx); //출력할 결과에 직사각형의 넓이를 더한다.
        }
        index++;
    }
    printf("%d",ret);
}