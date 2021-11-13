#include <bits/stdc++.h>

#define endl '\n'
#define lint long long

using namespace std;
int argMax(int* arr){
    int mx=0;
    for(int i=1; i<3; i++){
        if(arr[mx]<arr[i]){
            mx=i;
        }
    }
    return mx;
}
int argMin(int* arr){
    int mn=0;
    for(int i=1; i<3; i++){
        if(arr[mn]>arr[i]){
            mn=i;
        }
    }
    return mn;
}
int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int T;
    cin >> T;

    for(int t=0; t<T; t++){
        int answer = 0;
        int c[3]{0,0,0};
        int n;
        cin >> n;
        for(int i=0; i<n; i++){
            int a;
            cin >> a;
            c[a%3]++;
        }
        while(true){
            int mx = argMax(c);
            int mn = argMin(c);
            if(c[mx]==c[mn]) break;
            c[mx]--;
            c[mn]++;
            if((mx+1)%3==mn){
                answer++;
            } else {
                answer+=2;
            }
        }
        cout << answer << endl;
    }
}