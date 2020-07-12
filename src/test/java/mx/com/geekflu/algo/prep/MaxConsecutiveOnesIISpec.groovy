package mx.com.geekflu.algo.prep

import mx.com.geekflu.algo.prep.data.arrays.MaxConsecutiveOnesII
import spock.lang.Specification

class MaxConsecutiveOnesIISpec extends Specification {

  def "Height Checker"() {
    given:
    MaxConsecutiveOnesII maxConsecutiveOnesII = new MaxConsecutiveOnesII()

    when:
    int count = maxConsecutiveOnesII.findMaxConsecutiveOnes()

    then:
    count != 0


  }

}
