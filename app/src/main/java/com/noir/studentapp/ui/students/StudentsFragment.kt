package com.noir.studentapp.ui.students

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.noir.studentapp.adapters.StudentAdapter
import com.noir.studentapp.data.Student
import com.noir.studentapp.databinding.FragmentStudentsBinding

class StudentsFragment : Fragment() {

    private var _binding: FragmentStudentsBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStudentsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = listOf(
            Student("https://static.miraheze.org/tampvanwiki/0/0a/Rusdi_Omaygot.png",
                "Rusdi Omaygot",
                "211401069"
            ),
            Student("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTh_HKxZmNOQ3NMDifbWuLsFxBHtKEvcrnF_kioBXCupw&s",
                "Ambatron",
                "211401079"
            ),
            Student("https://i.kym-cdn.com/entries/icons/original/000/042/513/dreamybull.jpg",
                "Mr. Ambatukam",
                "211401089"
            ),
            Student("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQdzMqMwNw5PNQgPXbU9LKGbbV5HHrV6ymRSYb7BWFzoA&s",
                "Ricardo Milos",
                "211401099"
            ),
        )
        populateStudents(data)
    }

    private fun populateStudents(students: List<Student>) {
        val adapter = StudentAdapter()
        adapter.submitList(students)
        binding?.rvStudents?.layoutManager = LinearLayoutManager(requireContext())
        binding?.rvStudents?.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}