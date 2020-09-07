package br.com.uniftec.avaliadorpolitico.activities

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import br.com.uniftec.avaliadorpolitico.R

class ChangePasswordActivity : AppCompatActivity(), View.OnClickListener, View.OnKeyListener {

    private var oldPassword: String? = null
    private var newPassword: String? = null
    private var repeatedPassword: String? = null

    private var oldPasswordEditText: AppCompatEditText? = null
    private var newPasswordEditText: AppCompatEditText? = null
    private var repeatedPasswordEditText: AppCompatEditText? = null

    private var changeButton: AppCompatButton? = null
    private var cancelButton: AppCompatButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        changeButton = findViewById(R.id.activity_change_password_change_button)
        cancelButton = findViewById(R.id.activity_change_password_cancel_button)

        oldPasswordEditText = findViewById(R.id.activity_change_password_old_password_edit_text)
        newPasswordEditText = findViewById(R.id.activity_change_password_new_password_edit_text)
        repeatedPasswordEditText = findViewById(R.id.activity_change_password_repeat_password_edit_text)

        changeButton?.setOnClickListener(this)
        cancelButton?.setOnClickListener(this)

        oldPasswordEditText?.setOnKeyListener(this)
        newPasswordEditText?.setOnKeyListener(this)
        repeatedPasswordEditText?.setOnKeyListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0 == changeButton) {
            changePassword()
        } else if (p0 == cancelButton) {
            finish()
        }
    }

    override fun onKey(p0: View?, p1: Int, p2: KeyEvent?): Boolean {
        if (p0?.id == oldPasswordEditText?.id && p1 == KeyEvent.KEYCODE_ENTER && p2?.action == KeyEvent.ACTION_DOWN) {
            oldPassword = oldPasswordEditText?.text.toString()

            return true
        } else if (p0?.id == newPasswordEditText?.id && p1 == KeyEvent.KEYCODE_ENTER && p2?.action == KeyEvent.ACTION_DOWN) {
            newPassword = newPasswordEditText?.text.toString()

            return true
        } else if (p0?.id == repeatedPasswordEditText?.id && p1 == KeyEvent.KEYCODE_ENTER && p2?.action == KeyEvent.ACTION_DOWN) {
            repeatedPassword = repeatedPasswordEditText?.text.toString()

            return true
        }

        return false
    }

    private fun changePassword() {

    }
}