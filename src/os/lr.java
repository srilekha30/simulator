package os;




import java.util.Scanner;
public class lr {
	public static int lru(int numberOfPageRequests,int frameSize,int referenceString[], int table[][]){
	
		int i,j,pageFaults=0,isPresent,z,timer=0,minValue,minIndex;
	       
	       
        int timeArray[]=new int[10];

   
        for(i=0;i<10;i++)
            timeArray[i]=-1;
       
        z=0;
        int frame[]=new int[frameSize];
        int p;
        for(i=0;i<numberOfPageRequests;i++){
            isPresent=0;
            timer++;
            if(z<frameSize){
                for(j=0;j<z;j++)
                    if(referenceString[i]==frame[j])
                        isPresent=1;
                if(isPresent==1)
                    timeArray[referenceString[i]]=timer;
                else{
                    pageFaults++;
                    frame[z++]=referenceString[i];
                    timeArray[referenceString[i]]=timer;
                }
            }
            else{
                for(j=0;j<frameSize;j++)
                    if(referenceString[i]==frame[j])
                        isPresent=1;
                if(isPresent==1)
                    timeArray[referenceString[i]]=timer;
                else{
                    pageFaults++;
                    j=0;
                    
                    minValue=timeArray[frame[0]];
                    minIndex=0;
                    
    
                    for(j=0;j<frameSize;j++){
                        if(timeArray[frame[j]]<minValue){
                            minValue=timeArray[frame[j]];
                            minIndex=j;
                        }
                    }
                    frame[minIndex]=referenceString[i];
                    timeArray[referenceString[i]]=timer;
                }
            }
            for (p=0;p<frameSize;p++) {
            	table[i][p]=frame[p];
            }
        }
        return pageFaults;
	}
}