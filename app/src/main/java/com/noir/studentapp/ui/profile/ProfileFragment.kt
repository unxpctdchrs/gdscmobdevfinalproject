package com.noir.studentapp.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.noir.studentapp.R
import com.noir.studentapp.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.tvNama?.text = requireContext().getString(R.string.profile_nama, "Christian Vigo Nathanael Purba")
        binding?.tvNim?.text = requireContext().getString(R.string.profile_nim, "211401044")
        binding?.tvEmail?.text = requireContext().getString(R.string.profile_email, "chrstvgo@gmail.com")
        binding?.tvAngkatan?.text = requireContext().getString(R.string.profile_angkatan, "2021")
        binding?.tvFakultas?.text = requireContext().getString(R.string.profile_fakultas, "Fasilkom-TI")
        binding?.tvProgramstudi?.text = requireContext().getString(R.string.profile_program, "Ilmu Komputer")
        binding?.tvSemesterterdaftar?.text = requireContext().getString(R.string.profile_semester, 6)
        binding?.tvStatus?.text = requireContext().getString(R.string.profile_status, "Single")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}