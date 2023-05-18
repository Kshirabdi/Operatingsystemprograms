/*FCFS algorithm
*written by:Kshirabdi
*date:9-4-2023*/

package ospractical;

import java.util.Scanner;
public class FCFSAlgorithm
{
    public static void main(String  arg[])
    {
        int numberOfProcess,arivalTime[],waitingTime[],turnAroundTime[],totalComputationTime[],brustTime[];
        float averageWaitingTime=0f,averageTurnAroundTime=0f;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of process you want to execute=");
        numberOfProcess=sc.nextInt();
        arivalTime=new int[numberOfProcess];
        brustTime=new int[numberOfProcess];
        waitingTime=new int[numberOfProcess];
        turnAroundTime=new int[numberOfProcess];
        totalComputationTime=new int[numberOfProcess+1];
        
    
        for(int i=0;i<numberOfProcess;i++)
        {
            System.out.print("enter the arival time of process - "+(i+1)+ " = ");
            arivalTime[i]=sc.nextInt();
            System.out.print("enter the brust/execution time of process - "+(i+1)+ " = ");
            brustTime[i]=sc.nextInt();
        }
         totalComputationTime[0]=0;
        System.out.println("Process name   Arival Time   Brust Time   Waiting Time   Turn Around Time");
        System.out.println("___________________________________________________________________________________");
        for(int i=0;i<numberOfProcess;i++)
        {
            totalComputationTime[i+1]=totalComputationTime[i]+brustTime[i];
            waitingTime[i]=totalComputationTime[i]-arivalTime[i];
            turnAroundTime[i]=waitingTime[i]+brustTime[i];
            System.out.println("  P"+(i+1)+"\t\t  "+arivalTime[i]+"              "+brustTime[i]+"           "+waitingTime[i]+"               "+turnAroundTime[i]);
            averageWaitingTime+=waitingTime[i];
            averageTurnAroundTime+=turnAroundTime[i];
        }
        averageWaitingTime/=numberOfProcess;
        averageTurnAroundTime/=numberOfProcess;
        System.out.println("average waiting time of the processor = "+averageWaitingTime);
        System.out.println("average turn around time of the processor = "+averageTurnAroundTime);
        sc.close();
        
    }
}