//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>

using namespace std;

#define endl '\n'

// Set up : Global Variables
typedef long long ll;

// Set up : Functions Declaration
ll f(int n);


int main()
{
    // Set up : I/O
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // Set up : Input
    int TC; cin >> TC;

    while (TC--) {
        int L, R;
        cin >> L >> R;

        // Process
        // (L~R) = (1~R) - (1~L)
        ll ans = f(R) - f(L);

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
ll f(int n)
{
    ll ret = 0;
    while (n) {
        ret += n;  // 1's place, 10's place, 100's place, ...
        n /= 10;
    }
    return ret;
}