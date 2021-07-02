package pl.lodz.uni.eksoc.project_2

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class user_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_activity)
        val actionBar = supportActionBar
        val textView_name: TextView = findViewById(R.id.name)
        val textView_kils: TextView = findViewById(R.id.kils)
        


        val image: ImageView = findViewById(R.id.imageView)


        val textView_winratio: TextView = findViewById(R.id.winratio)
        val textView_favchamp: TextView = findViewById(R.id.favoritechamp)


        val get_name = intent.getStringExtra("Name")
        val get_w1 = intent.getStringExtra("wl1")
        val get_w2 = intent.getStringExtra("wl2")
        val get_w3 = intent.getStringExtra("wl3")
        val get_champ1 = intent.getStringExtra("champ1")
        val get_champ2 = intent.getStringExtra("champ2")
        val get_champ3 = intent.getStringExtra("champ3")
        val get_kda1 = intent.getStringExtra("kda1").toString().toInt()
        val get_kda2 = intent.getStringExtra("kda2").toString().toInt()
        val get_kda3 = intent.getStringExtra("kda3").toString().toInt()


        val wins = listOf(get_w1, get_w2, get_w3) as List<String>
        val champs = listOf(get_champ1, get_champ2, get_champ3) as List<String>
        val maxOccurring = champs.groupBy { it }.mapValues { it.value.size }.maxBy { it.value }?.key
        val kils = kil_count(get_kda1, get_kda2, get_kda3)
        val winratio = winratio(wins)

        actionBar!!.title = get_name
        textView_name.text = get_name


        if (maxOccurring.toString() == "Draven") {
            image.setImageResource(R.drawable.draven)
        } else if (maxOccurring.toString() == "Ezreal") {
            image.setImageResource(R.drawable.ezreal)
        } else if (maxOccurring.toString() == "Jhin") {
            image.setImageResource(R.drawable.jhin)
        } else if (maxOccurring.toString() == "Jinx") {
            image.setImageResource(R.drawable.jinx)
        } else if (maxOccurring.toString() == "Kai'Sa") {
            image.setImageResource(R.drawable.kaisa)
        } else if (maxOccurring.toString() == "Kalista") {
            image.setImageResource(R.drawable.kalista)
        } else if (maxOccurring.toString() == "Kog'Maw") {
            image.setImageResource(R.drawable.kogmaw)
        } else if (maxOccurring.toString() == "Lucian") {
            image.setImageResource(R.drawable.lucian)
        } else if (maxOccurring.toString() == "Miss Fortune") {
            image.setImageResource(R.drawable.missfortune)
        } else if (maxOccurring.toString() == "Quinn") {
            image.setImageResource(R.drawable.quinn)
        }

            textView_kils.text = kils.toString()
            textView_winratio.text = winratio.toString()
            textView_favchamp.text = maxOccurring.toString()



        }

        private fun kil_count(kil1: Int, kil2: Int, kil3: Int): Float {
            var result = (kil1.toFloat() + kil2.toFloat() + kil3.toFloat()) / 3
            return "%.${2}f".format(result).toFloat()
        }

        private fun winratio(games: List<String>): Float {
            var winratio = 0.0
            for (item: String in games) {
                if (item == "Win") {
                    winratio += 1.0
                }
            }
            winratio = winratio / 3 * 100
            return "%.${2}f".format(winratio).toFloat()
        }
    }