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

  public static void main(String[] args) {
    Problems p = new Problems();
    p.executeFindMaxConsecutiveOnes();
  }

  private void executeFindMaxConsecutiveOnes() {
    int[] nums = {1,1,0,1,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1};
    int[] nums1 = {1,0,1,1,0,1};
    System.out.println(findMaxConsecutiveOnes(nums));
  }

}
