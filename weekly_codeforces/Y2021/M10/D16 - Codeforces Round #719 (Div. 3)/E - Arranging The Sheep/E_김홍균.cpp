//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <cstring>

using namespace std;

#define endl '\n'
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
    int TC; cin >> TC;

    for (int tc=1; tc<=TC; tc++) {
        int N; cin >> N;
        string S; cin >> S;

        // Process
        ll dp_l2r[N], dp_r2l[N];
        memset(dp_l2r, 0, sizeof(dp_l2r));
        memset(dp_r2l, 0, sizeof(dp_r2l));

        int sh = 0, em = 0;  // sheep count, empty space count

        // Left to right
        for (int i=0; i<N; i++) {
            if (i > 0) {
                dp_l2r[i] = dp_l2r[i-1];
            }

            if (S[i] == '*') {
                sh++;
            } else if (S[i] == '.') {
                em++;
                dp_l2r[i] += sh;  // sheep moves
            }
        }

        // Right to left
        sh = 0, em = 0;
        for (int i=N-1; i>=0; i--) {
            if (i < N-1) {
                dp_r2l[i] = dp_r2l[i+1];
            }

            if (S[i] == '*') {
                sh++;
            } else if (S[i] == '.') {
                em++;
                dp_r2l[i] += sh;  // sheep moves
            }
        }

        ll ans = -1;
        for (int i=0; i<N; i++) {
            // gather sheep at index i
            ll tmp = dp_l2r[i] + dp_r2l[i];
            if (ans == -1 || ans > tmp) {
                ans = tmp;
            }
        }

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */