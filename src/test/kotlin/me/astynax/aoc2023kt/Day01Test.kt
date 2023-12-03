package me.astynax.aoc2023kt

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day01Test {
  @Test
  fun `step1 on example`() {
    assertEquals(142, Day01.step1("""
      1abc2
      pqr3stu8vwx
      a1b2c3d4e5f
      treb7uchet""".trimIndent().lines()
    ))
  }

  @Test
  fun `step1 on input`() {
    assertEquals(53921, Day01.step1(Day01.input.value))
  }

  @Test
  fun `step2 on example`() {
    assertEquals(281, Day01.step2("""
      two1nine
      eightwothree
      abcone2threexyz
      xtwone3four
      4nineeightseven2
      zoneight234
      7pqrstsixteen""".trimIndent().lines()
    ))
  }

  @Test
  fun `step2 on input`() {
    assertEquals(54676, Day01.step2(Day01.input.value))
  }
}
