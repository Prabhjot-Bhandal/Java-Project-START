public class ArraysAssessment {
    public static void main(String[] args) {
        String array[] = {"program", "good", "happy"};
        for (int index = 0; index < array.length; index++) {
            String firstLetter = array[index].substring(0, 1);
            String restOfWord = array[index].substring(1);
            String encodedWord = restOfWord + firstLetter + "y";
            System.out.println(encodedWord);
        }
    }
}

