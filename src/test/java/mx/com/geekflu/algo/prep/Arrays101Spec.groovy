package mx.com.geekflu.algo.prep

import mx.com.geekflu.algo.prep.data.arrays.MaxConsecutiveOnesII
import spock.lang.Specification

class Arrays101Spec extends Specification {

  def "Max consecutive ones"() {
    given:
    MaxConsecutiveOnesII maxConsecutiveOnesII = new MaxConsecutiveOnesII()

    when:
    int count = maxConsecutiveOnesII.findMaxConsecutiveOnes()

    then:
    count != 0


  }

}
