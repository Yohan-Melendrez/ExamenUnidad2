package yohan.melendrez.thecheezery

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        val btncold: Button = findViewById(R.id.botonCold)
        val btnHot: Button = findViewById(R.id.botonHot)
        val btnSweets: Button = findViewById(R.id.botonSweets)
        val btnSalties: Button = findViewById(R.id.botonSalties)

        btncold.setOnClickListener {
            val intent = Intent(this, Productos::class.java)
            intent.putExtra("menuType", "cold")
            startActivity(intent)
        }
        btnHot.setOnClickListener {
            val intent = Intent(this, Productos::class.java)
            intent.putExtra("menuType", "hot")
            startActivity(intent)
        }
        btnSweets.setOnClickListener {
            val intent = Intent(this, Productos::class.java)
            intent.putExtra("menuType", "sweet")
            startActivity(intent)
        }
        btnSalties.setOnClickListener {
            val intent = Intent(this, Productos::class.java)
            intent.putExtra("menuType", "salt")
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}