//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <algorithm>

using namespace std;

#define endl '\n'

// Set up : Global Variables
const int INF = 2000000000;

// Set up : Functions Declaration
/* None */


int main()
{
    // Set up : I/O
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // Set up : Input
    int TC; cin >> TC;

    while (TC--) {
        int N, K;
        cin >> N >> K;
        int A[K], T[K];
        for (int i=0; i<K; i++)
            cin >> A[i];
        for (int i=0; i<K; i++)
            cin >> T[i];

        // Process
        int L[N+1], R[N+1];
        fill(L, L+(N+1), INF); /* Left to Right */
        fill(R, R+(N+1), INF); /* Right to Left */

        /* Set Air Conditioners Temperature */
        for (int i=0; i<K; i++) {
            int idx = A[i], temp = T[i];
            L[idx] = R[idx] = temp;
        }

        /* Left to Right
         * 0 1 2 3 4 5
         * I 7 I I 5 I
         * I
         * I 7
         * I 7 8
         * I 7 8 9
         * I 7 8 9 5
         * I 7 8 9 5 6 */
        for (int i=2; i<=N; i++) {
            L[i] = min(L[i-1]+1, L[i]);
        }

        /* Right to Left
         * 0 1 2 3 4 5
         * I 7 I I 5 I
         *           I
         *         5 I
         *       6 5 I
         *     7 6 5 I
         *   7 7 6 5 I
         * 8 7 7 6 5 I */
        for (int i=N-1; i>=1; i--) {
            R[i] = min(R[i+1]+1, R[i]);
        }

        // Control : Output
        for (int i=1; i<=N; i++) {
            cout << min(L[i], R[i]) << ' ';
        } cout << endl;
    }
}

// Helper Functions
/* None */