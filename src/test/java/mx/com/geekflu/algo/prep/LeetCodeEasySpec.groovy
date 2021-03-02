package mx.com.geekflu.algo.prep

import mx.com.geekflu.algo.prep.data.leetcode.CountItemsMatchingTheRule
import mx.com.geekflu.algo.prep.data.leetcode.DefangingIPAddress
import mx.com.geekflu.algo.prep.data.leetcode.Helpers
import mx.com.geekflu.algo.prep.data.leetcode.KidsWithTheGreatestNumberOfCandies
import mx.com.geekflu.algo.prep.data.leetcode.RemoveVowelsFromString
import mx.com.geekflu.algo.prep.data.leetcode.RichestCustomerWealth
import mx.com.geekflu.algo.prep.data.leetcode.RunningSum1DArray
import mx.com.geekflu.algo.prep.data.leetcode.ShuffleTheArray
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

    def "Defanging IP Addresses"() {
        given:
        DefangingIPAddress defangingIPAddress = new DefangingIPAddress()

        when:
        String result = defangingIPAddress.defangIPaddr(testCase)

        then:
        result == resultCase

        where:
        testCase       | resultCase
        "1.1.1.1"      | "1[.]1[.]1[.]1"
        "255.100.50.0" | "255[.]100[.]50[.]0"
    }

    def "Kids With The Greatest Number Of Candies"() {
        given:
        KidsWithTheGreatestNumberOfCandies kidsCandies = new KidsWithTheGreatestNumberOfCandies()
        int[] candies = Helpers.createArrayFromString(testCase, ",")

        when:
        List<Boolean> result = kidsCandies.kidsWithCandies(candies, extraCandies)

        then:
        resultCase == Helpers.createStringFromList(result, ",")

        where:
        testCase    | extraCandies | resultCase
        "2,3,5,1,3" | 3            | "true,true,true,false,true"
        "4,2,1,1,2" | 1            | "true,false,false,false,false"
        "12,1,12"   | 10           | "true,false,true"
    }

    @Unroll
    def "Shuffle The Array"() {
        given:
        ShuffleTheArray shuffleTheArray = new ShuffleTheArray()
        int[] nums = Helpers.createArrayFromString(testCase, ",")

        when:
        int[] res = shuffleTheArray.shuffle(nums, n)

        then:
        resultCase == Helpers.createStringFromArray(res, ",")
        where:
        testCase          | n | resultCase
        "2,5,1,3,4,7"     | 3 | "2,3,5,4,1,7"
        "1,2,3,4,4,3,2,1" | 4 | "1,4,2,3,3,2,4,1"
    }

    def "Count Items Matching The Rule"() {
        given:
        CountItemsMatchingTheRule itemsMatchingTheRule = new CountItemsMatchingTheRule()

        when:
        int matches = itemsMatchingTheRule.countMatches(Helpers.createListOfListsFromString(rawData, ",", "#"), ruleKey, ruleValue)

        then:
        matches == resultMatches

        where:
        rawData                                                                      | resultMatches | ruleKey | ruleValue
        "phone,blue,pixel#phone,blue,pixel#computer,silver,lenovo#phone,gold,iphone" | 1             | "color" | "silver"
        "phone,blue,pixel#computer,silver,phone#phone,gold,iphone"                   | 2             | "type"  | "phone"
    }

    def "Richest Customer Wealth"() {
        given:
        RichestCustomerWealth customerWealth = new RichestCustomerWealth()

        when:
        int num = customerWealth.maximumWealth(Helpers.create2dIntArray(rawData, ",", "#"))

        then:
        num == resultMatches
        where:
        rawData             | resultMatches
        "1,2,3#3,2,1"       | 6
        "1,7#7,3#3,5"       | 10
        "2,8,7#7,1,3#1,9,5" | 17
    }

}
