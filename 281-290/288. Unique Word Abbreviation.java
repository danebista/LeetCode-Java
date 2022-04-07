public class ValidWordAbbr {

    HashMap<String, HashSet<String>> hashmap = new HashMap(); 
    /*
    * @param dictionary: a list of words
    */public ValidWordAbbr(String[] dictionary) {
        // do intialization if necessary
        for (int i=0; i< dictionary.length; i++){
            String word = dictionary[i];
            String abb = generateAbbreviation(word);
            HashSet<String> set = hashmap.getOrDefault(abb, new HashSet<String>());
            set.add(word);
            hashmap.put(abb, set);
        }

        System.out.println(hashmap);
    }

    /*
     * @param word: a string
     * @return: true if its abbreviation is unique or false
     */
    public boolean isUnique(String word) {
        // write your code here
        if (!hashmap.containsKey(generateAbbreviation(word))) return true;
        if (hashmap.get(generateAbbreviation(word)).size()==1 
        && hashmap.get(generateAbbreviation(word)).contains(word)) return true;

        return false;
    }

    public String generateAbbreviation(String word){
        if (word.length()<=2) return word;
        return word.charAt(0)+String.valueOf(word.length()-2)+ word.charAt(word.length()-1);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param = obj.isUnique(word);
 */
 