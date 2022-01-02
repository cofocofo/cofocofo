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
        deque<int> deq;
        for(int i=0; i<n; i++){
            int a;
            cin >> a;
            deq.push_back(a);
        }
        for(int i=0; i<n; i++){
            int a;
            if(i%2) {
                a=deq.back();
                deq.pop_back();
            } else {
                a=deq.front();
                deq.pop_front();
            }
            cout << a << " ";
        }
        cout << endl;
    }
}