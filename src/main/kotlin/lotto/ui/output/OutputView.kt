package lotto.ui.output

import lotto.model.Rating

enum class LottoMessages(private val message: String) {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    NUMBERS_OF_PURCHASED("개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATS("당첨 통계"),
    DIVIDER("---"),
    FIFTH("3개 일치 (5,000원) - "),
    FOURTH("4개 일치 (50,000원) - "),
    THIRD("5개 일치 (1,500,000원) - "),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST("6개 일치 (2,000,000,000원) - "),
    TOTAL_STATS("총 수익률은 "),
    COUNT("개"),
    PERCENT_IS("%입니다.");

    override fun toString(): String = message
}

class OutputView {

    fun printInputMoney() = println(LottoMessages.INPUT_MONEY.toString())

    fun printPurchased(count: Int) = println("${count}${LottoMessages.NUMBERS_OF_PURCHASED}")

    fun printInputWinningNumbers() = println(LottoMessages.INPUT_WINNING_NUMBERS.toString())

    fun printInputBonusNumber() = println(LottoMessages.INPUT_BONUS_NUMBER.toString())

    fun printWinningStats(rates: List<Rating>, totalStats: Double) {
        println(LottoMessages.WINNING_STATS.toString())
        println(LottoMessages.DIVIDER.toString())
        println("${LottoMessages.FIFTH}${rates.count { it == Rating.FIFTH }}${LottoMessages.COUNT}")
        println("${LottoMessages.FOURTH}${rates.count { it == Rating.FOURTH }}${LottoMessages.COUNT}")
        println("${LottoMessages.THIRD}${rates.count { it == Rating.THIRD }}${LottoMessages.COUNT}")
        println("${LottoMessages.SECOND}${rates.count { it == Rating.SECOND }}${LottoMessages.COUNT}")
        println("${LottoMessages.FIRST}${rates.count { it == Rating.FIRST }}${LottoMessages.COUNT}")
        println("${LottoMessages.TOTAL_STATS}${totalStats}${LottoMessages.PERCENT_IS}")
    }
}