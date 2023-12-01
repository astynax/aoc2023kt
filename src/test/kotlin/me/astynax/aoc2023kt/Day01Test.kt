package me.astynax.aoc2023kt

import org.junit.jupiter.api.*

class Day01Test {
  @Test
  fun `step1 on example`() {
    assert(Day01.step1(
      """|1abc2
         |pqr3stu8vwx
         |a1b2c3d4e5f
         |treb7uchet"""
        .trimMargin().lines()
    ) == 142)
  }

  @Test
  fun `step1 on input`() {
    assert(Day01.step1(Day01.input.value) == 53921)
  }

  @Test
  fun `step2 on example`() {
    assert(Day01.step2(
      """|two1nine
         |eightwothree
         |abcone2threexyz
         |xtwone3four
         |4nineeightseven2
         |zoneight234
         |7pqrstsixteen"""
        .trimMargin().lines()
    ) == 281)
  }

  @Test
  fun `step2 on input`() {
    assert(Day01.step2(Day01.input.value) == 54676)
  }
}
