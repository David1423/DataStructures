#include <stdio.h>
#include <stdlib.h>

int main() {
	// your code goes here
	int* buffer;
	int num;
	int size;
	printf("\n\n------------- BUBBLE SORT ------------- \nEnter the No. of elements  \n");
	
	scanf("%d",&size);
	
	//Dynamicay Allocate memory uisng Continous-Memory-allocation(calloc()) technique
	buffer=(int*)calloc(size,sizeof(int));
	
	printf("Enter the %d elements to the array\n",size);
	
	for(int i=0;i<size;i++){
	    scanf("%d",&num);
	    buffer[i]=num;
	}
	
	
	printf("\nThe Following lines with numbers in < > braces are to be swapped at that instance \n");
	
	//bubble sort
	
	for(int i=0;i<size;i++){
		for(int j=0;j<size-i-1;j++){
			
			//swap if the 1st element is greater than 2nd element
			if(buffer[j]>buffer[j+1]){
			
			
			//printing the the swapping stages of the array
			for(int k=0;k<size;k++){
					if(k==j){
						printf(" <%d ",buffer[k]);
					}
					else if(k==(j+1)){
						printf(" %d> ",buffer[k]);
					}
					else{
	   				 printf(" %d ",buffer[k]);
					}
				}
				printf("\n\n");
			
				int temp = buffer[j];
				buffer[j]=buffer[j+1];
				buffer[j+1]=temp;
				
				
			}//if
		}//inner for loop
	}//outer for-loop
	
	/*for(int i=0;i<10;i++){
	    for(int j=0;j<10;j++){
	        
	        //check for the greater number
	        if(buffer[j]<buffer[i]){
	            
	            //swapping
	            int temp = buffer[j];
	            buffer[j]=buffer[i];
	            buffer[i]=temp;
	        }// if 
	   }//inner for-loop
	}//outer for-loop
	*/
	printf("The sorted array is: \n");
	for(int i=0;i<size;i++){
	    printf("%d ",buffer[i]);
	}
	printf("\n");
	
	return 0;
}
