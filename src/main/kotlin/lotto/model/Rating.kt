package lotto.model

enum class Rating(private val prize: Int, private val hit: Int) {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5);
}