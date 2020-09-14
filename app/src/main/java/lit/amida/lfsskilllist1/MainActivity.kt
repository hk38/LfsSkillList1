package lit.amida.lfsskilllist1

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.content.edit
import coil.api.load
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SkillList:TextView
        textView.text = "SkillList TextView"
        textView.setTextColor(Color.rgb(40, 200, 200))

        //SkillList:Button
        var count = 0
        button.setOnClickListener {
            count++
            button.text = count.toString()
        }

        //SkillList:ImageView
        val url = "https://free-materials.com/adm/wp-content/uploads/2020/07/adpDSC_6758-760x507-1.jpg"
        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.load(url)

        // skillList:EditText
        buttonShow.setOnClickListener {
            if(editText.text != null) textView.text = editText.text.toString()
        }

        //SkillList:SharedPreferences
        val dataStore = getSharedPreferences("DataStore", Context.MODE_PRIVATE)
        buttonSave.setOnClickListener {
            val txt = editText.text.toString()
            textView.text = txt
            dataStore.edit {
                putString("Input", txt)
                apply()
            }
        }
        buttonLoad.setOnClickListener {
            textView.text = dataStore.getString("Input", "NoData")
        }

    }
}