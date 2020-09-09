package br.com.uniftec.avaliadorpolitico.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import br.com.uniftec.avaliadorpolitico.R

class PoliticalProfileActivity : AppCompatActivity(), View.OnClickListener {

    private var lateralMenuImageView: AppCompatImageView? = null
    private var lateralBellImageView: AppCompatImageView? = null

    private var mainTitleTextView: AppCompatTextView? = null
    private var politicalPromisesTextView: AppCompatTextView? = null

    private var completeNameEditText: AppCompatEditText? = null
    private var birthDateEditText: AppCompatEditText? = null
    private var birthCityEditText: AppCompatEditText? = null
    private var genderEditText: AppCompatEditText? = null
    private var civilStateEditText: AppCompatEditText? = null
    private var educationLevelEditText: AppCompatEditText? = null
    private var professionEditText: AppCompatEditText? = null
    private var currentPartyEditText: AppCompatEditText? = null

    private var observationsTextView: AppCompatTextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_political_profile)

        lateralMenuImageView = findViewById(R.id.activity_political_profile_menu_lateral_image_view)
        lateralBellImageView = findViewById(R.id.activity_political_profile_lateral_bell_image_view)

        mainTitleTextView = findViewById(R.id.activity_political_profile_title_profile_text_view)
        politicalPromisesTextView = findViewById(R.id.activity_political_profile_title_political_promises_text_view)

        completeNameEditText = findViewById(R.id.activity_political_profile_complete_name_edit_text)
        birthDateEditText = findViewById(R.id.activity_political_profile_birth_date_edit_text)
        birthCityEditText = findViewById(R.id.activity_political_profile_birth_city_edit_text)
        genderEditText = findViewById(R.id.activity_political_profile_gender_edit_text)
        civilStateEditText = findViewById(R.id.activity_political_profile_civil_state_edit_text)
        educationLevelEditText = findViewById(R.id.activity_political_profile_education_level_edit_text)
        professionEditText = findViewById(R.id.activity_political_profile_profession_edit_text)
        currentPartyEditText = findViewById(R.id.activity_political_profile_current_party_edit_text)

        observationsTextView = findViewById(R.id.activity_political_profile_observations_text_view)

        lateralMenuImageView?.setOnClickListener(this)
        lateralBellImageView?.setOnClickListener(this)

        mainTitleTextView?.setOnClickListener(this)
        politicalPromisesTextView?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0 == lateralMenuImageView) {
            //abrir menu lateral
        } else if (p0 == lateralBellImageView) {
            callSchedulerActivity()
        } else if (p0 == mainTitleTextView) {
            //do nothing yet
        } else if (p0 == politicalPromisesTextView) {
            callPoliticalPromisesActivity()
        }
    }

    private fun callPoliticalPromisesActivity() {
        val intent = Intent(this, PoliticalPromisesActivity::class.java)

        startActivity(intent)
    }

    private fun callSchedulerActivity() {
        val intent = Intent(this, SchedulerActivity::class.java)

        startActivity(intent)
    }
}