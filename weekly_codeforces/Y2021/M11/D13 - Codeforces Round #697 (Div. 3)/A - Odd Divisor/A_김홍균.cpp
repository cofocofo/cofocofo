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
        ll n; cin >> n;

        // Process
        while ((n&1) == 0) {
            n >>= 1;
        }

        bool isExist = (n != 1) && (n & 1);

        // Control : Output
        cout << ((isExist) ? "YES" : "NO") << endl;
    }
}

// Helper Functions
/* None */
