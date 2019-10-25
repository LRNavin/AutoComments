public static void sort(Comparable[] a){
    int n=a.length;
    for (int i=1; i < n; i++){
        Comparable v=a[i];
        int lo=0, hi=i;
        while (lo < hi){ ... }
        ...
        }        
        assert isSorted(a); 
}