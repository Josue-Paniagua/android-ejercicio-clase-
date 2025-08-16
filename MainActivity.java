package com.example.miprimerapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText; // Asegúrate de importar EditText
import android.widget.TextView;
import android.widget.Toast; // Para mostrar mensajes cortos (opcional)

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Declarar las vistas como variables miembro
    private TextView tvSaludo;
    private EditText editTextSaludo; // Variable para el EditText
    private Button btnSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Si estás usando EdgeToEdge
        setContentView(R.layout.activity_main);

        // Aplicar paddings para sistemas con barras (si usas EdgeToEdge)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. Obtener referencias a las vistas
        tvSaludo = findViewById(R.id.tvSaludo);
        editTextSaludo = findViewById(R.id.editTextSaludo); // Inicializar el EditText
        btnSaludo = findViewById(R.id.btnSaludo);

        // 2. Configurar un OnClickListener para el botón
        btnSaludo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 3. Obtener el texto del EditText
                String nuevoSaludo = editTextSaludo.getText().toString().trim(); // .trim() quita espacios al inicio y final

                // 4. Validar que no esté vacío antes de actualizar
                if (!nuevoSaludo.isEmpty()) {
                    tvSaludo.setText(nuevoSaludo); // Actualizar el TextView
                } else {
                    // Opcional: Mostrar un mensaje si el EditText está vacío
                    // tvSaludo.setText(getString(R.string.tv_saludo_default)); // Vuelve al texto original
                    Toast.makeText(MainActivity.this, getString(R.string.mensaje_edittext_vacio), Toast.LENGTH_SHORT).show();
                }

                // Opcional: Limpiar el EditText después de usar su texto
                // editTextSaludo.setText("");
            }
        });
    }
}
