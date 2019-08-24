import java.util.*;

public class HeapSort {
	
	public void sortHeap(int [] arr)
	{
		int s  = arr[0];
		
		for(int i = s/2; i>0;i--)
		{
			heapify(arr,s,i);
		}
		
		
	}
	
	public void SwapMax(int[] arr)
	{
		int count = arr[0];
		
		int temp = arr[count];
		arr[count] = arr[1];
		arr[1] = temp;
		arr[0] = arr[0] - 1;
	}
	
	public void Heap(int [] arr)
	{
		while (arr[0] >1)
			{
			
				sortHeap(arr);
				SwapMax(arr);
			}
	}
	
	
	
	public void Print(int[] arr)
	{
		for(int i=0; i< arr.length; i++)
			System.out.print(arr[i]+ " ");
		
		System.out.println("\n");
	}
	public void heapify(int[] arr, int n, int i)
	{
		int max= i;
		int leftval = 2*i;
		int rightval = (2*i)+1;
		
		
		if(leftval <= n && arr[leftval] > arr[max])
			max = leftval;
		
		if(rightval <= n && arr[rightval] > arr[max])
			max = rightval;
		
		if(max != i)
		{
			int temp = arr[i];
			arr[i] = arr[max];
			arr[max]= temp;
			
			heapify(arr,n, max);
		}
	}
	public static void main(String[] args)
	{
		HeapSort heap = new HeapSort();
		Random random = new Random();
		
		int[] a = new int[21];
		a[0] = a.length - 1;
		
		for(int i=1; i< a.length; i++)
		{
			a[i] = random.nextInt(30);
		}
	
	
		System.out.println("Initial list of elements in the array");
		System.out.println("Here first element indicates number of nodes");
		heap.Print(a);
		
		heap.sortHeap(a);
		System.out.println("Array after converting into a heap");
		System.out.println("Here first element indicates number of nodes");
		heap.Print(a);
		
		heap.Heap(a);
		System.out.println("Heap after sorting");
		System.out.println("first element decreases by 1 through each pass");
		heap.Print(a);
		
		
		
	}
	

}