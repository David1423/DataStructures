import java.lang.*;
import java.io.*;
import java.util.*;

public class simplejava
{
    public static void main(String[] args)

    {
    long startTime = System.currentTimeMillis(); //calculating the Time taken to execute the whole prgoram in mSeconds
    System.out.println("\t!!! BINARY SEARCH !!!");
    int items[] = {109,78,32,65,98}; // the array initialized need to be dynamic xxxxxx
    Scanner s = new Scanner(System.in); //scanner from the util package
    System.out.println("Enter an Element to search from the Given Array"); // promting user to input an element
    int srcItm = s.nextInt();  //int 'x' is the Element given by the user to be searched
    BinarySearch bs = new BinarySearch(items,srcItm); // calling the BinarySearch Constructor
    System.out.println("\n\t"+bs);
    s.close();  // object to be closed
    StringBuilder sb  = new StringBuilder();

    //can you use a string builder instead of concatinating strings with +
    System.out.println(sb.append("The Total Program Execution has taken \'").append(System.currentTimeMillis()-startTime).append("\' Milli Seconds or \'").append((System.currentTimeMillis()-startTime)/1000).append("\' Seconds"));
    }

}

// To apply binary search the Array should be sorted
 class BinarySearch
{
    StringBuilder sb = new StringBuilder();
    //where is the access specifier?
    //always the variables should provide readability for example BinarySearch(int items[],int arrayLength,.....)
    //if you are sending the array why do you need to send the length of the array to the function? you could always calculate from the array that you have got!!! isn't it!!
    BinarySearch(int items[],int srcItm) // class Constructor   
    {
        if(items.length == 0) //checking if the Array is Empty
        {
            System.out.println("The Array is Empty !");
            return; // now the program would be terminated.
        }
        else 
        {
            // what is the need to check for sorting? if you throw the collection to the sorting algorithms and if the array is already sorted then it would have done in same time complexity O(n).
            // i think instead of checking, you should directly send the collection to the sort algorithm.

            // == now directly the array is given to the sorting method.

            /*for(int i=0; i<len; i++) // If the Given array is not sorted it would be Sorted using the Bubble Sort Tech
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
                     // calling the Sorting function if the Array is not in Sorted Order
                    break;
                }
                
                } //END OF try BLOCK
            //why there is no statements in catch exception???????
            catch(Exception e){
                System.out.println(e);
            }*/
            sorting(items);
        } // end of CONSTRUCTOR
            System.out.println("\n\t\t////////////////////\n\t\t    BINARY SEARCH\n\t\t////////////////////");
        System.out.println("\n\n  ...Applying Binary Search With Recursion Tech");
        long start = System.nanoTime(); // Starting the timer for the Binary search Before calling the Method
        int ret = Search(items,items.length-1,srcItm,0); // calling the Search method with params as a, last index, Element to be searched, first index
        long end = System.nanoTime()-start; // timer ends at succesful search
        System.out.println("The Binary Search Took about '"+end+"' nano Seconds or '"+(end/1000)+"' Milli seconds");
        if(ret < 0 ) // checking if the Search is unsuccessfull
        {
            System.out.println("\nThe Element '\033[1;41m "+srcItm+"\u001B[0m' is not present in the Given Array"); //number in red Background
            System.out.println("\033[1;31m\n\t////////// Search Unsuccessful //////////\u001B[0m"); //print in red color
        }
        else // if the search is successful
        {
            System.out.println("\033[1;32m\n\t/////////////// Search Successful /////////////////\033[0m"); // print in green color
        }   
        }
        
        public void sorting(int items[])  // looks like the Bubble sort Techinique
        {
            long sortStartTime = System.nanoTime();// starting the timer just before the Sorting starts
            for(int i = 0; i<items.length; i++) // checking with the single element
            {
                for(int j=i+1; j<items.length; j++) // checking the above single element with other elements
                {
                    if(items[i]>items[j]) // if the ith element is less than the jth element then swapping
                    {
                        int swap; // local temporary variable to the block
                        swap=items[i];
                        items[i]=items[j];
                        items[j]=swap;
            
                    } 
                } //inner for loop
            }// outer for loop
            long SortEndTime = System.nanoTime()-sortStartTime; // ending and caluclating the sorting time.
            System.out.println("The Array is now Sorted !");
            System.out.println("The Bubble Sort has taken time about '"+SortEndTime+"' Nano Seconds '"+(SortEndTime/1000)+"' Milli Seconds");
            int i = 0; 
            StringBuilder sb = new StringBuilder();                    
            System.out.println("The Array after Sorting is \t");
            while(i<items.length) // printing the array after sorting.
            {
                System.out.print(sb.append("   \u001b[34m").append(items[i]).append(" "+"\u001b[0m")); // printing array whith blue colour
                i++;
            }
            System.out.println("\n\n\t .............Finished Sorting.................\n");
        
    
        }// sorting  method
    
        //what is the use of first if it is always zero????? you are including a lot of extra information which is not needed, clean the code and make it brief and neat.
        // == first is the variable used which keep changing its value and also the len represents the last index in the
        // partitin of the array as the mid value keeps changing for the every recurion search.
        public int Search(int items[],int len,int srcItm, int first) // Binary Search using recursion
        {
            int mid = (first+len)/2; //Caluclating the mid value
            System.out.println("\n\tThe Mid Value is "+mid);
            StringBuilder sb = new StringBuilder();
           if(len >= first) //checking if the first and Last Pointers cross each other
            {
            try
            {
            if(first == len && srcItm == items[mid]) //if the mid,first,last points to single element which is not the required one
            {
                return -1; // Unsuccessful search
            }
            if(srcItm == items[mid]) // IF the Element to be searched is exactly at the mid position
            {
                System.out.println(sb.append("\nThe Element  '\u001B[42m").append(srcItm).append("\u001B[0m' is Present at the Position \u001B[42m|").append((mid+1)).append("|\u001b[0m"));
                return 1; // here it is Successful search
            }
            else if(srcItm < items[mid]) //Required element would be before the mid pointing element
            {
                len = mid-1;// moving the len to element just before the mid
                if(len < 0) //checking if the last pointer have moved off from [0] index i.e., < 0 - says the search is completed
                {
                       
                    return -1; // searching array is compeleted and unsuccesful
                }
                else
                   return Search(items,len,srcItm,first); //attempting for the recursion which is like next iteration
            }
            else if(srcItm > items[mid])
            {
                first = mid+1; //moving the first to element just after the mid
                if(first >= items.length) //checking if the first pointer is comelty moved off from last index i.e., more than array length 
                {
                   
                    return -1; // searching array is completed and unsuccessful
                }
                    
                else
                     return Search(items,len,srcItm,first); //attempting for the recursion which is like next iteration
            }
            
            }
            catch(Exception e){
                System.out.println(e);
             }
        }
        System.out.println("End of the Search");
        return -1; // unsuccessful search
    }
}
