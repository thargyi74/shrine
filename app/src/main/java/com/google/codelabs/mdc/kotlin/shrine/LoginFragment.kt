package com.google.codelabs.mdc.kotlin.shrine

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.shr_login_fragment.*
import kotlinx.android.synthetic.main.shr_login_fragment.view.*

/**
 * Fragment representing the login screen for Shrine.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v: View = inflater.inflate(R.layout.shr_login_fragment, container, false)

        v.next_button.setOnClickListener({

            // Next line to be removed during production run
            (activity as NavigationHost).navigateTo(ProductGridFragment(), false)

            // Disabled for debugging purposes only
            /*           // If password is not valid display an error
                       if (!isPasswordValid(password_edit_text.text!!)) {
                           password_text_input.error = getString(R.string.shr_error_password)
                       } else {
                           // Clear the error
                           password_text_input.error = null
                           //Navigate to the next fragment
                           (activity as NavigationHost).navigateTo(ProductGridFragment(), false)
                       }*/
        })

        return v
    }

    private fun isPasswordValid(text: Editable): Boolean {
        return text != null && text.length >= 8;
    }
}
