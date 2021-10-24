//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <algorithm>
#include <numeric>

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
        int B[N+2];
        for (int i=0; i<N+2; i++)
            cin >> B[i];

        // Process
        sort(B, B+(N+2));
        ll sum_B = accumulate(B, B+(N+2), (ll)0);  // sum_A + sum_A + x

        int A[N];
        bool isPossible = false;
        for (int i=0; i<N+2; i++) {
            // if x = B[i]
            if ((sum_B - B[i]) % 2 == 0) {
                ll sum_A = (sum_B - B[i]) / 2;

                if (sum_A == B[N+1]) {
                    if (i == N+1) continue;
                    isPossible = true;

                    int idx = 0;
                    for (int j=0; j<N+2; j++) {
                        if (j == i || j == N+1) continue;
                        A[idx++] = B[j];
                    } break;
                } else if (sum_A == B[N]) {
                    if (i == N) continue;
                    isPossible = true;

                    int idx = 0;
                    for (int j=0; j<N+2; j++) {
                        if (j == i || j == N) continue;
                        A[idx++] = B[j];
                    } break;
                }
            }
        }

        // Control : Output
        if (isPossible) {
            for (int i=0; i<N; i++) {
                cout << A[i] << ' ';
            } cout << endl;
        } else {
            cout << -1 << endl;
        }
    }
}

// Helper Functions
/* None */
