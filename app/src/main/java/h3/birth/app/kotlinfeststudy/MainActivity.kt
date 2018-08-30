package h3.birth.app.kotlinfeststudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import h3.birth.app.kotlinfeststudy.session.A1AndroidQualityforKotlin

class MainActivity : AppCompatActivity() {

    private val study_session_index: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        study(study_session_index)
    }

    fun study(study_session_index: Int) {
        when (study_session_index) {
            1 -> {
                val A1AndroidQualityforKotlin = A1AndroidQualityforKotlin()
                A1AndroidQualityforKotlin.studyDoCompareValueBy()
            }
        }
    }
}
