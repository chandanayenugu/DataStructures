

import java.util.*;

public class Graph{
	
	public static int count=0;
	public static int[] dist=new int[23];
	public static int[] v=new int[23];
	public static int[] root=new int[23];
	public static int[] calcdist=new int[23];
	public static int graph_len;
	
	
	void dijkstraalgo(int adjgraph[][], int r, int k)
	{
		int l=0;
		dist[l]=0;
		l++;
		for(int i = 1;i<adjgraph[0].length;i++)
		{			
			if(adjgraph[r][i]!=0)
			{
			dist[l]=adjgraph[r][i]+k;
				if(dist[l]==0)
				{
					dist[l]=Integer.MAX_VALUE;
							}
			}
				l++;
				
			
		}
		
		int s=0;
		for (int t=0;t<graph_len;t++)
		{
			if(dist[s]<calcdist[t])
			{
			calcdist[t]=dist[s];
			root[t]=r;
			}
			s++;
		}
	
		Graph a = new Graph();
		int[] indexdist=a.mindist(calcdist,r);
		if(a.count!=graph_len-1)
		{
		a.dijkstraalgo(adjgraph,indexdist[0],indexdist[1]);
		}
		
	}
	
			int[] mindist(int calc_dist[], int row)
			{
				int[] index = new int [2];
				
				int minimumval=Integer.MAX_VALUE;
				int nextval=1;
				
				for (int n = 1; n<graph_len;n++)
				{
					if (minimumval>calc_dist[n]&&v[n]==0)
					{
						minimumval=calc_dist[n];
						nextval=n;
					
					}
				}
			
			v[nextval]=minimumval;
			
			System.out.println("Vertex Distancefrom  source");
			for(int y=0;y<graph_len;y++)
			{
			
			System.out.println(y+"	      "+v[y]+"      "+root[y]);
			}
			System.out.println("----------------------------------------------");
				
			index[0]=nextval;
			index[1]=minimumval;
			Graph a = new Graph();
			a.count++;
			return index;
			
			}
			public static void main (String args[])
			{
				for(int w=0;w<23;w++)
				{
					calcdist[w]=Integer.MAX_VALUE;
				}
				
				for(int h=0;h<23;h++)
				{
					dist[h]=Integer.MAX_VALUE;
				}
				
				int adjmatrix[][] = new int [][] {
					{0,2,0,1,0,0,0,0,3,0,0},
					{2,0,0,0,0,0,0,3,0,0,7},
					{0,0,0,6,0,2,0,1,0,0,0},
					{1,0,5,0,2,0,0,0,0,0,0},
					{0,0,0,2,0,0,0,0,7,4,0},
					{0,0,2,0,0,0,7,0,0,6,0},
					{0,0,0,0,0,7,0,0,0,0,5},
					{0,3,1,0,0,0,0,0,0,0,4},
					{3,0,0,0,7,0,0,0,0,0,0},
					{0,0,0,0,4,6,0,0,0,0,0},
					{0,7,0,0,0,0,5,4,0,0,0}
							
				};
					
					for (int i=0;i<adjmatrix.length;i++)
					{
						for (int j=0;j<adjmatrix[0].length;j++)
						{
							System.out.print(adjmatrix[i][j]+" ");
						}
						System.out.println("\n");
					}
				
					graph_len=adjmatrix.length;
					
					
					Graph a = new Graph();
					a.dijkstraalgo(adjmatrix,0,0);
					}
			
		}
	


