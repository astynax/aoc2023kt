package me.astynax.aoc2023kt

private val Pair<Int, Int>.neighbors: Iterable<Pair<Int, Int>>
  get() = listOf(
    (first - 1) to (second - 1),
     first      to (second - 1),
    (first + 1) to (second - 1),
    (first - 1) to  second,
    (first + 1) to  second,
    (first - 1) to (second + 1),
     first      to (second + 1),
    (first + 1) to (second + 1),
  )

private fun Iterable<Int>.product(): Int = fold(1) { a, b -> a * b }

object Day03 {

  fun step1(lines: List<String>): Int = scan(lines) { c, ns ->
    if (!c.isDigit() && c != '.') ns.value
    else listOf()
  }

  fun step2(lines: List<String>): Int = scan(lines) { c, ns ->
    if (c == '*' && ns.value.size == 2)
      listOf(ns.value.product())
    else listOf()
  }

  private fun scan(
    lines: List<String>,
    step: (Char, Lazy<Set<Int>>) -> Iterable<Int>
  ): Int {
    val numbers = lines.map(::findNumbers)
    return lines.flatMapIndexed { y, row ->
      row.flatMapIndexed { x, c ->
        step(c, lazy {
          (x to y).neighbors.map { (nx, ny) ->
            numbers[ny][nx]
          }.filter { it != 0 }.toSet()
        })
      }
    }.sum()
  }

  fun findNumbers(line: String): List<Int> =
    (line + ' ').fold(
      listOf<Char>() to listOf<Int>()
    ) { (cs, ds), c ->
      when {
        c.isDigit() -> (cs + c) to ds
        cs.isNotEmpty() -> listOf<Char>() to (
            ds + cs.joinToString("").toInt().let { v ->
              List(cs.size) { _ -> v }
            } + 0
        )
        else -> cs to (ds + 0)
      }
    }.second.dropLast(1)

  val input = lazy { Input.linesFrom("/Day03.input") }
}
