import java.lang.*;
import java.io.*;
import java.util.*;

public class simplejava
{
    public static void main(String[] args)

    {
        long startTime = System.currentTimeMillis();
    System.out.println("\t!!! BINARY SEARCH !!!");
    int a[] = {109,78,32,65,98};
    Scanner s = new Scanner(System.in);
    System.out.println("Enter an Element to search from the Given Array");
    int x = s.nextInt();
    BinarySearch bs = new BinarySearch(a,a.length,x);
    System.out.println("\n\t"+bs);
    s.close();
        System.out.println("The Total Program Execution has taken '"+(System.currentTimeMillis()-startTime)+"' Milli Seconds or '"+((System.currentTimeMillis()-startTime)/1000)+"' Seconds");
    }

}

class BinarySearch
{
                                            //making an array as sorted
     BinarySearch(int a[],int len, int x)
    {
        if(a.length == 0)
        {
            System.out.println("The Array is Empty !");
            return;
        }
        else
        {
            for(int i=0; i<len; i++) 
            {
                try
                {
                if(a[i]<a[i+1])            //checking if array is sorted
                {
                    System.out.print(a[i]+"\t");
                    if(i == len)
                    {
                        System.out.print(a[len-1]+"\t");
                    }
                }
                else
                {
                    System.out.println("\t\t  ....................\n\t\t      BUBBLE SORT  \n\t\t  ....................");
                    System.out.println("\n\nThe Given Array is not Sorted!\n Applying Sorting Technique on the Array \n");
                    sorting(a,len);
                    break;
                }
                
                }
            
            catch(Exception e){}
            }
            
        }
            System.out.println("\n\t\t////////////////////\n\t\t    BINARY SEARCH\n\t\t////////////////////");
        System.out.println("\n\n  ...Applying Binary Search With Recursion Tech");
        long start = System.nanoTime();
        int ret = Search(a,len-1,x,0);
        if(ret < 0 )
        {
            long end = System.nanoTime()-start;
            System.out.println("The Binary Search Took about '"+end+"' nano Seconds or '"+(end/1000)+"' Milli seconds");
            System.out.println("\nThe Element '\033[1;41m "+x+"\u001B[0m' is not present in the Given Array");
            System.out.println("\033[1;31m\n\t////////// Search Unsuccessful //////////\u001B[0m");
        }
        else
        {
            long end = System.nanoTime()-start;
            System.out.println("The Binary Search Took about '"+end+"' nano Seconds or '"+(end/1000)+"' Milli seconds");
            System.out.println("\033[1;32m\n\t/////////////// Search Successful /////////////////\033[0m");
        }   
        }
        
        public void sorting(int a[], int len)  // looks like the Bubble sort Techinique
        {
            long sortStartTime = System.nanoTime();
            for(int i = 0; i<len; i++)
            {
                for(int j=i+1; j<len; j++)
                {
                    if(a[i]>a[j])
                    {
                        int swap;
                        swap=a[i];
                        a[i]=a[j];
                        a[j]=swap;
            
                    }
                }
            }
            long SortEndTime = System.nanoTime()-sortStartTime;
            System.out.println("The Array is now Sorted !");
            System.out.println("The Bubble Sort has taken time about '"+SortEndTime+"' Nano Seconds '"+(SortEndTime/1000)+"' Milli Seconds");
            int i = 0; 
            System.out.println("The Array after Sorting is \t");
            while(i<a.length)
            {
                System.out.print("   \u001b[34m"+a[i]+" "+"\u001b[0m");
                i++;
            }
            System.out.println("\n\n\t .............Finished Sorting.................\n");
        
    
        }
        public int Search(int a[],int len,int x, int first) // Binary Search using recursion
        {
            int mid = (first+len)/2; //Caluclating the mid value
            System.out.println("\n\tThe Mid Value is "+mid);
           if(len >= first) //checking if the first and Last Pointers cross each other
            {
            try
            {
            if(first == len && x != a[mid]) //if the mid,first,last points to one element which is not the required  one
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
                len = mid-1;
                if(len < 0) //checking if the last pointer is comelty moved off from [0] index 
                {
                       
                    return -1; // searching array is compeleted
                }
                else
                   return Search(a,len,x,first); //attempting for the recursion like next iteration
            }
            else if(x>a[mid])
            {
                first = mid+1;
                if(first >= a.length) //checking if the first pointer is comelty moved off from last index 
                {
                   
                    return -1; // searching array is completed
                }
                    
                else
                     return Search(a,len,x,first); //attempting for the recursion like next iteration
            }
            
            }
            catch(Exception e){ }
        }
        System.out.println("End of the Search");
        return -1; // unsuccessful search
    }
}
