//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <algorithm>
#include <vector>

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
        int K, N, M;
        cin >> K >> N >> M;
        int A[N], B[M];
        for (int i=0; i<N; i++)
            cin >> A[i];
        for (int i=0; i<M; i++)
            cin >> B[i];

        // Process
        bool isPossible = true;
        vector<int> ans;
        int i = 0, j = 0, lines = K; /* i = A index, j = B index */
        while (i < N && j < M) {
            /* First, add lines as much as possible */
            if (A[i] == 0) { /* A's add line cmd */
                lines++;
                ans.emplace_back(0);
                i++;
            } else if (B[j] == 0) { /* B's add line cmd */
                lines++;
                ans.emplace_back(0);
                j++;
            /* Second, execute the least line change cmd  as much as possible */
            } else {
                if (A[i] <= B[j]) { /* A's cmd is the least line */
                    if (A[i] > lines) { /* Check possible */
                        isPossible = false;
                        break;
                    } ans.emplace_back(A[i]);
                    i++;
                } else {
                    if (B[j] > lines) { /* B's cmd is the least line */
                        isPossible = false; /* Check possible */
                        break;
                    } ans.emplace_back(B[j]);
                    j++;
                }
            }
        }
        while (i < N) { /* while A's unused command remains */
            if (A[i] > lines) { /* Check possible */
                isPossible = false;
                break;
            } else if (A[i] == 0) { /* A's add line cmd */
                lines++;
            } ans.emplace_back(A[i++]);
        }
        while (j < M) { /* while B's unused command remains */
            if (B[j] > lines) { /* Check possible */
                isPossible = false;
                break;
            } else if (B[j] == 0) { /* B's add line cmd */
                lines++;
            } ans.emplace_back(B[j++]);
        }

        // Control : Output
        if (isPossible) {
            for (int cmd : ans) {
                cout << cmd << ' ';
            } cout << endl;
        } else {
            cout << -1 << endl;
        }
    }
}

// Helper Functions
/* None */