package practiceCN;
import java.util.*;
public class MaxSqMatrixWith0 {
	public static int findMaxSquareWithAllZeros(int[][] input){
	      int dp[][]=new int[input.length][input[0].length];
	   
	      int i=0,j=0;
	      int max=0;
	      for(i=0;i<input[0].length;i++)
	      {
	        if(input[0][i]==0){
	          dp[0][i]=1;
	          max=1;
	        }
	        if(input[0][i]==1)
	          dp[0][i]=0;
	      }
	      
	      for(j=0;j<input.length;j++)
	      {
	        if(input[j][0]==0){
	          dp[j][0]=1;
	          max=1;
	        }
	        if(input[j][0]==1)
	          dp[j][0]=0;
	      }
			
	      
	  

	      for(int k=1;k<input.length;k++)
	      {
	        for(int l=1;l<input[0].length;l++)
	        {
	          if(input[k][l]==1)
	            dp[k][l]=0;
	          else if(input[k][l]==0)
	          {
	            dp[k][l]=Math.min(dp[k-1][l-1],Math.min(dp[k][l-1],dp[k-1][l]))+1;
	            if(dp[k][l]>max)
	              max=dp[k][l]; 
	          }
	        }
	      }
	      
	      return max;

		}


	public static void main(String[] args) {
		int n=0,m=0;
		Scanner s =new Scanner(System.in);
		System.out.println("Enter the rows and columns");
		n=s.nextInt();
		m=s.nextInt();
		int arr[][]=new int[n][m];
		System.out.println("Enter the elements of the array i.e only zeroes and ones");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				arr[i][j]=s.nextInt();
			}
		}
		
		System.out.println("The size of maximum square matrix with all zeroes is: "+ findMaxSquareWithAllZeros(arr));
		
		
	}

}
