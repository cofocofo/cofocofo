//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <queue>

using namespace std;

#define endl '\n'
#define len(x) (int)(x).length()
#define size(x) (int)(x).size()
typedef long long ll;

// Set up : Global Variables
/* None */

// Set up : Functions Declaration
/* None */


int main()
{
    // Set up : I/O
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // Set up : Input
    int t; cin >> t;

    while (t--) {
        int n; cin >> n;
        priority_queue<ll, vector<ll>, greater<>> pq;
        for (int i=0; i<n; i++) {
            ll a; cin >> a;
            pq.push(a);
        }

        // Process
        ll ofs = 0, ans = pq.top();
        while (not(pq.empty())) {
            ll temp = pq.top()-ofs;
            ans = max(ans, temp);
            ofs += temp;
            pq.pop();
        }

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */

// 10
// 0 0
// -1 2 0
// 1 2 7 10
// 2 3
// -4 -2 0 2 3
// -1 1
// -2

// -4 -2 0 2 3
