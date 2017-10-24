import java.lang.*;
import java.io.*;
import java.util.*;

public class simplejava
{
    public static void main(String[] args)

    {
    long startTime = System.currentTimeMillis(); //calculating the Time taken to execute the whole prgoram in mSeconds
    System.out.println("\t!!! BINARY SEARCH !!!");
    int a[] = {109,78,32,65,98}; // the array initialized need to be dynamic xxxxxx
    Scanner s = new Scanner(System.in); //scanner from the util package
    System.out.println("Enter an Element to search from the Given Array"); // promting user to input an element
    int x = s.nextInt();  //int 'x' is the Element given by the user to be searched
    BinarySearch bs = new BinarySearch(a,a.length,x); // calling the BinarySearch Constructor
    System.out.println("\n\t"+bs);
    s.close();  // object to be closed

    //can you use a string builder instead of concatinating strings with +
    System.out.println("The Total Program Execution has taken '"+(System.currentTimeMillis()-startTime)+"' Milli Seconds or '"+((System.currentTimeMillis()-startTime)/1000)+"' Seconds");
    }

}

// To apply binary search the Array should be sorted
class BinarySearch
{
    //where is the access specifier?
    //always the variables should provide readability for example BinarySearch(int items[],int arrayLength,.....)
    //if you are sending the array why do you need to send the length of the array to the function? you could always calculate from the array that you have got!!! isn't it!!
    BinarySearch(int a[],int len, int x) // class Constructor   
    {
        if(a.length == 0) //checking if the Array is Empty
        {
            System.out.println("The Array is Empty !");
            return; // now the program would be terminated.
        }
        else 
        {
            // what is the need to check for sorting? if you throw the collection to the sorting algorithms and if the array is already sorted then it would have done in same time complexity O(n).
            // i think instead of checking, you should directly send the collection to the sort algorithm.
            for(int i=0; i<len; i++) // If the Given array is not sorted it would be Sorted using the Bubble Sort Tech
            {
                try
                {
                if(a[i]<a[i+1])            //checking if array is sorted.
                {
                    System.out.print(a[i]+"\t");
                    if(i == len)  // this is kept as it is raising an ArrayIndexOutOfBondsException and not printing the last Element
                    {
                        System.out.print(a[len-1]+"\t"); // this should be revised agian for ArrayIndexOutOfBondsException
                    }
                }
                else
                {
                    System.out.println("\t\t  ....................\n\t\t      BUBBLE SORT  \n\t\t  ....................");
                    System.out.println("\n\nThe Given Array is not Sorted!\n Applying Sorting Technique on the Array \n");
                    sorting(a,len); // calling the Sorting function if the Array is not in Sorted Order
                    break;
                }
                
                } //END OF try BLOCK
            //why there is no statements in catch exception???????
            catch(Exception e){}
            }// for loop Ends 
            
        } // end of CONSTRUCTOR
            System.out.println("\n\t\t////////////////////\n\t\t    BINARY SEARCH\n\t\t////////////////////");
        System.out.println("\n\n  ...Applying Binary Search With Recursion Tech");
        long start = System.nanoTime(); // Starting the timer for the Binary search Before calling the Method
        int ret = Search(a,len-1,x,0); // calling the Search method with params as a, last index, Element to be searched, first index
        long end = System.nanoTime()-start; // timer ends at succesful search
        System.out.println("The Binary Search Took about '"+end+"' nano Seconds or '"+(end/1000)+"' Milli seconds");
        if(ret < 0 ) // checking if the Search is unsuccessfull
        {
            System.out.println("\nThe Element '\033[1;41m "+x+"\u001B[0m' is not present in the Given Array"); //number in red Background
            System.out.println("\033[1;31m\n\t////////// Search Unsuccessful //////////\u001B[0m"); //print in red color
        }
        else // if the search is successful
        {
            System.out.println("\033[1;32m\n\t/////////////// Search Successful /////////////////\033[0m"); // print in green color
        }   
        }
        
        public void sorting(int a[], int len)  // looks like the Bubble sort Techinique
        {
            long sortStartTime = System.nanoTime();// starting the timer just before the Sorting starts
            for(int i = 0; i<len; i++) // checking with the single element
            {
                for(int j=i+1; j<len; j++) // checking the above single element with other elements
                {
                    if(a[i]>a[j]) // if the ith element is less than the jth element then swapping
                    {
                        int swap; // local temporary variable to the block
                        swap=a[i];
                        a[i]=a[j];
                        a[j]=swap;
            
                    } 
                } //inner for loop
            }// outer for loop
            long SortEndTime = System.nanoTime()-sortStartTime; // ending and caluclating the sorting time.
            System.out.println("The Array is now Sorted !");
            System.out.println("The Bubble Sort has taken time about '"+SortEndTime+"' Nano Seconds '"+(SortEndTime/1000)+"' Milli Seconds");
            int i = 0; 
            System.out.println("The Array after Sorting is \t");
            while(i<a.length) // printing the array after sorting.
            {
                System.out.print("   \u001b[34m"+a[i]+" "+"\u001b[0m"); // printing array whith blue colour
                i++;
            }
            System.out.println("\n\n\t .............Finished Sorting.................\n");
        
    
        }// sorting  method
    
        //what is the use of first if it is always zero????? you are including a lot of extra information which is not needed, clean the code and make it brief and neat.
        public int Search(int a[],int len,int x, int first) // Binary Search using recursion
        {
            int mid = (first+len)/2; //Caluclating the mid value
            System.out.println("\n\tThe Mid Value is "+mid);
           if(len >= first) //checking if the first and Last Pointers cross each other
            {
            try
            {
            if(first == len && x != a[mid]) //if the mid,first,last points to single element which is not the required one
            {
                return -1; // Unsuccessful search
            }
            if(x == a[mid]) // IF the Element to be searched is exactly at the mid position
            {
                System.out.println("\nThe Element  '\u001B[42m"+x+"\u001B[0m' is Present at the Position \u001B[42m|"+(mid+1)+"|\u001b[0m");
                return 1; // here it is Successful search
            }
            else if(x<a[mid]) //Required element would be before the mid pointing element
            {
                len = mid-1;// moving the len to element just before the mid
                if(len < 0) //checking if the last pointer have moved off from [0] index i.e., < 0 - says the search is completed
                {
                       
                    return -1; // searching array is compeleted and unsuccesful
                }
                else
                   return Search(a,len,x,first); //attempting for the recursion which is like next iteration
            }
            else if(x>a[mid])
            {
                first = mid+1; //moving the first to element just after the mid
                if(first >= a.length) //checking if the first pointer is comelty moved off from last index i.e., more than array length 
                {
                   
                    return -1; // searching array is completed and unsuccessful
                }
                    
                else
                     return Search(a,len,x,first); //attempting for the recursion which is like next iteration
            }
            
            }
            catch(Exception e){ }
        }
        System.out.println("End of the Search");
        return -1; // unsuccessful search
    }
}
