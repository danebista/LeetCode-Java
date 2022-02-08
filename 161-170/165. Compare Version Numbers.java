class Solution {
    public int compareVersion(String version1, String version2) {
        String[] version1_array = version1.split("\\.");
        String[] version2_array = version2.split("\\.");
        
        int max_length = Math.max(version1_array.length, version2_array.length);
        
        for (int i=0; i<max_length; i++){
            int v1= i < version1_array.length ? Integer.parseInt(version1_array[i]):0;
            int v2 = i < version2_array.length ? Integer.parseInt(version2_array[i]):0;
            
            if (v1<v2) return -1;
            if (v1>v2) return 1;
        }
        
        return 0;
    }
}
