package com.bebooo43.cv.main.work

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bebooo43.cv.R
import com.bebooo43.cv.databinding.DialogWorkBinding
import com.bebooo43.cv.databinding.FragmentWorkBinding

class WorkFragment : Fragment() {

    private lateinit var binding: FragmentWorkBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentWorkBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = WorkAdapter(workList)
        }
        binding.addFab.setOnClickListener {
            showAddWorkDialog()
        }
    }

    private fun showAddWorkDialog() {
        context?.also {
            val dialogViewBinding = DialogWorkBinding.inflate(layoutInflater)
            AlertDialog.Builder(it)
                .setTitle("Work Experience")
                .setView(dialogViewBinding.root)
                .setPositiveButton("Add") { _, _ ->
                    val title = dialogViewBinding.dialogTitleET.text.toString()
                    val position = dialogViewBinding.dialogPositionET.text.toString()
                    val duration = dialogViewBinding.dialogDurationET.text.toString()
                    addWork(Work(title, position, duration, R.drawable.ic_baseline_work_24))
                }
                .setNegativeButton("Cancel", null)
                .create()
                .show()
        }
    }

    private fun addWork(work: Work) {
        (binding.rv.adapter as? WorkAdapter)?.addWork(work)
    }

    private val workList by lazy {
        arrayListOf(
            Work(
                getString(R.string.home_depot),
                getString(R.string.home_depot_title),
                getString(R.string.jun_2022_present),
                R.drawable.home_depot
            ),
            Work(
                getString(R.string.kforce),
                getString(R.string.kfroce_title),
                getString(R.string.jun_2022_present),
                R.drawable.kforce
            ),
            Work(
                getString(R.string.vodafone),
                getString(R.string.vodafone_title_sr),
                getString(R.string.jun_2020_nov_2021),
                R.drawable.voda
            ),
            Work(
                getString(R.string.vodafone),
                getString(R.string.vodafone_title),
                getString(R.string.dec_2017_jun_2020),
                R.drawable.voda
            )
        )
    }

}