//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <set>

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

    // Process
    set<ll> S;
    for (ll i=1; i<=10000; i++) {
        S.insert(i*i*i);
    }

    // Set up : Input
    int t; cin >> t;

    while (t--) {
        ll x; cin >> x;

        // Process
        bool isPossible = false;
        for (ll a : S) {
            if (x <= a) break;
            if (S.find(x-a) != S.end()) {
                isPossible = true;
                break;
            }
        }

        // Control : Output
        cout << ((isPossible) ? "YES" : "NO") << endl;
    }
}

// Helper Functions
/* None */
