#include<stdio.h>
#include<stdlib.h>

//Functions Declarations
void insertionSort(int* array, int size);
void moveElementsToRight(int* array, int i, int j);

int main(){

	//Insertion Sorting
	
	int* array;
	int size;
	
	printf("----------INSERTION SORT----------\nEnter the size of array to be allocated :: ");
	
	//get array size 
	scanf("%d",&size);
	
	if(size==0 || size<0){
		printf("\nSize is not allowed, Size should be greater than 0\n");
		return 0;
	}
	
	//Dynamically allocate memory (malloc())
	array = (int*)malloc(size*sizeof(int));
	
	//store elements into array
	for(int i=0;i<size;i++){
		scanf("%d" , &array[i]);
	}
	
	if(size == 1){
		printf("%d",array[0]);
		return 0;
	}
	else{
	insertionSort(array,size);
	}
	
	//print Sorted Elements
	printf("\nElements after sorting :: \n");
	
	for(int i=0;i<size;i++){
		printf(" %d ",array[i]);
	}
	printf("\n");
	
	return 0;
	
}

void insertionSort(int* array, int size){

	for(int i=0;i<size-1;i++){
		
		int min_ele = array[i];
		
		for(int j=i+1;j<size;j++){
			
			//checking if there is an element less than min_ele
			if(min_ele > array[j]){
				
				min_ele = array[j];
				printf("\nAn Element less than %d is found at position %d \n",array[i],j+1);
				
				for(int k=0;k<size;k++){
					if(k==i){
						printf("[ <%d> ",array[k]);
						continue;
					}
					if(k==j){ 
						
						if(k==(size-1)){
							 printf(" <%d> ]\n",array[k]);
							 continue;
						}
						
						printf(" <%d> ",array[k]);
						continue;
					}
					if(k!=(size-1)){
						printf(" %d ",array[k]);
						continue;
					}
					else{ 
						printf(" %d ]\n",array[k]);
						continue;
					}
				}
				
				moveElementsToRight(array, i, j);
				array[i]=min_ele;
			}//if
		}//inner-loop
	}//outer-loop

}// insertionSort()

void moveElementsToRight(int* array, int i, int j){

	
	
	for(int k=j;k>i;k--){
		array[k]=array[k-1];
	}
}




