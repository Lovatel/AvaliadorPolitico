package br.com.uniftec.avaliadorpolitico.activities

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatEditText
import br.com.uniftec.avaliadorpolitico.R

class UserRegisterActivity : AppCompatActivity(), View.OnClickListener, View.OnKeyListener {

    private var name: String? = null
    private var lastName: String? = null
    private var cpf: String? = null
    private var email: String? = null
    private var password: String? = null
    private var isPoliticianProfile: Boolean = false

    private var nameEditText: AppCompatEditText? = null
    private var lastNameEditText: AppCompatEditText? = null
    private var cpfEditText: AppCompatEditText? = null
    private var emailEditText: AppCompatEditText? = null
    private var passwordEditText: AppCompatEditText? = null

    private var isPoliticianCheckBox: AppCompatCheckBox? = null

    private var registerButton: AppCompatButton? = null
    private var cancelButton: AppCompatButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_register)

        nameEditText = findViewById(R.id.activity_user_register_name_edit_text)
        lastNameEditText = findViewById(R.id.activity_user_register_last_name_edit_text)
        cpfEditText = findViewById(R.id.activity_user_register_cpf_edit_text)
        emailEditText = findViewById(R.id.activity_user_register_email_edit_text)
        passwordEditText = findViewById(R.id.activity_user_register_password_edit_text)

        isPoliticianCheckBox = findViewById(R.id.activity_user_register_politician_profile_check_box)

        registerButton = findViewById(R.id.activity_user_register_register_button)
        cancelButton = findViewById(R.id.activity_user_register_cancel_button)

        nameEditText?.setOnKeyListener(this)
        lastNameEditText?.setOnKeyListener(this)
        cpfEditText?.setOnKeyListener(this)
        emailEditText?.setOnKeyListener(this)
        passwordEditText?.setOnKeyListener(this)

        registerButton?.setOnClickListener(this)
        cancelButton?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0 == registerButton) {
            registerUser()
        } else if (p0 == cancelButton) {
            finish()
        }
    }

    override fun onKey(p0: View?, p1: Int, p2: KeyEvent?): Boolean {
        if (p0?.id == nameEditText?.id && p1 == KeyEvent.KEYCODE_ENTER && p2?.action == KeyEvent.ACTION_DOWN) {
            name = nameEditText?.text.toString()

            return true
        } else if (p0?.id == lastNameEditText?.id && p1 == KeyEvent.KEYCODE_ENTER && p2?.action == KeyEvent.ACTION_DOWN) {
            lastName = lastNameEditText?.text.toString()

            return true
        } else if (p0?.id == cpfEditText?.id && p1 == KeyEvent.KEYCODE_ENTER && p2?.action == KeyEvent.ACTION_DOWN) {
            cpf = cpfEditText?.text.toString()

            return true
        } else if (p0?.id == emailEditText?.id && p1 == KeyEvent.KEYCODE_ENTER && p2?.action == KeyEvent.ACTION_DOWN) {
            email = emailEditText?.text.toString()

            return true
        } else if (p0?.id == passwordEditText?.id && p1 == KeyEvent.KEYCODE_ENTER && p2?.action == KeyEvent.ACTION_DOWN) {
            password = passwordEditText?.text.toString()

            return true
        }

        return false
    }

    private fun registerUser() {
        name = nameEditText?.text.toString()
        lastName = lastNameEditText?.text.toString()
        cpf = cpfEditText?.text.toString()
        email = emailEditText?.text.toString()
        password = passwordEditText?.text.toString()
        isPoliticianProfile = (isPoliticianCheckBox?.isChecked ?: Boolean) as Boolean


    }
}