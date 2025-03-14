package yohan.melendrez.thecheezery

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Productos : AppCompatActivity() {
    var adapter: ProductoAdapter? = null
    var productos = ArrayList<producto>()
    var menu:ArrayList<producto> = ArrayList<producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_productos)
        var menuOption:String?= intent.getStringExtra("menuType")
        cargarProductos(imageView = findViewById(R.id.img_Producto),menuOption)
        adapter = ProductoAdapter(this, productos)
        var gridPelis: GridView = findViewById(R.id.ListaProductos)
        gridPelis.adapter = adapter
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun cargarProductos(imageView: ImageView, option: String?) {
        when (option) {
            "hot" -> {
                imageView.setImageResource(R.drawable.hotdrinks)
                productos.add(producto("Latte", R.drawable.latte, 6.0))
                productos.add(producto("Hot Chocolate", R.drawable.hotchocolate, 5.0))
                productos.add(producto("Espresso", R.drawable.espresso, 4.0))
                productos.add(producto("Chai Latte", R.drawable.chailatte, 6.0))
                productos.add(producto("Capuccino", R.drawable.capuccino, 7.0))
                productos.add(producto("American Coffee", R.drawable.americano, 2.0))
            }

            "cold" -> {
                imageView.setImageResource(R.drawable.colddrinks)
                productos.add(producto("Caramel Frap", R.drawable.caramelfrap, 5.0))
                productos.add(producto("Chocolate Frap", R.drawable.chocolatefrap, 6.0))
                productos.add(producto("Cold Brew", R.drawable.coldbrew, 3.0))
                productos.add(producto("Matcha Latte", R.drawable.matcha, 4.0))
                productos.add(producto("Oreo Milkshake", R.drawable.oreomilkshake, 7.0))
                productos.add(producto("Peanut Milkshake", R.drawable.peanutmilshake, 7.0))
            }

            "salt" -> {
                imageView.setImageResource(R.drawable.salties)
                productos.add(producto("Chicken Crepes", R.drawable.chickencrepes, 6.0))
                productos.add(producto("Club Sandwich", R.drawable.clubsandwich, 5.0))
                productos.add(producto("Panini", R.drawable.hampanini, 4.0))
                productos.add(producto("Philly Cheese Steak", R.drawable.phillycheesesteak, 6.0))
                productos.add(producto("Nachos", R.drawable.nachos, 7.0))
            }

            "sweet" -> {
                imageView.setImageResource(R.drawable.sweets)
                productos.add(producto("Blueberry Cake", R.drawable.blueberrycake, 6.0))
                productos.add(producto("Chocolate Cupcake", R.drawable.chocolatecupcake, 3.0))
                productos.add(producto("Lemon Tartalette", R.drawable.lemontartalette, 4.0))
                productos.add(producto("Red Velvet Cake", R.drawable.redvelvetcake, 6.0))
                productos.add(producto("Cherry Cheesecake", R.drawable.strawberrycheesecake, 7.0))
                productos.add(producto("Tiramisu", R.drawable.tiramisu, 6.0))
            }
        }
    }

    class ProductoAdapter : BaseAdapter {
        var productos = ArrayList<producto>()
        var context: Context? = null

        constructor(context: Context, peliculas: ArrayList<producto>) : super() {
            this.productos = peliculas
            this.context = context
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(p0: Int): Any {
            return productos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var producto = productos[position]
            var inflator =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.producto, null)
            var img: ImageView = vista.findViewById(R.id.img_Producto)
            var costo: TextView = vista.findViewById(R.id.movie_title_cell)

            img.setImageResource(producto.image)
            costo.setText(producto.costo.toString())

            img.setOnClickListener() {
                val intento = Intent(context, detalle_producto::class.java)
                intento.putExtra("imagen", producto.image)
                intento.putExtra("costo", producto.costo)
                context!!.startActivity(intento)
            }

            return vista
        }
    }
}