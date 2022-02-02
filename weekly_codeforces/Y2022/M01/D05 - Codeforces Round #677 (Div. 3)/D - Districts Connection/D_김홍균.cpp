//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

#define endl '\n'
#define len(x) (int)(x).length()
#define size(x) (int)(x).size()
#define str(x) to_string(x)
#define error logic_error("line " + str(__LINE__))

// Set up : Definitions
typedef long long ll;
typedef pair<int,int> Road;
const int MAX = 5000;

// Set up : Global Variables
int P[MAX+1];
int R[MAX+1];

// Set up : Functions Declaration
int find(int x);
void merge(int x, int y);


int main()
{
    // Set up : I/O
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // Set up : Input
    int t; cin >> t;

    while (t--) {
        int n; cin >> n;
        int A[n+1];
        for (int i=1; i<=n; i++)
            cin >> A[i];

        // Process
        for (int i=1; i<=n; i++) {
            P[i] = i;
            R[i] = 1;
        }

        queue<Road> que;
        for (int i=1; i<=n; i++) {
            for (int j=i+1; j<=n; j++) {
                if (A[i] != A[j]) {
                    que.push({i, j});
                }
            }
        }

        int cnt = 0;
        queue<Road> ans;
        while (not(que.empty()) && cnt < n-1) {
            auto [x, y] = que.front();
            que.pop();

            if (find(x) != find(y)) {
                merge(x, y);
                cnt++;
                ans.push({x, y});
            }
        }

        // Control : Output
        if (cnt < n-1)
            cout << "NO" << endl;

        else if (cnt == n-1) {
            cout << "YES" << endl;
            while (not(ans.empty())) {
                auto [x, y] = ans.front();
                ans.pop();

                cout << x << ' ' << y << endl;
            }
        }
    }
}

// Helper Functions
int find(int x)
{
    if (P[x] == x) return x;
    return P[x] = find(P[x]);
}

void merge(int x, int y)
{
    x = find(x);
    y = find(y);
    if (x == y) return;

    if (R[x] < R[y]) { swap(x, y); }

    P[y] = x;

    if (R[x] == R[y]) { R[x]++; }
}
