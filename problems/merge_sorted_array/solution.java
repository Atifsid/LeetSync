class Solution {
    public void merge(int[] a, int m, int[] b, int n) {
        
        int k = m + n -1;
        int i = m-1;
        int j = n-1;
        
        if(n == 0) return ;
        
        if(m == 0){ 
            for(int z=0; z<=k ;z++)
                a[z] = b[z];
            
            return ;
        }
        
        while(i>=0 && j>=0){
        if(a[i] < b[j]){
            a[k] = b[j];
            j--;
           
        }
        else{
            a[k] = a[i];
            a[i] = b[j];
            i--;
        }
        k--;
  
    }
        while(i>=0) a[k--] = a[i--];
        while(j>=0) a[k--] = b[j--];
        }
    }
