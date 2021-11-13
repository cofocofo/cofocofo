//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <vector>

using namespace std;

#define endl '\n'

// Set up : Global Variables
typedef long long ll;
const int INF = 987654321;

// Set up : Functions Declaration
ll getMoveCount(ll v, string n);


int main()
{
    // Set up : I/O
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // Process
    vector<ll> V;
    ll ofs = 1;
    do {
        V.push_back(ofs);
        ofs *= 2;
        if (ofs >= (ll)(1e18)) break;
    } while (true);

    // Set up : Input
    int TC; cin >> TC;

    while (TC--) {
        string N; cin >> N;

        // Process
        ll cnt = INF;
        for (ll v : V) {
            cnt = min(cnt, getMoveCount(v, N));
        }

        // Control : Output
        cout << cnt << endl;
    }
}

// Helper Functions
ll getMoveCount(ll v, string n)
{
    ll cnt = 0;
    string s = to_string(v);

    int j = 0;
    for (char c : n) {
        if (c == s[j]) j++;
    }

    ll del = n.length() - j;
    ll add = s.length() - j;

    return del + add;
}

// 1000000000 - 10
// 1

// j = 1