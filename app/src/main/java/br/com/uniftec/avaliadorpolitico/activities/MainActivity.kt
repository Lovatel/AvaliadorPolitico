package br.com.uniftec.avaliadorpolitico.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import br.com.uniftec.avaliadorpolitico.R

class MainActivity : AppCompatActivity(), View.OnClickListener  {

    private var accessButton: AppCompatButton? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        accessButton = findViewById(R.id.activity_main_access_button)

        accessButton?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0?.id == accessButton?.id) {
            callNextActivity()
        }
    }

    private fun callNextActivity() {
        val intent = Intent(this, LoginActivity::class.java)

        startActivity(intent)
    }
}