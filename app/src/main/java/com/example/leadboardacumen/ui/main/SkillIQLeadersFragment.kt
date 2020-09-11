package com.example.leadboardacumen.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.leadboardacumen.LearningLeaderAdapter
import com.example.leadboardacumen.R

/**
 * A placeholder fragment containing a simple view.
 */
class SkillIQLeadersFragment : Fragment(),View.OnClickListener {

    private lateinit var pageViewModel: PageViewModel

    val namesskill = arrayOf<String>("Jonh Doe", "Fabrice KIKI", "Dieu Donné", "Yass Razack")

    val scoreskill = arrayOf<String>(
        "300 skill IQ Score",
        "300 skill IQ Score",
        "300 skill IQ Score",
        "300 skill IQ Score"
    )

    val countriesskill = arrayOf<String>("Benin", "Kenya", "USA", "Ghana")

    val adapter = LearningLeaderAdapter(namesskill, scoreskill, countriesskill, this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_skilliq_leaders, container, false)
        val recyclerView: RecyclerView = root.findViewById(R.id.recyclerview_learning)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

//        val textView: TextView = root.findViewById(R.id.section_label)
        pageViewModel.text.observe(viewLifecycleOwner, Observer<String> {
//            textView.text = "Skills leaders"
        })
        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): SkillIQLeadersFragment {
            return SkillIQLeadersFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}