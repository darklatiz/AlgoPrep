package mx.com.geekflu.algo.prep.binary.search;

import lombok.Getter;
import mx.com.geekflu.algo.prep.util.Util;

@Getter
public class FirstBadVersion {

  private int currentBadVersion;
  private int bound;

  /**
   *
   * @param bound max int which will be used to create a random number 0......bound
   */
  public FirstBadVersion(int bound) {
    this.currentBadVersion = Util.getRandomInt(bound);
    this.bound = bound;
  }


  public int firstBadVersion(int n) {
    if (n <= 0)
      return -1;

    int start = 1;
    int end = n;

    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (isBadVersion(mid)) {
        end = mid - 1;
      }else {
        start = mid + 1;
      }
    }
    return start;
  }

  public boolean isBadVersion(int version) {
    return version >= this.currentBadVersion;
  }

  public void changeBadVersion() {
    this.currentBadVersion = Util.getRandomInt(this.bound);
  }

}
