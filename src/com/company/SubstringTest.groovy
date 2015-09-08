package com.company

/**
 * Created by Javan on 9/8/15.
 */
class SubstringTest extends groovy.util.GroovyTestCase {
    void testGetLongestRepeatedSubstring() {
        def input = "abcabcd"
        def result = Substring.GetLongestRepeatedSubstring(input)
        assertTrue(result.contains("abc"))
    }
}
