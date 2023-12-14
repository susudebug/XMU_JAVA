import java.util.Arrays;

public class first {
    public static class MyString {
        char[] mystring;
        public MyString() {
            mystring = new char[]{'#','#','#'};
        }
        public MyString(char[] ch) {
            //int len = ch.length;
            //System.arraycopy(ch, 0, mystring, 0, len);
            mystring = Arrays.copyOf(ch, ch.length);
        }
        public char[] showContent() {
            /*int len = mystring.length;
            for (int i = 0; i < len; i++) {
                System.out.print(mystring[i]);
            }
            System.out.println();*/
            return mystring;
        }
        public int indexOf(char ch) {
            int len = mystring.length;
            for (int i = 0; i < len; i++) {
                if (mystring[i] == ch) return i;
            }
            return -1;
        }
        public char charAt(int index) {
            int len = mystring.length;
            if (index < 0 || index >= len) return '#';
            else return mystring[index];
        }
        public MyString substring(int begin, int end) {
            MyString str;
            int len = end - begin + 1;
            char[] temp = new char[len];
            System.arraycopy(mystring, begin, temp, 0, len);
            str = new MyString(temp);
            return str;
        }
        public MyString append(char[] ch) {
            int len = mystring.length;
            char[] temp = new char[len + ch.length];
            for (int j = 0; j < len; j++) temp[j] = mystring[j];
            for (int j = 0; j < ch.length; j++) temp[len++] = ch[j];
            mystring = Arrays.copyOf(temp, temp.length);
            return new MyString(mystring);
        }
    }
    public static void main(String[] args) {
        MyString string1 = new MyString();
        System.out.println(string1.showContent());
        string1.append(new char[] {'i'});
        System.out.println(string1.showContent());

        char[] ch = {'n', 'e', 'w', ' ', 's', 't', 'r', 'i', 'n','g'};
        MyString string2 = new MyString(ch);
        System.out.println(string2.showContent());
        System.out.println(string2.indexOf('w'));
        System.out.println(string2.charAt(-1));
        char[] beAppend = new char[] {' ', 'i', 's', ' ', 'h', 'e', 'r', 'e'};
        string2.append(beAppend);
        System.out.println(string2.showContent());
        System.out.println(string2.indexOf('h'));

        MyString string3 = new MyString(new char[]{'s', 't', 'r', 'i', 'n', 'g', '3'});
        System.out.println(string3.showContent());
        System.out.println(string3.indexOf('h'));
    }
}