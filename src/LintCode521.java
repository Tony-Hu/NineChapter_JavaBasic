import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * [URL]: http://www.lintcode.com/problem/remove-duplicate-numbers-in-array
 * [description]:
 * Given an array of integers, remove the duplicate numbers in it.

 You should:
 1. Do it in place in the array.
 2. Move the unique numbers to the front of the array.
 3. Return the total number of the unique numbers.

 Notice

 You don't need to keep the original order of the integers.

 Example
 Given nums = [1,3,1,4,4,2], you should:

 Move duplicate integers to the tail of nums => nums = [1,3,4,2,?,?].
 Return the number of unique integers in nums => 4.
 Actually we don't care about what you place in ?, we only care about the part which has no duplicate integers.

 Challenge
 Do it in O(n) time complexity.
 Do it in O(nlogn) time without extra space.
 */
public class LintCode521 {

  //Method 1 - HashSet, O(n) time complexity, O(n) extra space
  public int deduplication(int[] nums) {
    // Write your code here
    Set<Integer> set = new HashSet<>();
    for (int element : nums){
      set.add(element);
    }
    Iterator<Integer> iterator = set.iterator();
    int i = 0;
    while (iterator.hasNext()){
      nums[i++] = iterator.next();
    }
    return set.size();
  }

  //Method 2 - Sort, O(nlogn) time complexity, O(1) extra space
  /**
   * @param nums an array of integers
   * @return the number of unique integers
   */
  public int deduplication2(int[] nums) {
    // Write your code here
    if (nums == null || nums.length == 0){
      return 0;
    }
    Arrays.sort(nums);
    int length = 0;
    for (int i = 1; i < nums.length; i++){
      if (nums[length] != nums[i]){
        nums[++length] = nums[i];
      }
    }
    return length + 1;
  }
}
