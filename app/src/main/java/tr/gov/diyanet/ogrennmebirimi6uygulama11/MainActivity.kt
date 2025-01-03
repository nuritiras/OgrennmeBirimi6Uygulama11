package tr.gov.diyanet.ogrennmebirimi6uygulama11

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import tr.gov.diyanet.ogrennmebirimi6uygulama11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var gorselArrayList=ArrayList<Gorsel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val balon=Gorsel("Sarı Balon",1,R.drawable.balon)
        val cicek=Gorsel("Mavi Çiçek",2,R.drawable.cicek)
        val kelebek=Gorsel("Yeşil Kelebek",3,R.drawable.kelebek)
        val kus=Gorsel("Mor Kuş",4,R.drawable.kus)

        gorselArrayList.add(balon)
        gorselArrayList.add(cicek)
        gorselArrayList.add(kelebek)
        gorselArrayList.add(kus)

        binding.imageView.setImageResource(gorselArrayList[0].foto)
        binding.textBilgi.text=gorselArrayList[0].bilgi

        binding.ileriGitme.setOnClickListener {
            if(gorselArrayList[0].siraNo==gorselArrayList.size){
                gorselArrayList[0].siraNo=0

            }
            gorselArrayList[0].siraNo++
            binding.imageView.setImageResource(gorselArrayList[gorselArrayList[0].siraNo-1].foto)
            binding.textBilgi.text=gorselArrayList[gorselArrayList[0].siraNo-1].bilgi
        }

    }

    fun onClickGeri(view: View) {
        if(gorselArrayList[0].siraNo==1){
            gorselArrayList[0].siraNo=gorselArrayList.size
        }
        gorselArrayList[0].siraNo--
        binding.imageView.setImageResource(gorselArrayList[gorselArrayList[0].siraNo].foto)
        binding.textBilgi.text=gorselArrayList[gorselArrayList[0].siraNo].bilgi
    }
}