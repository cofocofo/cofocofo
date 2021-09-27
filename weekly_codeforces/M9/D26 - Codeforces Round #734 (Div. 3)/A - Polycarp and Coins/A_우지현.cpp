#include <iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;
	cin >> T;


	while (T--) {
		int n;
		cin >> n;

		int cntOne = n / 3;
		int cntTwo = n / 3;

		if (n % 3 == 2) cntTwo++;
		else if (n % 3 == 1) cntOne++;


		cout << cntOne << " " << cntTwo << "\n";
	}

	return 0;
}