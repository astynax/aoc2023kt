package me.astynax.aoc2023kt

import kotlin.math.pow
import kotlin.math.roundToInt

object Day04 {
  data class Game(val id: Int, val points: Int) {

    companion object {
      private val space = Regex("\\s+")
      private val pipe = Regex(" \\| ")
      fun fromString(s: String): Game {
        val halves = s.split(pipe)
        val left = halves.first().split(space).drop(1)
        val right = halves.last().split(space)
        val ws = left.drop(1).toSet()
        return Game(
          id = left.first().dropLast(1).toInt(),
          points = right.count { it in ws }
        )
      }
    }
  }

  fun step1(games: List<Game>): Int =
    games.sumOf { if (it.points > 0) 2.0.pow(it.points.dec()).roundToInt() else 0 }

  fun step2(games: List<Game>): Int {
    val points = games.associate { it.id to it.points }
    val ids = games.map { it.id }.toIntArray()
    val counts = ids.associateWith { 1 }.toMutableMap()
    for ((idx, id) in ids.withIndex()) {
      val n = counts[id]!!
      val m = points[id]!!
      for (k in ids.slice(idx + 1 .. idx + m)) {
        counts.replace(k, counts[k]!! + n)
      }
    }
    return counts.values.sum()
  }

  val input = lazy { Input.linesFrom("/Day04.input").map(Game::fromString) }
}
