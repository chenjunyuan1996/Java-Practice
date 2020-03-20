
public class FirstSample {
    public static void main(String[] args) {
        String greeting = "hello";
        int i = 0;
        int cp = greeting.codePointAt(i);
        if (Character.isSupplementaryCodePoint(cp)) i += 2;
        else i++;
    }
}
