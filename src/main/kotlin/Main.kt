fun main() {
    val cardType =  CardType.Mastercard
    val monthlyTransfer = 25_000
    val transfer = 50_000

    val commission = commissionCalculation(cardType = cardType.toString(), transfer = transfer, monthlyTransfer = monthlyTransfer)
    println ("Коммиссия при переводе с карты: $cardType, составит: $commission")

}

enum class CardType {
    Mastercard,
    Maestro,
    Visa,
    Mir,
    VKPay


}

fun commissionCalculation(cardType: String = "VK Pay", monthlyTransfer: Int = 0, transfer: Int) : Int {
    val freeLimit = 75_000
    val transactionAmount = monthlyTransfer + transfer
    val commissionForMastercardMaestro = 0.006
    val minCommissionForMastercardMaestro = 20
    val commissionForVisaMir = 0.0075
    val minCommissionForVisaMir = 35
    val finalCommissionForVisaMir = transactionAmount * commissionForVisaMir

    return when(cardType) {
        CardType.Mastercard.toString(), CardType.Maestro.toString() -> if (transactionAmount > freeLimit) ((transactionAmount * commissionForMastercardMaestro) + minCommissionForMastercardMaestro).toInt() else 0
        CardType.Visa.toString(), CardType.Mir.toString() -> if (finalCommissionForVisaMir > minCommissionForVisaMir) finalCommissionForVisaMir.toInt() else minCommissionForVisaMir
        else -> 0
    }
}