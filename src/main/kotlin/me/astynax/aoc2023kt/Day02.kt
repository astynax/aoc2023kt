package me.astynax.aoc2023kt

object Day02 {

  data class Take(val r: Int, val g: Int, val b: Int) {
    infix fun contains(other: Take): Boolean =
      r >= other.r && g >= other.g && b >= other.b

    private infix fun Int.max(other: Int): Int =
      if (this >= other) this else other

    infix fun max(other: Take): Take =
      Take(r max other.r, g max other.g, b max other.b)
  }

  private val bag = Take(12, 13, 14)

  fun step1(games: List<Pair<Int, List<Take>>>): Int =
    games.filter { (_, ts) ->
      ts.all { bag contains it }
    }.sumOf { it.first }

  fun step2(games: List<Pair<Int, List<Take>>>): Int =
    games.sumOf { (_, takes) ->
      takes.fold(Take(1, 1, 1)) { acc, t -> acc max t }
        .let { t -> t.r * t.g * t.b }
    }

  val input = lazy { Input.linesFrom("/Day02.input").map { it.asGame() } }

  fun String.asGame(): Pair<Int, List<Take>> =
    this.split(Regex(": ")).let { m ->
      val id = m.first().removePrefix("Game ").toInt()
      val takes = m.last().split(Regex("; ")).map { take ->
        take.split(Regex(", ")).fold(Take(0, 0, 0)) { acc, s ->
          val part = s.split(" ")
          val n = part.first().toInt()
          when (part.last()) {
            "red" -> acc.copy(r = n)
            "green" -> acc.copy(g = n)
            "blue" -> acc.copy(b = n)
            else -> throw IllegalArgumentException("Bad line part: $s")
          }
        }
      }
      id to takes
    }
}
