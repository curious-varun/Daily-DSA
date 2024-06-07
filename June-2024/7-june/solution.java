class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] str = sentence.split(" ");

        for(int i = 0;i<str.length;i++){
            for(String root: dictionary){
                if(str[i].startsWith(root)){
                    str[i] = root;
                }
            }
        }

        StringBuilder s = new StringBuilder();;

        for(int i = 0;i<str.length;i++){
            s.append(str[i]);
            if(i != str.length-1){
                s.append(" ");
            }
        }

        return s.toString();
    }
}
