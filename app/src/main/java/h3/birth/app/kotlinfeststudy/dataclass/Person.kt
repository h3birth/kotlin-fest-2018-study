package h3.birth.app.kotlinfeststudy.dataclass

/**
 * Created by kako_351 on 2018/08/28.
 */
data class Person(val name: String, val age: Int) : Comparable<Person>{
    // 年齢昇順
    override fun compareTo(other: Person): Int {
        return compareValuesBy(this, other, { it.age }, { it.name })
    }
}