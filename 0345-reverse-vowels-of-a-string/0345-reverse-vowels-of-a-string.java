class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        String vowels = "aeiouAEIOU";
        List<Character> vowelsArray = new ArrayList<>();
        List<Integer> indexArray = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {

            if (vowels.contains(String.valueOf(s.charAt(i)))) {
                vowelsArray.add(s.charAt(i));
                indexArray.add(i);
            }
        }

        Collections.reverse(vowelsArray);

        for(int i = 0; i < vowelsArray.size(); i++) {
            sb.setCharAt(indexArray.get(i), vowelsArray.get(i));
        }

        return sb.toString();
    }
}