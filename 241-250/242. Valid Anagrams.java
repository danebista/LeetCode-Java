public boolean isAnagram(String s, String t) {
        
    if(s.length()!=t.length())
        return false;
    
     char[] arr1 = s.toCharArray();
    char[] arr2 = t.toCharArray();
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    
    for(int i=0;i<arr1.length;i++)
    if(arr1[i]!=arr2[i])
        return false;
    return true;
    
}
```

------------------------------------------------------------------------------------------------------------

**Approach 2**
```
 public boolean isAnagram(String s, String t) {
    
    if(s.length()!=t.length())
       return false;
    
     char[] arr1 = s.toCharArray();
     char[] arr2 = t.toCharArray();
     HashMap<Character,Integer> hm=new HashMap<>();
     for(int i=0;i<arr1.length;i++)
     {
         hm.put(arr1[i],hm.getOrDefault(arr1[i],0)+1);
     }
     for(int i=0;i<arr2.length;i++)
     {
         if(!hm.containsKey(arr2[i]))
             return false;
        
         hm.put(arr2[i],hm.get(arr2[i])-1);
        
         if(hm.get(arr2[i])<=0)
             hm.remove(arr2[i]);
     }
     return true;   
}
