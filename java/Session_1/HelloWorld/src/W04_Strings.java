public class W04_Strings {
    public static void reverse(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        char[] s1 = {'h','e','l','l','o'};
        reverse(s1);
        System.out.println(s1);
        char[] s2 = {'H','a','n','n','a','h'};
        reverse(s2);
        System.out.println(s2);
    }
}
