package co.kr.preferencesscreen

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import co.kr.preferencescreen.R

class SettingFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.pref)
    }
}