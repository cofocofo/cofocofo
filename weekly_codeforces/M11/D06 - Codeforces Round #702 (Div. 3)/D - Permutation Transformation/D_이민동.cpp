#include <bits/stdc++.h>

#define endl '\n'
#define lint long long

using namespace std;
int argMax(vector<int>& arr, int s, int e){
    int mx=s;
    for(int i=s+1; i<=e; i++){
        if(arr[mx]<arr[i]){
            mx=i;
        }
    }
    return mx;
}
void find(vector<int>& arr, vector<int>&ans, int s, int e, int d){
    if(s>e) return;
    int mx = argMax(arr,s,e);
    ans[mx]=d;
    find(arr, ans, s, mx-1, d+1);
    find(arr, ans, mx+1, e, d+1);
}
int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int T;
    cin >> T;

    for(int t=0; t<T; t++){
        int n;
        cin >> n;
        vector<int> arr(n);
        vector<int> ans(n);
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }

        find(arr, ans, 0, n-1, 0);

        for(int e : ans){
            cout << e << " ";
        }
        cout << endl;
    }
}