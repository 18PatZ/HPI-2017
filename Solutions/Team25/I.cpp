#include <iostream>
using namespace std;
int grid[1000][1000];
bool vis[1000][1000];
int x[8]={1, 1, 0, -1, -1, -1, 0, 1};
int y[8]={0, 1, 1, 1, 0, -1, -1, -1};
int n, m;
bool check=false;
void floodfill(int i, int j)
{
for (int k=0; k<8; k++)
    {
        if (i+y[k]<0 || i+y[k]>=n || j+x[k]<0 || j+x[k]>=m)
            continue;
        if (grid[i+y[k]][j+x[k]]<grid[i][j])
            continue;
        if (grid[i+y[k]][j+x[k]]>grid[i][j])
            {
                check=false;
                continue;
            }
        if (grid[i+y[k]][j+x[k]]==grid[i][j] && !vis[i+y[k]][j+x[k]])
        {
            vis[i+y[k]][j+x[k]]=true;
            floodfill(i+y[k], j+x[k]);
        }
    }
}
int main()
{
    int ans=0;
    cin >> n >> m;
    for (int i=0; i<n; i++)
    {
        for (int j=0; j<m; j++)
            cin >> grid[i][j];
    }
    for (int i=0; i<n; i++)
        for (int j=0; j<m; j++)
        if (!vis[i][j])
    {
        check=true;
                floodfill(i, j);
                if (check) ans++;
    }
    /*bool eq=false;
    bool gr=false;
    for (int i=0; i<n; i++)
        for (int j=0; j<m; j++)
    {
        eq=false;
        gr=false;
        for (int k=0; k<8; k++)
        {
            if (i+y[k]<0 || i+y[k]>=n || j+x[k]<0 || j+x[k]>=m)
            {
                continue;
            }
            if (grid[i+y[k]][j+x[k]]>grid[i][j])
            {
                gr=true;
            }
            if (grid[i+y[k]][j+x[k]]==grid[i][j])
            {
                eq=true;
            }
        }
        if (!gr && !eq)
        {
            ans++;
        }
        else if (!gr)
            grid[i][j]--;
    }*/
    cout << ans << endl;

}