import domain.entities.Account
import domain.entities.CPF

fun fetchAccounts(batch: Int): List<Account> {
    return mutableListOf<Account>().apply {
        for (i in 0 until batch) {
            add(
                Account(
                    "Person $i", CPF("$i"),
                    "ALKSASLKFHA9",
                    "lakw4nlaW4KQEIT"
                )
            )
        }
    }
}