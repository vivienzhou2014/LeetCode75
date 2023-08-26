public class GreatestCommonDivisorOfString1071 {
    class Solution {
        public String gcdOfStrings(String str1, String str2) {
            //if we can find the greatest common divisor, return the gcd string
            //first find the length of the gcd string
            int len1 = str1.length();
            int len2 = str2.length();
            int gcdLength = gcd(len1, len2);
            //then use any str1 or str2 to get the gcd string
            String gcdString = str1.substring(0,gcdLength);
            //check if the string works for both strs
            if(check(gcdString, str1) && check(gcdString, str2)){
                return gcdString;
            }
            //if we can not find it ,return empty string
            return "";
        }

        private boolean check(String subString, String mainString) {
            //int subLength = subString.length();
            int mainLength = mainString.length();
            StringBuilder test = new StringBuilder();
            while(test.length() < mainLength){
                test.append(subString);
            }
            return test.toString().equals(mainString);
        }
        //get biggest common divisor from two int
        private int gcd(int a, int b) {
            while(b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
            /*int len1 = str1.length();
            int len2 = str2.length();

            // Calculate greatest common divisor of lengths
            int gcdLength = gcd(len1, len2);

            // Get the potential greatest common divisor string
            String gcdString = str1.substring(0, gcdLength);

            // Verify if gcdString is a common factor of both strings
            if (check(gcdString, str1) && check(gcdString, str2)) {
                return gcdString;
            }

            return "";
        }

        // Check if a given string is a common factor of another string
        private boolean check(String factor, String original) {
            int factorCount = original.length() / factor.length();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < factorCount; i++) {
                sb.append(factor);
            }

            return sb.toString().equals(original);
        }

        // Calculate greatest common divisor using Euclidean algorithm
        private int gcd(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }*/
    }

}
