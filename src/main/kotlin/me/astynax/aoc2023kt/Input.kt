package me.astynax.aoc2023kt

object Input {
  fun linesFrom(name: String): List<String> =
    requireNotNull(
      this::class.java.getResourceAsStream(name)?.bufferedReader()?.readLines()
    )
}
