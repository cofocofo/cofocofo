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

using namespace std;

#define endl '\n'
#define len(x) (int)(x).length()
#define size(x) (int)(x).size()

// Set up : Global Variables
const int MAX = 100;
int A[MAX];
int D[MAX];

// Set up : Functions Declaration
void f(int s, int e, int d);


int main()
{
    // Set up : I/O
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // Set up : Input
    int t; cin >> t;

    while (t--) {
        int n; cin >> n;
        for (int i=0; i<n; i++)
            cin >> A[i];

        // Process
        memset(D, 0, sizeof(D));

        f(0, n, 0);

        // Control : Output
        for (int i=0; i<n; i++) {
            cout << D[i] << ' ';
        } cout << endl;
    }
}

// Helper Functions
void f(int s, int e, int d)
{
    if (s == e) return;

    int idx = distance(A, max_element(A+s, A+e));
    D[idx] = d;

    f(s, idx, d+1);
    f(idx+1, e, d+1);
}
