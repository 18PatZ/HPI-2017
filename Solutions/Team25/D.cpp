#include <iostream>
#include <fstream>
using namespace std;
int m, n;
int y[8]={0, 1, 1, 1, 0, -1, -1, -1};
int x[8]={1, 1, 0, -1, -1, -1, 0, 1};
int comp[1000][1000];
char grid[1000][1000];
int sizes[1000];
void floodfill(int i, int j, int num)
{
    for (int k=0; k<8; k++)
    {
        if (i+y[k]<0 || i+y[k]>=n || j+x[k]<0 || j+x[k]>=m)
            continue;
        if (grid[i+y[k]][j+x[k]]=='.')
            continue;
        if (comp[i+y[k]][j+x[k]]==0)
        {
            comp[i+y[k]][j+x[k]]=num;
            sizes[num]++;
            floodfill(i+y[k], j+x[k], num);
        }
    }
}
int main()
{
    cin >> m >> n;
    int numcomps=0;
    for (int i=0; i<n; i++)
        for (int j=0; j<m; j++)
        cin >> grid[i][j];
    for (int i=0; i<n; i++)
        for (int j=0; j<m; j++)
    {
        if (grid[i][j]=='.') continue;
        if (comp[i][j]==0)
        {
            numcomps++;
            comp[i][j]=numcomps;
            sizes[numcomps]++;
            floodfill(i, j, numcomps);
        }
    }
    cout << numcomps << endl;
    sort(sizes+1, sizes+numcomps+1);
    for (int i=numcomps; i>=1; i--)
        cout << sizes[i] << endl;
    /*for (int i=0; i<n; i++)
    {for (int j=0; j<m; j++)
        cout << comp[i][j];
        cout << endl;
    }*/
}