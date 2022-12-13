package lotto.model

enum class Rating(private val prize: Int) {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    LOSE(0);

    fun getPrize(): Int = prize

    override fun toString(): String = name
}