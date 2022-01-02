//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

#define endl '\n'

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
    int TC; cin >> TC;

    for (int tc=1; tc<=TC; tc++) {
        int n, k;
        cin >> n >> k;
        string s; cin >> s;

        // Process
        vector<int> V;  /* Save '*' indexes */
        for (int i=0; i<n; i++) {
            if (s[i] == '*') {
                V.push_back(i);
            }
        }

        int sz = (int)V.size(); /* number of '*' */
        int ans;
        if (sz <= 2) {
            ans = sz;
        } else {
            ans = 2;
            int f = V.front();
            int b = V.back();
            s[f] = s[b] = 'x';

            while (b-f > k) {
                int nf = min(f+k, b-1);  /* go k step */
                while (nf > f && s[nf] != '*') nf--;  /* step backward */
                if (nf == f) break;
                s[nf] = 'x';
                ans++;
                f = nf;
            }
        }

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */