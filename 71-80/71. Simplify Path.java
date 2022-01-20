class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        String[] characters = path.split("/+");
        
        for (String chara: characters){
            if (chara.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }
            else if(!Arrays.asList(".","").contains(chara))
            {
                stack.push(chara);
            }
        }
       
        return "/"+ String.join("/", stack);
        
    }
}
