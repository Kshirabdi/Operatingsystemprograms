// SJF (non-preemptive) schduling algorithm
//written by:kshirabdi
//date:30-05-2023
package ospractical;

import java.util.Scanner;

public class SJFAlgorithm {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int numberOfProcess,totalComputingTime=0;
		double avgWaitingtime = 0,avgTurnAroundTime=0;
		System.out.print("Enter number of processes = ");
		numberOfProcess=sc.nextInt();  //input of number of processes
		int ar[][]=new int[numberOfProcess][5];
		System.out.println("Enter the processing time for each processes: ");
			for (int i=0; i<numberOfProcess ; i++)  //taking input of brust or processing time add asigning to remaining time
			{
				
				System.out.print("Brust time of process P" +(i+1) +" = ");
				for(int j=0;j< 4 ;j++)
				{
					
					//brustTime[i]=sc.nextInt();
					if(j==0)
					{
						ar[i][j]= i+1 ;
	
					}
					if(j==1)
					{
						ar[i][j]=sc.nextInt();
					}
					
					
				}
				
			}

			 
			
				
			//short the process based on the burst time
				
			for(int i=0;i< (numberOfProcess - 1);i++)
			{
				for(int j=0;j < numberOfProcess-1-i;j++)
				{
					if(ar[j][1]>ar[j+1][1])
					{
						int temp=ar[j][1];
						ar[j][1]=ar[j+1][1];
						ar[j+1][1]=temp;
						
						temp = ar[j][0];
						ar[j][0]=ar[j+1][0];
						ar[j+1][0]=temp;
				    }
				}
			}
			
			totalComputingTime=0;

		    System.out.println("Process name   Brust Time   Turn Around Time   Waiting Time");
		    System.out.println("                             ( TCT - AT )       (TAT - BT)");
		    System.out.println("____________   __________   ________________   ____________");
		    
		    for(int i=0;i<numberOfProcess;i++)
		    {
		    	totalComputingTime=totalComputingTime+ar[i][1];
			    ar[i][2]=totalComputingTime - 0;//turn around time
			    ar[i][3]=ar[i][2] - ar[i][1]; //waitingtime4  
		    	System.out.println("P"+ar[i][0] +"              "+ ar[i][1]+"            "+totalComputingTime +"-"+ 0+ "="+ar[i][2]+"               "+ar[i][2]+ " - "+ ar[i][1]+"="+ar[i][3]);
		    	avgWaitingtime += ar[i][3];
			    avgTurnAroundTime +=  ar[i][2];
		    	
		    }
		    avgWaitingtime/=numberOfProcess;
		    avgTurnAroundTime/=numberOfProcess;
		    System.out.println("average waiting time of the processor = "+avgWaitingtime);
		    System.out.println("average turn around time of the processor = "+avgTurnAroundTime);
		    sc.close();
			

			
				
	}


}



