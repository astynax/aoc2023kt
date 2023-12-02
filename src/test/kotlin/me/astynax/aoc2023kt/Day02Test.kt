package me.astynax.aoc2023kt

import org.junit.jupiter.api.*

import me.astynax.aoc2023kt.Day02.asGame
import me.astynax.aoc2023kt.Day02.Take
import me.astynax.aoc2023kt.Day02.step1
import me.astynax.aoc2023kt.Day02.step2
import me.astynax.aoc2023kt.Day02.input

class Day02Test {
  @Test
  fun `asGame on example`() {
    assert(
      "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"
        .asGame() == (
          3 to listOf(
            Take(20, 8, 6),
            Take(4, 13, 5),
            Take(1, 5, 0),
          ))
    )
  }

  @Test
  fun `input parsing`() {
    assert(input.value.isNotEmpty())
  }

  @Test
  fun `take comparison`() {
    assert(Take(3, 4, 5) contains Take(3, 4, 5))
    assert(Take(5, 5, 5) contains Take(3, 4, 5))
    assert(!(Take(3, 4, 5) contains Take(4, 4, 5)))
  }

  private val example =
    """|Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
       |Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
       |Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
       |Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
       |Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"""
      .trimMargin().lines().map { it.asGame() }

  @Test
  fun `step1 on example`() {
    assert(step1(example) == 8)
  }

  @Test
  fun `step1 on input`() {
    assert(step1(input.value) == 2085)
  }

  @Test
  fun `step2 on example`() {
    assert(step2(example) == 2286)
  }

  @Test
  fun `step2 on input`() {
    assert(step2(input.value) == 79315)
  }
}
