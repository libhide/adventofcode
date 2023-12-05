package advent2023

private const val COLON_DELIMITER = ":"

class Day05(private val input: String) {

    fun solvePart1(): Long {
        // Since the transformations are a chain, they can be overwritten
        var seeds = input
            .substringBefore("\n\n")
            .substringAfter(COLON_DELIMITER)
            .split(" ")
            .filter { it.isNotEmpty() }
            .map { it.toLong() }
            .toMutableList()

        val transformationChunks = parseInput()

        transformationChunks.forEach { transformationChunk ->
            seeds = seeds.map { seed ->
                transformationChunk.map { transformation ->
                    val (destinationStart, sourceStart, rangeLength) = transformation
                    if (seed in sourceStart until sourceStart + rangeLength) {
                        destinationStart + (seed - sourceStart)
                    } else {
                        Long.MIN_VALUE
                    }
                }.firstOrNull { it != Long.MIN_VALUE } ?: seed
            }.toMutableList()
        }
        return seeds.minOf { it }
    }

    fun solvePart2(): Long {
        val inputs = input
            .substringBefore("\n\n")
            .substringAfter(COLON_DELIMITER)
            .split(" ")
            .filter { it.isNotEmpty() }
            .map { it.toLong() }
            .toMutableList()

        var seeds = mutableListOf<List<Long>>()
        for (i in 0 until inputs.size step 2) {
            seeds.add(listOf(inputs[i], inputs[i] + inputs[i + 1]))
        }

        val transformationChunks = parseInput()

        transformationChunks.forEach { transformationChunk ->
            val updatedSeeds = mutableListOf<List<Long>>()
            while (seeds.size > 0) {
                val (start, end) = seeds.removeLast()
                var didBreak = false
                for (transformation in transformationChunk) {
                    val (destinationStart, sourceStart, rangeLength) = transformation
                    val overlapStart = maxOf(start, sourceStart)
                    val overlapEnd = minOf(end, sourceStart + rangeLength)
                    if (overlapStart < overlapEnd) {
                        updatedSeeds.add(
                            listOf(
                                overlapStart - sourceStart + destinationStart,
                                overlapEnd - sourceStart + destinationStart
                            )
                        )
                        if (overlapStart > start) {
                            seeds.add(listOf(start, overlapStart))
                        }
                        if (end > overlapEnd) {
                            seeds.add(listOf(overlapEnd, end))
                        }
                        didBreak = true
                        break
                    }
                }
                if (!didBreak) {
                    updatedSeeds.add(listOf(start, end))
                }
            }
            seeds = updatedSeeds
        }
        seeds.sortBy { it.first() }
        return seeds.first().first()
    }

    private fun parseInput(): List<List<Triple<Long, Long, Long>>> {
        return input.split("\n\n").drop(1).map { transformationChunk ->
            transformationChunk.lines().drop(1).map { transformationLine ->
                val (destinationStart, sourceStart, rangeLength) = transformationLine
                    .split(" ")
                    .filter { it.isNotEmpty() }
                    .map { it.toLong() }
                Triple(destinationStart, sourceStart, rangeLength)
            }
        }
    }
}

fun main() {
    val input = Resources.resourceAsText("advent2023/day05.txt")
    val day05 = Day05(input = input)
    println("Part 1 Solution: ${day05.solvePart1()}")
    println("Part 2 Solution: ${day05.solvePart2()}")
}