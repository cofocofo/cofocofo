#include <bits/stdc++.h>

#define endl '\n'
#define lint long long

using namespace std;
lint cube(int n){
    return (lint)n*n*n;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int T;
    cin >> T;

    for(int t=0; t<T; t++){
        bool flag=false;
        lint x;
        cin >> x;
        int lo=1;
        int hi=1;
        while(cube(hi)<x){
            hi++;
        }

        while(lo<=hi){
            if(cube(lo)+cube(hi)>x){
                hi--;
            } else if(cube(lo)+cube(hi)<x){
                lo++;
            } else {
                flag=true;
                break;
            }
        }

        cout << ((flag) ? "YES" : "NO") << endl;
    }
}