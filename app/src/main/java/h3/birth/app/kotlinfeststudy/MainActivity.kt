package h3.birth.app.kotlinfeststudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import h3.birth.app.kotlinfeststudy.dataclass.loadProfile
import h3.birth.app.kotlinfeststudy.session.A1AndroidQualityforKotlin
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

class MainActivity : AppCompatActivity() {

    private val study_session_index: Int = 1 // or 4 セッションのコマを指定します

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        study(study_session_index)
    }

    fun study(study_session_index: Int) {
        when (study_session_index) {
            1 -> { // A1セッション「Kotlin で改善する Android アプリの品質」のサンプル実行
                val A1AndroidQualityforKotlin = A1AndroidQualityforKotlin()
                A1AndroidQualityforKotlin.studyDoCompareValueBy()
            }
            4 -> { // B4 セッション「Kotlin コルーチンを理解しよう」のサンプル実行
                launch(UI) {
                    progressBar.visibility = View.VISIBLE
                    val profile = async { loadProfile() }.await()
                    textView.text = profile.name
                    progressBar.visibility = View.GONE
                }
            }
        }
    }
}
