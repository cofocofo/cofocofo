//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <map>
#include <queue>

using namespace std;

#define endl '\n'
#define size(x) (int)x.size()

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
        int n; cin >> n;
        int A[n];
        for (int i=0; i<n; i++)
            cin >> A[i];

        // Process
        map<int,int> M;
        /* Count numbers */
        for (int i=0; i<n; i++) {
            M[A[i]]++;
        }

        /* Add counts to priority queue */
        priority_queue<int> pq;
        for (auto [k, v] : M) {
            pq.push(v);
        }

        int ans = n;
        while (size(pq) >= 2) {
            int a = pq.top(); pq.pop();  /* Top1 residual count */
            int b = pq.top(); pq.pop();  /* Top2 residual count */

            /* Matching */
            if (a > 0 && b > 0) {
                ans -= 2;
                /* Subtract counts */
                if (a-1 > 0) { pq.push(a-1); }
                if (b-1 > 0) { pq.push(b-1); }
            }
        }

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */
