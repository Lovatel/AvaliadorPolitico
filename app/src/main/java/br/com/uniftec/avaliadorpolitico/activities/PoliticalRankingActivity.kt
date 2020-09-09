package br.com.uniftec.avaliadorpolitico.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import br.com.uniftec.avaliadorpolitico.R

class PoliticalRankingActivity : AppCompatActivity(), View.OnClickListener {

    private var lateralMenuImageView: AppCompatImageView? = null
    private var lateralBellImageView: AppCompatImageView? = null

    private var likeImageView: AppCompatImageView? = null
    private var promiseImageView: AppCompatImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_political_ranking)

        lateralMenuImageView = findViewById(R.id.activity_political_ranking_menu_lateral_image_view)
        lateralBellImageView = findViewById(R.id.activity_political_ranking_lateral_bell_image_view)

        likeImageView = findViewById(R.id.activity_political_ranking_like_image_view)
        promiseImageView = findViewById(R.id.activity_political_ranking_promise_image_view)

        lateralMenuImageView?.setOnClickListener(this)
        lateralBellImageView?.setOnClickListener(this)

        likeImageView?.setOnClickListener(this)
        promiseImageView?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0 == lateralMenuImageView) {
            //abrir menu lateral
        } else if (p0 == lateralBellImageView) {
            callPoliticalPromisesActivity()
        } else if (p0 == likeImageView) {
            orderListByLike()
        } else if (p0 == promiseImageView) {
            orderListByPromise()
        }
    }

    private fun orderListByLike() {

    }

    private fun orderListByPromise() {

    }

    private fun callPoliticalPromisesActivity() {
        val intent = Intent(this, PoliticalPromisesActivity::class.java)

        startActivity(intent)
    }
}