#include <bits/stdc++.h>

#define lint long long
#define endl '\n'

using namespace std;

bool dfs(int n, bool vis[]){
    if(n==0) return true;
    if(n<0) return false;

    for(int i=9; i>0; i--){
//        if(n==i && vis[i]) return false;
        if(!vis[i]){
            vis[i]=true;
            if(dfs(n-i, vis)){
                return true;
            };
            vis[i]=false;
        }
    }

    return false;
}
int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int T;
    cin >> T;
    while (T--) {
        int n;
        cin >> n;
        if (n < 10) cout << n;
        else if (n > 45) cout << -1;
        else {
            bool vis[10]{};
            if(dfs(n, vis)){
                for(int i=1; i<10; i++){
                    if(vis[i]) cout << i;
                }
            } else {
                cout << -1;
            }
        }
        cout << endl;
    }
}