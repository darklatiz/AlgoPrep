package mx.com.geekflu.algo.prep.data.arrays;

public class Problems {

  public int findMaxConsecutiveOnes(int[] nums) {

    return 0;
  }

  public static void main(String[] args) {
    Problems p = new Problems();
    p.executeFindMaxConsecutiveOnes();
  }

  private void executeFindMaxConsecutiveOnes() {
    int[] nums = {1,1,0,1,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1};
    System.out.println(findMaxConsecutiveOnes(nums));
  }

}
