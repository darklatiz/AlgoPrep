package mx.com.geekflu.algo.prep.data.arrays;

public class Problems {

  public int findMaxConsecutiveOnes(int[] nums) {
    if(nums == null || nums.length <=0) return 0;
    int onecounter = 0;
    int maxCounter = 0;
    for (int i = 0; i < nums.length; i++){
      if(nums[i] == 1){
        onecounter++;
        if(maxCounter < onecounter){
          maxCounter = onecounter;
        }
      }else{
        onecounter = 0;
      }
    }
    return maxCounter;
  }

  public int findNumbers(int[] nums) {
    int counter = 0;
    for(int i = 0; i < nums.length; i++){
      if(nums[i] >= 10 && nums[i] < 100) counter++;
      else if (nums[i] >= 1000 && nums[i] < 10000) counter++;
      else if (nums[i] == 100000) counter++;
    }
    return counter;
  }

  public static void main(String[] args) {
    Problems p = new Problems();
    p.executeFindMaxConsecutiveOnes();
    p.executeFindNumbers();
  }

  private void executeFindNumbers() {
    int[] nums = {12,345,2,6,7896};
    System.out.println("executeFindNumbers: " + findNumbers(nums));
  }

  private void executeFindMaxConsecutiveOnes() {
    int[] nums = {1,1,0,1,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1};
    int[] nums1 = {1,0,1,1,0,1};
    System.out.println(findMaxConsecutiveOnes(nums));
  }

}
