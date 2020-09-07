package br.com.uniftec.avaliadorpolitico.activities

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import br.com.uniftec.avaliadorpolitico.R
import br.com.uniftec.avaliadorpolitico.utils.DialogAdapter

class LoginActivity : AppCompatActivity(), View.OnClickListener, View.OnKeyListener {

    private val alertDialog: AlertDialog? = null

    private var user: String? = null
    private var password: String? = null

    private var registerTextViewButton: AppCompatTextView? = null
    private var forgotPasswordTextViewButton: AppCompatTextView? = null

    private var enterButton: AppCompatButton? = null
    private var cancelButton: AppCompatButton? = null

    private var accessWithGoogleLayoutButton: LinearLayoutCompat? = null

    private var userEditText: AppCompatEditText? = null
    private var passwordEditText: AppCompatEditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        registerTextViewButton = findViewById(R.id.activity_login_register_text_view_button)
        forgotPasswordTextViewButton = findViewById(R.id.activity_login_forgot_password_text_view_button)

        enterButton = findViewById(R.id.activity_login_enter_button)
        cancelButton = findViewById(R.id.activity_login_cancel_button)

        accessWithGoogleLayoutButton = findViewById(R.id.activity_login_access_with_google_layout_button)

        userEditText = findViewById(R.id.activity_login_user_edit_text)
        passwordEditText = findViewById(R.id.activity_login_password_edit_text)

        registerTextViewButton?.setOnClickListener(this)
        forgotPasswordTextViewButton?.setOnClickListener(this)

        enterButton?.setOnClickListener(this)
        cancelButton?.setOnClickListener(this)

        accessWithGoogleLayoutButton?.setOnClickListener(this)

        userEditText?.setOnKeyListener(this)
        forgotPasswordTextViewButton?.setOnKeyListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0 == registerTextViewButton) {
            callUserRegisterActivity()
        } else if (p0 == forgotPasswordTextViewButton) {
            callForgotPasswordActivity()
        } else if (p0 == enterButton) {
            //callNextActivity()
        } else if (p0 == cancelButton) {
            callPreviousActivity()
        } else if (p0 == accessWithGoogleLayoutButton) {
            accessWithGoogle()
        }
    }

    private fun callNextActivity() {
        user = userEditText?.text.toString()
        password = passwordEditText?.text.toString()


    }

    private fun callUserRegisterActivity() {
        val intent = Intent(this, UserRegisterActivity::class.java)

        startActivity(intent)
    }

    private fun callForgotPasswordActivity() {
        user = userEditText?.text.toString()

        if (user.isNullOrBlank()) {

            DialogAdapter(null, this, null, null, getString(R.string.alert_dialog_ok), null, null,
                    { _, _ -> alertDialog!!.dismiss() }, getString(R.string.alert_dialog_title_attention), getString(R.string.please_inform_username))

        } else {
            val intent = Intent(this, ForgotPasswordActivity::class.java)

            intent.putExtra(getString(R.string.username), user)

            startActivity(intent)
        }
    }

    private fun callPreviousActivity() {
        finish()
    }

    private fun accessWithGoogle() {

    }

    override fun onKey(p0: View?, p1: Int, p2: KeyEvent?): Boolean {
        return if (p0?.id == userEditText?.id && p1 == KeyEvent.KEYCODE_ENTER && p2?.action == KeyEvent.ACTION_DOWN) {
            user = userEditText?.text.toString()

            true
        } else if (p0?.id == forgotPasswordTextViewButton?.id && p1 == KeyEvent.KEYCODE_ENTER && p2?.action == KeyEvent.ACTION_DOWN) {
            password = passwordEditText?.text.toString()

            true
        } else {
            false
        }
    }
}