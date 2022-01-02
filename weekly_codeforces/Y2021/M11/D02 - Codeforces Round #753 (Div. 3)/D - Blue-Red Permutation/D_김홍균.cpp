//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <set>
#include <cstring>
#include <algorithm>

using namespace std;

#define endl '\n'
#define len(x) (int)(x).length()
#define size(x) (int)(x).size()
struct Node { int val; char color; };

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
        int A[n];
        for (int i=0; i<n; i++)
            cin >> A[i];
        string s; cin >> s;

        // Process
        Node N[n];
        for (int i=0; i<n; i++) {
            N[i] = {A[i], s[i]};
        }

        sort(N, N+n, [](const Node &u, const Node &v) {
            return make_pair(u.color, u.val) < make_pair(v.color, v.val);
        });

        bool B[n+1];
        memset(B, false, sizeof(B));

        for (int i=0; i<n; i++) {
            auto [val, color] = N[i];
//            cout << "val, color : " << val << ", " << color << endl;
            if (color == 'R' && val <= n) {
                val = max(1, val);
                while (B[val] && val <= n) val++;
                if (val <= n) {
                    B[val] = true;
                }
            }
            if (color == 'B' && val >= 1) {
                val = min(n, val);
                while (B[val] && val >= 1) val--;
                if (val >= 1) {
                    B[val] = true;
                }
            }
        }

        bool isPossible = true;
        for (int i=1; i<=n; i++) {
            if (not(B[i])) {
                isPossible = false;
            }
//            cout << "i : " << i << " | " << B[i] << endl;
        }

        // Control : Output
        cout << ((isPossible) ? "YES" : "NO") << endl;
    }
}

// Helper Functions
/* None */
