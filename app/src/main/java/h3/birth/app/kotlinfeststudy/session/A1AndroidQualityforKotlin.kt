package h3.birth.app.kotlinfeststudy.session

import android.util.Log
import h3.birth.app.kotlinfeststudy.dataclass.Person

/**
 * Created by kako_351 on 2018/08/28.
 */
class A1AndroidQualityforKotlin {

    val LOG_TAG: String = "SESSIONA1"

    fun studyDoCompareValueBy() {
        val tanaka = Person("田中", 23)
        val yamada = Person("山田", 30)
        val persons: List<Person> = listOf(yamada, tanaka)
        Log.i(LOG_TAG, "before=" + persons.toString())

        val afterPersons = persons.sorted()
        Log.i(LOG_TAG, "after=" + afterPersons.toString())
    }
}