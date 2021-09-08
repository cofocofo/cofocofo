// BOJ 17951 흩날리는 시험지
// 
#include <cstdio>
#include <vector>
int main(){
    int N,K;
    scanf("%d %d",&N,&K);
    std::vector<int> arr(N);
    int left=-1;
    int right=1;
    for(int i=0; i<N; i++) {
        scanf("%d",&arr[i]);
        right+=arr[i];
    }
    
    while(left+1<right){
        int mid = (left+right)/2;
        int sum=0;
        int count=0;
        for(int i=0; i<N; i++){
            sum+=arr[i];
            if(sum>=mid){
                count++;
                sum=0;
            }
        }
        if(count>=K){
            left=mid;
        } else {
            right=mid;
        }
    }
    printf("%d", left);
    return 0;
}