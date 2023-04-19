import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Sort extends User_UI{

	Scanner sc = new Scanner(System.in);

	public int[] data = new int[128];
	public String x;//排序數字之變數
	public boolean check=false;//檢驗是否為有效數字之變數
	public boolean checkE=false;//檢驗是否為有效ENG之變數
	public String[] numberForCheck = new String[128];
	public Double [] numberToSort = new Double[128];
	public String[] englishToSort = new String[128];
	public int n=0;
	public String result = "";

	//插入排序的數字
	public void insertion(String x){
		int total = Separator(x);
		if(total==0){
			result="輸入內容有誤!\n請輸入有效內容!\n";	
		}
		else if(total>0){
			if(check){
				Double [] action= new Double[128];
				action = numberToSort;
				insertionSort(action,total);
			}
			else if(checkE){
				Double [] action= new Double[128];
				action = numberToSort;
				word_insetionsort(action,total);
			}
		}

	}
	public void insertionMax(String x){
		int total = Separator(x);
		if(total==0){
			result="輸入內容有誤!\n請輸入有效內容!\n";	
		}
		else if(total>0){
			if(check){
				Double [] action= new Double[128];
				action = numberToSort;
				insertionSortMax(action,total);
			}
			else if(checkE){
				Double [] action= new Double[128];
				action = numberToSort;
				word_insetionsortMax(action,total);
			}
		}

	}
	public void selection(String x){
		int total = Separator(x);
		if(total==0){
			result="輸入內容有誤!\n請輸入有效內容!\n";	
		}
		else if(total>0){
			if(check){
				Double [] action= new Double[128];
				action = numberToSort;
				selectionSort(action,total);
			}
			else if(checkE){
				Double [] action= new Double[128];
				action = numberToSort;
				word_selectionsort(action,total);
			}
		}

	}
	public void selectionMax(String x){
		int total = Separator(x);
		if(total==0){
			result="輸入內容有誤!\n請輸入有效內容!\n";	
		}
		else if(total>0){
			if(check){
				Double [] action= new Double[128];
				action = numberToSort;
				selectionSortMax(action,total);
			}
			else if(checkE){
				Double [] action= new Double[128];
				action = numberToSort;
				word_selectionsortMax(action,total);
			}
		}

	}

	//分割數字(以空格鍵作為分割)
	public int Separator(String xx){
		StringTokenizer noSeparator=new StringTokenizer(xx);
		int a=0;
		while(noSeparator.hasMoreTokens()){
			numberForCheck[a]=noSeparator.nextToken();
			a++;
		}
		int b=a-1;

		if(isNumber(numberForCheck[0])){

			for(int i=1;i<=b;i++){
				check=isNumber(numberForCheck[i]);
				while(!check){
					//result="請輸入有效數字!\n";
					return 0;
				}
			}

			result=result+"進行排列的數字為: ";

			for(int j=0;j<=b;j++){
				numberToSort[j]=Double.parseDouble(numberForCheck[j]);

				if(numberToSort[j]%1!=0)
					result=result+numberToSort[j]+" ";
				else{
					Double d = numberToSort[j];
					result=result+String.valueOf(d)+" ";
				}
			}
			result=result+"\n";
		}
		else if(isEnglish(numberForCheck[0])){

			for(int i=1;i<=b;i++){
				checkE=isEnglish(numberForCheck[i]);
				while(!checkE){
					//result="請輸入有效英文!\n";
					return 0;
				}
			}

			result=result+"進行排列的英文為: ";

			for(int j=0;j<=b;j++){
				englishToSort[j]=numberForCheck[j];

				numberToSort[j]=0.00;

				char [] chars = numberForCheck[j].toCharArray();

				int l = chars.length;


    			for(int i = 0; i < l; i++)
    			{
     			 numberToSort[j] += (int)chars[i]; 
    			}

    			result=result+englishToSort[j]+" ";
			}
			result=result+"\n";
		}

		return b;
	}

	//檢查是否為數字
	public boolean isNumber(String number){
		boolean checkInteger=false;
		Pattern integerPattern=Pattern.compile("-?[0-9]+.*[0-9]*");//判斷是否為小數,負數或者浮點數
		return integerPattern.matcher(number).matches();
	}

	//檢查是否為英文
	public boolean isEnglish(String english){
		boolean checkEnglish=false;
		Pattern englishPattern=Pattern.compile("-?[a-zA-Z]*");//判斷是否為小數,負數或者浮點數
		return englishPattern.matcher(english).matches();
	}

	//重點：排序
	public void insertionSort(Double s[],int t){
		int i,j,k;
		double temp;

		result=result+"\n一共有 "+(t+1)+" 個數字進行排序\n";
		result=result+"-------------------------------\n";

		for(i=0;i<=t;i++){
			result=result+"Step"+(i+1)+": ";
			temp = s[i];
			for(j=i;j>0 && temp<s[j-1];j--)
				s[j]=s[j-1];
			s[j]=temp;
			for(k=0;k<=t;k++){
				result=result+String.valueOf(s[k])+" ";
			}
			result=result+"\n";
		}
	}
	public void insertionSortMax(Double s[],int t){
		int i,j,k;
		double temp;

		result=result+"\n一共有 "+(t+1)+" 個數字進行排序\n";
		result=result+"-------------------------------\n";

		for(i=0;i<=t;i++){
			result=result+"Step"+(i+1)+": ";
			temp = s[i];
			for(j=i;j>0 && temp>s[j-1];j--)
				s[j]=s[j-1];
			s[j]=temp;
			for(k=0;k<=t;k++){
				result=result+String.valueOf(s[k])+" ";
			}
			result=result+"\n";
		}
	}
	public void selectionSort(Double arr[],int y){
		double temp;

		result=result+"\n一共有 "+(y+1)+" 個數字進行排序\n";
		result=result+"-------------------------------\n";

		for(int i = 0; i < y+1; i++){
			result=result+"Step"+(i+1)+": ";
			int min_idx = i;
			for(int j = i+1; j < y+1; j++)
				if (arr[j] < arr[min_idx])
				min_idx = j;
			temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
			for(int k=0;k<=y;k++)
				result=result+String.valueOf(arr[k])+" ";
			result=result+"\n";
		}
	}
	public void selectionSortMax(Double arr[],int y){
		double temp;

		result=result+"\n一共有 "+(y+1)+" 個數字進行排序\n";
		result=result+"-------------------------------\n";

		for(int i = 0; i < y+1; i++){
			result=result+"Step"+(i+1)+": ";
			int min_idx = i;
			for(int j = i+1; j < y+1; j++)
				if (arr[j] > arr[min_idx])
				min_idx = j;
			temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
			for(int k=0;k<=y;k++)
				result=result+String.valueOf(arr[k])+" ";
			result=result+"\n";
		}
	}
	public void word_insetionsort(Double[] arr,int t)
  {
    int i, j, n = t;
    double key;
    String word;

    result=result+"\n一共有 "+(n+1)+" 個英文進行排序\n";
	result=result+"-------------------------------\n";

	for(i = 0;i <= n; i++)
    {
      key = arr[i];
      word = englishToSort[i];
      j = i - 1;

      while(j >= 0 && key < arr[j])
      {
        arr[j+1] = arr[j];
        englishToSort[j+1]=englishToSort[j];
        j = j - 1;
      }

        arr[j+1] = key;
        englishToSort[j+1] = word;
    
      result=result+"Step"+(i+1)+": ";

      for(int k = 0;k <=n; k++)
      {
        result=result+englishToSort[k] + " ";
      }
      result=result+"\n";
       
    }
  }
	public void word_insetionsortMax(Double[] arr,int t)
	  {
	    int i, j, n = t;
	    double key;
	    String word;

	    result=result+"\n一共有 "+(n+1)+" 個英文進行排序\n";
		result=result+"-------------------------------\n";

		for(i = 0;i <= n; i++)
	    {
	      key = arr[i];
	      word = englishToSort[i];
	      j = i - 1;

	      while(j >= 0 && key > arr[j])
	      {
	        arr[j+1] = arr[j];
	        englishToSort[j+1]=englishToSort[j];
	        j = j - 1;
	      }

	        arr[j+1] = key;
	        englishToSort[j+1] = word;
	    
	      result=result+"Step"+(i+1)+": ";

	      for(int k = 0;k <=n; k++)
	      {
	        result=result+englishToSort[k] + " ";
	      }
	      result=result+"\n";
	       
	    }
	  }
	public void word_selectionsort(Double[] arr,int t)
	  {
	    int i, j, n = t;

	    String word;

	    result=result+"\n一共有 "+(n+1)+" 個英文進行排序\n";
		result=result+"-------------------------------\n";

        for ( i = 0; i <= n; i++)
        {

  	      word = englishToSort[i];
            // Find the minimum element in unsorted array
            int min_idx = i;
            for ( j = i+1; j < n+1; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
 
            // Swap the found minimum element with the first
            // element
            double temp = arr[min_idx];
            String temp2= englishToSort[min_idx];
            arr[min_idx] = arr[i];
            englishToSort[min_idx]=englishToSort[i];;
            arr[i] = temp;
            englishToSort[i]=temp2;
	    
	      result=result+"Step"+(i+1)+": ";

	      for(int k = 0;k <= n; k++)
	      {
	    	  result=result+englishToSort[k] + " ";
	      }
	      result=result+"\n";
	       
	    }
	  }
	public void word_selectionsortMax(Double[] arr,int t)
	  {
	    int i, j, n = t;

	    String word;

	    result=result+"\n一共有 "+(n+1)+" 個英文進行排序\n";
		result=result+"-------------------------------\n";

        for ( i = 0; i <= n; i++)
        {

  	      word = englishToSort[i];
            // Find the minimum element in unsorted array
            int min_idx = i;
            for ( j = i+1; j < n+1; j++)
                if (arr[j] > arr[min_idx])
                    min_idx = j;
 
            // Swap the found minimum element with the first
            // element
            double temp = arr[min_idx];
            String temp2= englishToSort[min_idx];
            arr[min_idx] = arr[i];
            englishToSort[min_idx]=englishToSort[i];;
            arr[i] = temp;
            englishToSort[i]=temp2;
	    
	      result=result+"Step"+(i+1)+": ";

	      for(int k = 0;k <= n; ++k)
	      {
	    	  result=result+englishToSort[k] + " ";
	      }
	      result=result+"\n";
	       
	    }
	  }
}