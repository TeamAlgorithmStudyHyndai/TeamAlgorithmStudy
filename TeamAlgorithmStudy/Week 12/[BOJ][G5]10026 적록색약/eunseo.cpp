#include<iostream>
#include<algorithm>
using namespace std;

int n;
char rgb[101][101];
bool visit[101][101]={false};
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
void find(int x, int y) {
	visit[x][y] = true;
	for (int i = 0; i < 4l; i++) {
		int xx = x + dx[i];
		int yy = y + dy[i];
		if (xx >= n || xx < 0 || yy >= n || yy < 0) continue;
		if (rgb[x][y] == rgb[xx][yy] && visit[xx][yy] == false) find(xx, yy);
	}
}

int main() {
	int a, b;
	cin >> n;
	a = 0; b = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++)
			cin >> rgb[i][j];
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (visit[i][j] == false) {
				find(i, j);
				a++;
			}
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (rgb[i][j] == 'G') rgb[i][j] = 'R';
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			visit[i][j] = false;
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (visit[i][j] == false) {
				find(i, j);
				b++;
			}
		}
	}
	cout << a << " " << b;

}
