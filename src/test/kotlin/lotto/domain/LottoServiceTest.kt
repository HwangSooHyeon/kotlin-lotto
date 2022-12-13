package lotto.domain

import lotto.model.Lotto
import lotto.model.Rating
import lotto.model.WinningLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoServiceTest {

    private val lottoService = LottoService()

    @Test
    fun `로또 번호 생성 테스트`() {
        val money = 14000
        assertThat(lottoService.makeLotto(14000).onEach { println(it.toString()) }).hasSize(14)
    }

    @Test
    fun `로또 당첨 확인 테스트`() {
        val lottos = listOf<Lotto>(
            Lotto(listOf(8, 21, 23, 41, 42, 43)),
            Lotto(listOf(3, 5, 11, 16, 32, 38)),
            Lotto(listOf(7, 11, 16, 35, 36, 44)),
            Lotto(listOf(1, 8, 11, 31, 41, 42)),
            Lotto(listOf(13, 14, 16, 38, 42, 45)),
            Lotto(listOf(7, 11, 30, 40, 42, 43)),
            Lotto(listOf(2, 13, 22, 32, 38, 45)),
            Lotto(listOf(1, 3, 5, 14, 22, 45))
        )
        val winningLotto = WinningLotto(Lotto(listOf(8, 21, 23, 41, 42, 43)), 1)
        assertThat(lottoService.checkRate(lottos, winningLotto).also { println(it.toString()) }).hasSize(8)
    }

    @Test
    fun `통계 계산 테스트`() {
        val winningRate = listOf<Rating>(
            Rating.FIFTH, Rating.LOSE, Rating.LOSE,
            Rating.LOSE, Rating.LOSE, Rating.LOSE,
            Rating.LOSE, Rating.LOSE
        )
        val money = 8000
        assertThat(lottoService.calculateStats(winningRate, money)).isEqualTo(62.5)
    }
}