package h3.birth.app.kotlinfeststudy.dataclass

/**
 * Created by  on 2018/08/30.
 */
class Profile(val name: String = "jack")
fun loadProfile(): Profile {
    Thread.sleep(1000)
    return Profile()
}