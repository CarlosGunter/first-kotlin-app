package unam.android.iaactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        // Obtener referencias a las vistas
        val editTextNombre = findViewById<EditText>(R.id.editTextNombre)
        val buttonAceptar = findViewById<Button>(R.id.buttonAceptar)
        
        // Configurar el listener para el botón
        buttonAceptar.setOnClickListener {
            val nombre = editTextNombre.text.toString()
            val intent = Intent(this, SaludoActivity::class.java)
            intent.putExtra("NOMBRE", nombre)
            startActivity(intent)
        }
    }
}
