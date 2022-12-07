package com.bebooo43.cv.main.contact

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bebooo43.cv.R
import com.bebooo43.cv.databinding.FragmentContactBinding
import com.bebooo43.cv.main.webview.WebActivity
import com.bebooo43.cv.utils.openExternalApp
import com.bebooo43.cv.utils.sendEmail

class ContactFragment : Fragment() {

    private lateinit var binding: FragmentContactBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentContactBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.callBtn.setOnClickListener {
            context?.openExternalApp("tel:${getString(R.string.phone)}")
        }
        binding.emailBtn.setOnClickListener {
            context?.sendEmail(arrayListOf(getString(R.string.email)), "", "")
        }
        binding.linkedinBtn.setOnClickListener {
            context?.openExternalApp(getString(R.string.linkedIn_link))
        }
        binding.githubBtn.setOnClickListener {
            context?.openExternalApp(getString(R.string.github_link))
        }
        binding.pdfBtn.setOnClickListener {
//            context?.openExternalApp(getString(R.string.pdf_link))
            context?.also {
                startActivity(Intent(it, WebActivity::class.java))
            }
        }
    }

}