//round robin scheduling algorithm
package ospractical;
import java.util.Scanner;
class RoundRobinAlgorithm
{
	int numberOfProcess,timeQuantum,totalComputingTime;
	int[]brustTime,remainingTime,turnAroundTime,waitingTime;
	double avgWaitingtime,avgTurnAroundTime;
	public void input(Scanner sc)   //input the no.of process and brusttime
	{
		System.out.print("Enter number of processes = ");
		numberOfProcess=sc.nextInt();  //input of number of processes
		brustTime=new int[numberOfProcess];
		remainingTime=new int[numberOfProcess];
		waitingTime=new int[numberOfProcess];
		turnAroundTime=new int[numberOfProcess];
		System.out.println("Enter the processing time for each processes: ");
		for (int i=0; i<numberOfProcess ; i++)  //taking input of brust or processing time add asigning to remaining time
		{
			System.out.print("Brust time of process " +i +" = ");
			brustTime[i]=sc.nextInt();
			remainingTime[i]=brustTime[i];
		}
		System.out.println("Enter the time quantum for the Algorithm = ");
		timeQuantum=sc.nextInt();
	}
	public void calculateResult()
	{
		int count=0,i=0;                      //count:it will count the number of processes having 0 remaining time
		totalComputingTime=0;                 //i:it is count the number of cycle of executing the processes
		while(true)
		{
			if(remainingTime[i]==0)   //case1:remaining time =0 then simply increase count and i by 1.
			{
				count+=1;
				if(count==numberOfProcess)
				break;
				i++;
				if(i==numberOfProcess) 
					i=0;
				continue;
				
			}
			else if(remainingTime[i]<=timeQuantum)//case 2:rt <=time quantum then tct=rt,rt=0
			{
				totalComputingTime += remainingTime[i];
				remainingTime[i]=0;
			}
			else                  //case 3: if rt>time quantum,tct= tct+timequantum ,  rt= rt-tq.
			{
				totalComputingTime += timeQuantum;
				remainingTime[i] -= timeQuantum;
			}
			turnAroundTime[i]=totalComputingTime;
			waitingTime[i]=turnAroundTime[i]-brustTime[i];
			i++;
			if(i==numberOfProcess)
			{
				i=0;
				count=0;
			}
		}
		count=0;
		System.out.println("Turnaoundtime of the processes are --");
		for(int k:turnAroundTime)
		{
			System.out.println("p"+(count++)+" = "+ k);
		}
		count=0;
		System.out.println("Waiting time of the processes are --");
		for(int k:waitingTime)
		{
			System.out.println("p"+(count++)+" = "+ k);
		}
	}
	public void showResult()
	{
		//calculate average turn around time and average waiting time
		double sum=0;
		for(int t:waitingTime)
		{
			
			sum+=t;
		}
		avgWaitingtime=sum/numberOfProcess;
		System.out.println("Average waiting time = "+avgWaitingtime);
		
		//calculate average turn aroundtime
		
		sum=0;
		for(int t:turnAroundTime)
		{
			sum+=t;
		}
		avgTurnAroundTime=sum/numberOfProcess;
		System.out.println("Average turn around time = "+avgTurnAroundTime);
		
	}
	
}

public class RoundRobin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		RoundRobinAlgorithm rRT = new RoundRobinAlgorithm();
		rRT.input(sc);
		rRT.calculateResult();
		rRT.showResult();
	}

}

