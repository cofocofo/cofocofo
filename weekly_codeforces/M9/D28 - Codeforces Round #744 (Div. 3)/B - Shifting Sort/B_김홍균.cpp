//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
#include <tuple>

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

    while (TC--) {
        int N; cin >> N;
        int A[N];
        for (int i=0; i<N; i++)
            cin >> A[i];

        // Process
        int B[N];
        memcpy(B, A, sizeof(A)); /* Copy from A to B */
        sort(B, B+N); /* Sort B */

        int T[N]; /* Temp Array */
        vector<tuple<int,int,int>> V;
        /* make A -> B */
        for (int i=0; i<N; i++) {
            if (A[i] != B[i]) {
                int idx = find(A+i, A+N, B[i]) - A;
                int l = i, r = idx; /* a[l...r] */

                memcpy(T, A, sizeof(A)); /* Copy from A to T */
                T[l] = A[r]; /* Shifting */
                for (int j=l; j<r; j++) {
                    T[j+1] = A[j];
                } memcpy(A, T, sizeof(T)); /* Copy from T to A */

                V.emplace_back(l+1, r+1, r-l); /* Save cmd */
            }
        }

        // Control : Output
        cout << V.size() << endl;
        for (auto [l, r, d] : V) { /* C++17 Decomposition */
            cout << l << ' ' << r << ' ' << d << endl;
        }
    }
}

// Helper Functions
/* None */