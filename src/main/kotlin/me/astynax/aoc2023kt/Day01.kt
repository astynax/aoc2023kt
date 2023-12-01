package me.astynax.aoc2023kt

object Day01 {

  fun step1(lines: List<String>): Int =
    lines.sumOf {
      it.filter(Char::isDigit).let { digits ->
        digits.first().digitToInt() * 10 + digits.last().digitToInt()
      }
    }

  fun step2(lines: List<String>): Int =
    lines.sumOf { line ->
      val ds = line.indices.mapNotNull { i ->
        digitKeys.find { line.startsWith(it, startIndex = i) }
          ?.let(digitValues::get)
      }
      ds.first() * 10 + ds.last()
    }

  val input = lazy { Input.linesFrom("/Day01.input") }

  private val digitValues = listOf(
    "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
  ).flatMapIndexed { i: Int, s: String ->
    val v = i + 1
    listOf(s to v, v.toString() to v)
  }.toMap()

  private val digitKeys = digitValues.keys
}
