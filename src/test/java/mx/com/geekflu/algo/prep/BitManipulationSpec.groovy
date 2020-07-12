package mx.com.geekflu.algo.prep

import mx.com.geekflu.algo.prep.data.bit.manipulation.BitManipulation
import spock.lang.Specification

class BitManipulationSpec extends Specification {

  def "Longest Consecutive one is a number"() {
    given:
    BitManipulation bitManipulation = new BitManipulation()

    when:
    int maxConsecuitveOnes = bitManipulation.longestConsecutiveOnesOfANumber(Integer.parseInt(number, 2));

    then:
    maxConsecuitveOnes == longestConsecutiveOnes

    where:
    number       | longestConsecutiveOnes
    "1011111000" | 5
    "1111111000" | 7
    "1101111000" | 4
  }

}
