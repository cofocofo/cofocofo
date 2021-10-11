//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <regex>
#include <map>

using namespace std;

#define endl '\n'

// Set up : Global Variables
regex re1(":=");
regex re2("[=+]");

// Set up : Functions Declaration
void trim(string &s);


int main()
{
    // Set up : I/O
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // Set up : Input
    int TC; cin >> TC;

    string L;
    while (TC--) {
        int N; cin >> N;
        cin.ignore();

        string last;
        map<string,string> M;
        for (int i=0; i<N; i++) {
            getline(cin, L);

            // Process
            if (L.find(":=") != string::npos) {
                auto itr = sregex_token_iterator(L.begin(), L.end(), re1, -1);
                string name = *(itr++);
                string value = *(itr++);
                trim(name);
                trim(value);
                M[name] = value;
                last = name;
            } else {
                auto itr = sregex_token_iterator(L.begin(), L.end(), re2, -1);
                string n1 = *(itr++);
                string n2 = *(itr++);
                string n3 = *(itr++);
                trim(n1);
                trim(n2);
                trim(n3);
                M[n1] = M[n2] + M[n3];
                last = n1;
            }
        }

        string s = M[last];
        long long ans = 0;
        size_t pos = 0;
        while ((pos = s.find("haha", pos)) != string::npos) {
            ans++;
            pos += 2;
        }

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
void trim(string &s)
{
    s.erase(remove_if(s.begin(), s.end(), [](char c) {
        return !isalpha(c);
    }), s.end());
}