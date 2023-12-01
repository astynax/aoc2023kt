package me.astynax.aoc2023kt

import org.junit.jupiter.api.Test

class InputTest {

  @Test
  fun linesFrom() {
    assert(Input.linesFrom("/Day01.input").isNotEmpty())
  }
}
