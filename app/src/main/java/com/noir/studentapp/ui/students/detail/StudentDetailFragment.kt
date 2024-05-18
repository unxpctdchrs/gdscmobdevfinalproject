package com.noir.studentapp.ui.students.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.noir.studentapp.R
import com.noir.studentapp.databinding.FragmentStudentDetailBinding


class StudentDetailFragment : Fragment() {
    private var _binding: FragmentStudentDetailBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStudentDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val studentDetails = StudentDetailFragmentArgs.fromBundle(arguments as Bundle)
        Glide.with(requireContext())
            .load(studentDetails.image)
            .into(binding!!.imageView)

        binding?.tvNama?.text = requireContext().getString(R.string.profile_nama, studentDetails.nama)
        binding?.tvNim?.text = requireContext().getString(R.string.profile_nim, studentDetails.nim)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}