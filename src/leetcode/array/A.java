package leetcode.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * 最长上升子序列
 * @author jieai706
 * @date 2020-01-19
 */
public class A {

	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext())
		{
			int n=cin.nextInt();
			int num[]=new int[n+1];
			int maxlen[]=new int[n+1];
			for(int i=1;i<=n;i++)
			{
				num[i]=cin.nextInt();
				maxlen[i]=1;
			}
			for(int j=1;j<=n;++j)
			{
				for(int k=j+1;k<=n;++k)
				{
					if(num[k]>num[j])
					{
						maxlen[k]=Math.max(maxlen[k], maxlen[j]+1);
					}
				}
			}
			Arrays.sort(maxlen);
			System.out.println(maxlen[n]);
		}
	}
}
