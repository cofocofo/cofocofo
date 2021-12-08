//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <cstring>
#include <set>

using namespace std;

#define endl '\n'
#define len(x) (int)(x).length()
#define size(x) (int)(x).size()
typedef long long ll;
typedef pair<int,int> Pair;
#define fi first
#define se second

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
        int a, b, k;
        cin >> a >> b >> k;
        Pair P[k];
        for (int i=0; i<k; i++)
            cin >> P[i].fi;
        for (int i=0; i<k; i++)
            cin >> P[i].se;

        // Process
        int CA[a+1], CB[b+1];
        memset(CA, 0, sizeof(CA));
        memset(CB, 0, sizeof(CB));

        for (auto [f, s] : P) {
            CA[f]++, CB[s]++;
        }

        ll ans = 0;
        for (auto [f, s] : P) {
            int cnt = k - (CA[f] + CB[s]) + 1;
            ans += cnt;
        } ans /= 2;

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */
