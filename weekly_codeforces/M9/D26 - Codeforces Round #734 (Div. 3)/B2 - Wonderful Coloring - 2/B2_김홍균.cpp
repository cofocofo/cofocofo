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
        map<int,int> M;
        for (int i=0; i<N; i++) {
            M[A[i]]++;
        }

        set<int> t1;
        map<int,vector<int>> t2;
        int cnt_1 = 0, cnt_2 = 0;
        for (auto [k, v] : M) {
            if (v >= K) {
                cnt_1++;
                t1.insert(k);
            } else {
                cnt_2 += v;
            }
        } cnt_2 /= K;

        for (int i=0; i<N; i++) {
            if (t1.find(A[i]) == t1.end()) {
                t2[A[i]].push_back(i);
            }
        }

        int B[N];
        memset(B, 0, sizeof(B));
        int color = 1;
        for (auto [k, v] : t2) {
            if (cnt_2 == 0) break;
            for (int idx : v) {
                B[idx] = color++;
                if (color > K) {
                    cnt_2--;
                    color = 1;
                    if (cnt_2 == 0) break;
                }
            }
        }

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

// 3 1 4 1 5 9 2 6 5 3 5 8 9
// 0 0 1 1 0 0 1 1 0 1 1 1 1
// 0 0 1 1 0 1 1 1 0 1 1 1 0
//

// 3 3 1 2 3 4
// 1 2 3 1 2 3

// 1
// 5 3
// 1 1 1 2 2
// 3 2 1 1 2 -> Error!