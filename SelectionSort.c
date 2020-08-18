#include<stdio.h>
#include<stdlib.h>

//functions declaration
void selectionSort(int* arr,int size);
void swap(int* arr, int first, int second);


int main(){
	
	//Selection sort
	
	int* buffer;
	int size;
	
	
	printf("------------SELECTION SORT-------------\nEnter the Size of the Collection :: ");
	scanf("%d",&size);
	
	if(size==0||size<0){
		printf("Sorry !!The given size is not Allowed, Size should be greater than 0\n");
		return 0;
	}
	
	
	//Dynamic memory through continous-memory-allocation(calloc())
	buffer = (int*)calloc(size,sizeof(int));
	
	printf("Enter %d integers into the List\n" , size);
	
	//storing elements into the array
	for(int i=0;i<size;i++){
		scanf("%d",&buffer[i]);
	}
	
	if(size==1){
		printf("Sorted Array is :: %d\n",buffer[0]);
		return 0;
	}
	
	selectionSort(buffer, size);
	
	//print array after sortingl
	
	printf("\n Elements after sorting\n");
	
	for(int i=0;i<size;i++){
		printf("%d ",buffer[i]);
	}
	printf("\n");
	
 return 0;
} //main()

void selectionSort(int* arr,int size){

	
	int min_ele=0;
	
	for(int i=0;i<size-1;i++){
		min_ele=arr[i];
		
		for(int j=i+1;j<size;j++){
				
			if(arr[j] < min_ele){
				
				printf("Swapping elements of positions %d and %d \n",i+1,j+1);
				
				//printing the Elements before swapping
				for(int k=0;k<size;k++){
				
					if(k==i){ printf(" Sub-Array to be sorted->[ "); }
				
					if(k==i || k==j){
						printf("||%d||", arr[k]);
					}
					else{
						printf(" %d ", arr[k]);
					}
					if(k==size-1){ printf(" ]\n\n"); }
					
				}
				
				//call the swap function
				swap( arr, i, j);
			}//if
		}// inner for-loop
	}//outer for-loop
} // selectionSort()

void swap(int* arr, int first, int second){

	int temp = arr[first];
	arr[first] = arr[second];
	arr[second] = temp;
	
} //swap()

