//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <map>
#include <set>
#include <vector>
#include <cstring>

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
        int N, K;
        cin >> N >> K;
        int A[N];
        for (int i=0; i<N; i++)
            cin >> A[i];

        // Process
        map<int,int> M; /* Count Frequencies */
        for (int i=0; i<N; i++) {
            M[A[i]]++;
        }

        set<int> t1; /* Type 1
                      *     = num with K or more frequencies
                      */
        map<int,vector<int>> t2; /* Type 2
                                  *     = num with less K frequencies
                                  *     -> save idx infos
                                  */
        int reds = 0, resids = 0;
        for (auto [k, v] : M) {
            if (v >= K) {
                reds++;
                t1.insert(k);
            } else {
                resids += v;
            }
        } resids /= K; /* Possible Color Count */

        for (int i=0; i<N; i++) { /* Save Type2 num idx infos */
            if (t1.find(A[i]) == t1.end()) {
                t2[A[i]].push_back(i);
            }
        }

        int B[N]; /* Color Array */
        memset(B, 0, sizeof(B)); /* Init array with no paint */

        /* Paint Type2 nums */
        int color = 1;
        for (auto [k, v] : t2) { /* k = num, v= Idx Array */
            if (resids == 0) break;
            for (int idx : v) {
                B[idx] = color++;
                if (color > K) {
                    resids--;
                    if (resids == 0) break;
                    color = 1;
                }
            }
        }

        /* Paint Type1 nums */
        for (int i=0; i<N; i++) {
            if (t1.find(A[i]) != t1.end()) {
                if (M[A[i]] > K) {
                    B[i] = 0;
                } else {
                    B[i] = M[A[i]];
                } M[A[i]]--;
            }
        }

        // Control : Output
        for (int i=0; i<N; i++) {
            cout << B[i] << ' ';
        } cout << endl;
    }
}

// Helper Functions
/* None */
