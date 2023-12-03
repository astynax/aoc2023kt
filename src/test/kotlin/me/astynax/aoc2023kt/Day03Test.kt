package me.astynax.aoc2023kt

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day03Test {

  @Test
  fun `find numbers`() {
    assertEquals(listOf(1), Day03.findNumbers("1"))
    assertEquals(listOf(0), Day03.findNumbers("."))
    assertEquals(
      listOf(0, 12, 12, 0, 0, 543, 543, 543, 0, 0),
      Day03.findNumbers(".12.*543#.")
    )
  }

  private val example = """
    467..114..
    ...*......
    ..35..633.
    ......#...
    617*......
    .....+.58.
    ..592.....
    ......755.
    ...$.*....
    .664.598..""".trimIndent().lines()

  @Test
  fun `step1 on example`() {
    assertEquals(4361, Day03.step1(example))
  }

  @Test
  fun `step1 on input`() {
    assertEquals(537832, Day03.step1(Day03.input.value))
  }

  @Test
  fun `step2 on example`() {
    assertEquals(467835, Day03.step2(example))
  }

  @Test
  fun `step2 on input`() {
    assertEquals(81939900, Day03.step2(Day03.input.value))
  }

}
