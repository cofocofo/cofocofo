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
        ll x, n;
        cin >> x >> n;

        // Process
        ll ans, ofs;
        if (x & 1) {
            switch (n % 4) {
                case 0: ofs = 1; break;
                case 1: ofs = n/4*4 + 2; break;
                case 2: ofs = 0; break;
                case 3: ofs = -(n/4*4 + 3); break;
            } ans = ofs + (x-1);
        } else {
            switch (n % 4) {
                case 0: ofs = 0; break;
                case 1: ofs = -(n/4*4 + 1); break;
                case 2: ofs = 1; break;
                case 3: ofs = n/4*4 + 4; break;
            } ans = ofs + x;
        }

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */

// 0
// -1
// 1
// 4
// 0
// -5
// 1
// 8
// 0
// -9
// 1
// 12
// 0

// 1
// 2
// 0
// -3
// 1
// 6
// 0
// -7
// 1
// 10
// 0
// -11
// 1
