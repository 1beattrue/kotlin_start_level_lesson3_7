var name: String? = null

fun main() {
    // функция let

    if (name?.length?.compareTo(5) == 1) { // громоздкий способ
        println("yes")
    }

    // другой способ
    // if (name == null) return
    /* if (name.length > 5) println("yes") ошибка, так как переменная name не является локальной =>
                                           может быть изменена из другого потока */

    // правильный способ
    name?.let { if (it.length > 5) println("yes") } // если переменная name == null, просто не выполнится функция


    // функция with

    val list = mutableListOf<Int>()

    with(list) {
        // также можно обращаться к списку здесь через this

        for (i in 0..<1000) {
            list.add((Math.random() * 100).toInt())
        }

        // теперь выведем некоторую информацию об этом списке
        println(
            "Сумма: ${sum()}\n" +
                    "Среднее значение: ${average()}\n" +
                    "Максимальное значение: ${max()}\n" +
                    "Минимальное значение: ${min()}\n" +
                    "Первый элемент: ${first()}\n" +
                    "Последний элемент: ${last()}"
        )
    }

    println()
    funHw()
}

// домашнее задание

val listHw: MutableList<Int>? = mutableListOf()

fun funHw() {
    listHw?.let {
        with(it) {
            for (i in 0..<1000) {
                add((Math.random() * 100).toInt())
            }
            println(filter { it % 2 == 0 }.take(100))
        }
    }

}