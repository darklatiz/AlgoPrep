package mx.com.geekflu.algo.prep

import mx.com.geekflu.algo.prep.data.leetcode.Helpers
import mx.com.geekflu.algo.prep.data.leetcode.RemoveVowelsFromString
import mx.com.geekflu.algo.prep.data.leetcode.RunningSum1DArray
import spock.lang.Specification
import spock.lang.Unroll

class LeetCodeEasySpec extends Specification {

    @Unroll
    def "Remove Vowels from String"() {
        given:
        RemoveVowelsFromString removeVowelsFromString = new RemoveVowelsFromString()

        when:
        String result = removeVowelsFromString.removeVowels(testCase)

        then:
        result == resultCase
        where:
        testCase                        | resultCase
        "leetcodeisacommunityforcoders" | "ltcdscmmntyfrcdrs"
        "aeiou"                         | ""
        "AaeEiIoOuU"                    | ""

    }

    @Unroll
    def "Running sum 1D Array"() {
        given:
        RunningSum1DArray runningSum1DArray = new RunningSum1DArray()
        int[] nums = Helpers.createArrayFromString(testCase, ",")

        when:
        int[] res = runningSum1DArray.runningSum(nums)

        then:
        resultCase == Helpers.createStringFromArray(res, ",")
        where:
        testCase  | resultCase
        "1,1,1,1" | "1,2,3,4"
        "1,2,3,4" | "1,3,6,10"
    }

}
