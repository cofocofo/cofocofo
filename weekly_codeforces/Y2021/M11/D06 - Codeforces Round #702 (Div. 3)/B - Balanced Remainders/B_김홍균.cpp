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

        // Process
        int C[3] = {0, };
        for (int a : A) {
            C[a%3]++;
        }

        int ans = 0, avg = n/3;
        for (int i=0; i<3; i++) {
            int &c = C[i];
            int &o1 = C[(i+1)%3];
            int &o2 = C[(i+2)%3];

            if (c > avg && o1 < avg) {
                int v1 = min(c-avg, avg-o1);
                c -= v1, o1 += v1;
                ans += v1;
            }

            if (c > avg && o2 < avg) {
                int v2 = min(c-avg, avg-o2);
                c -= v2, o2 += v2;
                ans += 2*v2;
            }
        }

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */
