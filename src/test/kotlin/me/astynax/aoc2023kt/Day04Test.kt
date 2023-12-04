package me.astynax.aoc2023kt

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day04Test {
  private val example = """
    Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
    Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
    Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
    Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
    Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
    Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11
  """.trimIndent().lines().map(Day04.Game::fromString)

  @Test
  fun decoding() {
    assertEquals(Day04.Game(1, 4), example.first())
  }

  @Test
  fun `step1 on example`() {
    assertEquals(13, Day04.step1(example))
  }

  @Test
  fun `step1 on input`() {
    assertEquals(18619, Day04.step1(Day04.input.value))
  }

  @Test
  fun `step2 on example`() {
    assertEquals(30, Day04.step2(example))
  }

  @Test
  fun `step2 on input`() {
    assertEquals(8063216, Day04.step2(Day04.input.value))
  }
}
