package com.javarush.task.task39.task3908;

import org.junit.Assert;

public class SolutionTest {

	@org.junit.Test
	public void isPalindromePermutation() {
		boolean actual = Solution.isPalindromePermutation("abcaacb");
		Assert.assertTrue(actual);
		actual = Solution.isPalindromePermutation("abcaacbabcaacb");
		Assert.assertTrue(actual);
		actual = Solution.isPalindromePermutation("aaavvv");
		Assert.assertFalse(actual);
		actual = Solution.isPalindromePermutation("лазерборехеробрезал");
		Assert.assertTrue(actual);
		actual = Solution.isPalindromePermutation("a");
		Assert.assertTrue(actual);
		actual = Solution.isPalindromePermutation("AaB");
		Assert.assertTrue(actual);
		actual = Solution.isPalindromePermutation("CcC");
		Assert.assertTrue(actual);
	}
}