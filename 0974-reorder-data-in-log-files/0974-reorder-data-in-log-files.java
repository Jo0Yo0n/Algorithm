class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();

        for (String log : logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                digitList.add(log);
            }
            else {
                letterList.add(log);
            }
        }

        letterList.sort((a, b) -> {
            int result = a.split(" ", 2)[1].compareTo(b.split(" ", 2)[1]);
            if (result != 0) {
                return result;
            }
            else {
                return a.split(" ", 2)[0].compareTo(b.split(" ", 2)[0]);
            }
        });

        letterList.addAll(digitList);

        return letterList.toArray(new String[0]);
    }
}