import java.util.*;
import java.io.*;
public class tilt {
	public static void main(String[] args) throws Exception {

		Scanner sc=new Scanner(System.in);
		String path1="C:\\Users\\tejas\\OneDrive\\Desktop\\pro\\input.txt";
		String path2="C:\\Users\\tejas\\Onedrive\\Desktop\\pro\\output_file.txt";

		 FileReader file=new FileReader(path1);
		 BufferedReader bf=new BufferedReader(file);
		 FileWriter output=new FileWriter(path2,true);
		 BufferedWriter bw=new BufferedWriter(output);
		
		int price[]=new int [10];
		String goods[]=new String[10];
		String st=bf.readLine();
		
		for(int a=0;a<10;a++)
		{  
			if((st=bf.readLine())!=null){
			StringTokenizer stn=new StringTokenizer(st,":");
			String s1=stn.nextToken();
			//System.out.println(s1);
			int p1=Integer.parseInt(stn.nextToken());
			//System.out.println(p1);
			goods[a]=s1;
			price[a]=p1;
			}
			
		}
		arrange(price,goods);	
		System.out.println("Enter number of Employees");
		int n=sc.nextInt();	
		int val=find(price,n);
		bw.write("Enter number of Employees "+Integer.toString(n));
		bw.newLine();
		bw.write("goods selected for distribution :");
		bw.newLine();
		for(int b=val;b<val+n;b++)
		{
			bw.write(goods[b]+":");
			String str1=Integer.toString(price[b]);
			bw.write(str1);
			bw.newLine();		
		}
		int d=price[val+n-1]-price[val];
		bw.write("And the diffrent between the chosen goodie with highest price and the lowest price is "+Integer.toString(d));
		bw.close();	
	}
	private static int find(int[] price,int n) {
		int b=Integer.MAX_VALUE;
		int pos=-1;
		for(int i=0;i<price.length-n+1;i++)
		{
			int n1=price[i+n-1]-price[i];
			if(b>n1)
			{
				pos=i;
				b=n1;
			}
		}
		return pos;
	}
    private static void arrange(int[] price, String[] goods) {
		int n=price.length;
		for(int i=0;i<n-1;i++)
		{
			int min_idx=i;
			for(int j=i+1;j<n;j++)
			  if(price[j]<price[min_idx])
				  min_idx=j;		
			int temp=price[min_idx];
			price[min_idx]=price[i];
			price[i]=temp;
			
			String temp1=goods[min_idx];
			goods[min_idx]=goods[i];
			goods[i]=temp1;
			
		}
	}
	

}
