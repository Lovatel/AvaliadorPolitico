package br.com.uniftec.avaliadorpolitico.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import br.com.uniftec.avaliadorpolitico.R
import br.com.uniftec.avaliadorpolitico.utils.DialogAdapter

class ForgotPasswordActivity : AppCompatActivity(), View.OnClickListener {

    private val alertDialog: AlertDialog? = null

    private var emailOrCpf: String? = null

    private var emailOrCpfEditText: AppCompatEditText? = null

    private var nextButton: AppCompatButton? = null
    private var cancelButton: AppCompatButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        nextButton = findViewById(R.id.activity_forgot_password_next_button)
        cancelButton = findViewById(R.id.activity_forgot_password_cancel_button)
        emailOrCpfEditText = findViewById(R.id.activity_forgot_password_email_or_cpf_edit_text)

        nextButton?.setOnClickListener(this)
        cancelButton?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0 == nextButton) {
            callForgotPasswordMainAction()
        } else if (p0 == cancelButton) {
            finish()
        }
    }

    private fun callForgotPasswordMainAction() {
        emailOrCpf = emailOrCpfEditText?.text.toString()

        if (emailOrCpf.isNullOrEmpty()) {
            DialogAdapter(null, this, null, null, getString(R.string.alert_dialog_ok), null, null,
                    { _, _ -> alertDialog!!.dismiss() }, getString(R.string.alert_dialog_title_attention), getString(R.string.please_inform_email_or_cpf))
        } else if (validEmailOrCpf()) {
            sendPasswordEmailToUser()
        } else {
            DialogAdapter(null, this, null, null, getString(R.string.alert_dialog_ok), null, null,
                    { _, _ -> alertDialog!!.dismiss() }, getString(R.string.alert_dialog_title_attention), getString(R.string.please_inform_email_or_cpf_invalid_message))
        }
    }

    private fun validEmailOrCpf(): Boolean {
        return true
    }

    private fun sendPasswordEmailToUser() {

    }
}