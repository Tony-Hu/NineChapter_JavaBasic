/**
 * [URL]: http://www.lintcode.com/en/problem/string-to-integer-ii/#
 * [description]:
 * Implement function atoi to convert a string to an integer.

 If no valid conversion could be performed, a zero value is returned.

 If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 Example
 "10" => 10
 "-1" => -1
 "123123123123123" => 2147483647
 "1.0" => 1
 */
public class LintCode54 {

  /**
   * @param str: A string
   * @return An integer
   */
  public int atoi(String str) {
    // write your code here
    double result = 0;
    if (str == null || str.length() == 0){
      return 0;
    }

    str = str.trim();
    boolean isNegative = false;
    int i = 0;
    if (str.charAt(0) == '-'){
      isNegative = true;
      i++;
    } else if (str.charAt(0) == '+'){
      i++;
    }

    while((i < str.length()) && Character.isDigit(str.charAt(i))){
      result = result * 10 + (double)(str.charAt(i) - '0');
      i++;
    }

    if (isNegative){
      result = -result;
    }
    return result > Integer.MAX_VALUE ? Integer.MAX_VALUE :
        result < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int)result;
  }
}
