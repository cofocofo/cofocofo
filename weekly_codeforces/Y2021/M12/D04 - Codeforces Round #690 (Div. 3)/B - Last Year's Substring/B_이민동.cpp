//
// Created by MINDONG on 2021-12-04.
//

#include <bits/stdc++.h>

#define lint long long
#define endl '\n'

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int T; cin >> T;
    while(T--){
        int n; cin >> n;
        string s;
        cin >> s;
        if(s[n-4]=='2' && s[n-3]== '0' && s[n-2]== '2' && s[n-1]== '0') {
            cout << "YES" << endl;
        } else if(s[0]=='2' && s[n-3]== '0' && s[n-2]== '2' && s[n-1]== '0'){
            cout << "YES" << endl;
        } else if (s[0]=='2' && s[1]== '0' && s[n-2]== '2' && s[n-1]== '0') {
            cout << "YES" << endl;
        } else if (s[0]=='2' && s[1]== '0' && s[2]== '2' && s[n-1]== '0') {
            cout << "YES" << endl;
        } else if (s[0]=='2' && s[1]== '0' && s[2]== '2' && s[3]== '0') {
            cout << "YES" << endl;
        } else {
            cout << "NO" << endl;
        }
    }
}