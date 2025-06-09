package com.example.bankinguiapp.homeDesign.random

import org.junit.Assert.*
import org.junit.Test

class RandomKtTest {


    @Test
    fun isPalindrome() {

        assertTrue(isPalindrome("madam"))
        assertFalse(isPalindrome("hello"))
        assertTrue(isPalindrome(""))

    }

}