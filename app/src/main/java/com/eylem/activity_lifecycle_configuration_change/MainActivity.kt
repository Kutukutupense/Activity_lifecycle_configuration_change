package com.eylem.activity_lifecycle_configuration_change

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.eylem.activity_lifecycle_configuration_change.databinding.ActivityMainBinding

//configuration change: uygulama kullanılırken örneğin dikey moddan yatay moda alınması,
// dil dosyası değiştirilmesi vs gibi kullanıcı durumlarına verilen isimdir.Bu durumlarda activity
//lifecycle içinde on destroy çalıştırıldığı için kullanıcı configration change yaptığında
//bir edittext içine yazdığı veriler kaybolur.Bu sorunu nasıl çözeriz?
// lifecycle için kullanılan 2 fonksiyon var.

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
       binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }

    override fun onSaveInstanceState(outState: Bundle) { //bundle lar veri taşırken kullanılan torbalara benzer
        super.onSaveInstanceState(outState)
        val userField = binding.editText.text.toString() // userfield değişkenine edittext in yazısını verdik. ve string e çevirdik
        outState.putString("userField",userField) //outstate parametresine userField değişkenini verdik.
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) { //koyduğumuz datayı burada alacağız
        super.onRestoreInstanceState(savedInstanceState)
       val userField =  savedInstanceState.getString("userField") //getString metodu ile önceki fonksiyonda koyduğumuz veriyi alıyoruz
       binding.editText.setText(userField) //edittext e setText metodu ile aldığımız userField ı verdik.

    }
    //ve artık edittext içindeki yazı dikey moddan yatay moda da alınsa kaybolmuyor.
}

