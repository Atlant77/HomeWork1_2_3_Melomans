fun main() {
    val itemPrice = 11000 // Стоимость одной покупки
    val itemCount = 2 // Количество покупок
    val discountStandart = 100 // Если предыдущая сумма покупок от 1 001 до 10 000 рублей,
    // то стандартная скидка - 100 рублей (как в лекции).
    val discountBestBayer = 0.05 // Если предыдущая сумма покупок от 10 001 рубль и выше то % составляет 5% от суммы.
    val discountRegularClient = 0.01 // Если предыдущая сумма покупок от 10 001 рубль и выше то % составляет 5% от суммы.
    val discountStart = 1_000 // Сумма начала применения скидок
    val regularClient = true // Постоянный клиент (false or true)

    var totalPrice: Int = itemPrice * itemCount // Подсчет полной стоимости покупки
    var totalPriceWithDiscount: Int = 0 // Переменная для расчета полной скидки покупки по всем условиям

    if (totalPrice <= discountStart) {
        println("Сумма Ваших покупок $totalPrice Вы купили менее 1000 руб., спасибо, но скидка Вам не полагается.")
    } else if (totalPrice > 1_001 && totalPrice<10_000) {
        totalPriceWithDiscount = totalPrice - discountStandart
        println("Сумма Ваших покупок $totalPrice руб., Ваша скидка $discountStandart руб. " +
                "ИТОГО: $totalPriceWithDiscount руб.")
    } else if (totalPrice >= 10_001)  {
        totalPriceWithDiscount = (totalPrice * discountBestBayer).toInt()
        println("Сумма Ваших покупок $totalPrice руб., Ваша скидка $totalPriceWithDiscount руб. " +
                "ИТОГО: ${totalPrice - totalPriceWithDiscount} руб.")
    }

    // Дополнительный расчет скидки для постоянных клиентов
    if (regularClient == true) {
        totalPriceWithDiscount = (totalPriceWithDiscount * discountRegularClient).toInt()
        println("Вы наш постоянный клиент, поэтому для Вас дополнительная скидка $totalPriceWithDiscount руб. " +
                "ИТОГО: ${totalPrice - totalPriceWithDiscount} руб.")
    }
}