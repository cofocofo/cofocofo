#include <bits/stdc++.h>

#define endl '\n'

using namespace std;

int main() {
    //FAST IO
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int T;
    cin >> T;

    for(int t=0; t<T; t++){
        int n;
        cin >> n;
        vector<int> arr(n);
        for(int i=0; i<n; i++){
            cin >> arr[i];
        }
        int answer = 0;
        int tmp=arr[0];
        for(int i=1; i<n; i++){
            if(tmp<arr[i]){
                while(arr[i]>2*tmp){
                    tmp*=2;
                    answer++;
                }
            } else {
                while(tmp>2*arr[i]){
                    if(tmp%2==0) tmp/=2;
                    else tmp=tmp/2+1;
                    answer++;
                }
            }
            tmp=arr[i];
        }

        cout << answer << endl;
    }
}