package com.noir.studentapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.noir.studentapp.data.Student
import com.noir.studentapp.databinding.StudentLayoutBinding
import com.noir.studentapp.ui.students.StudentsFragmentDirections

class StudentAdapter : ListAdapter<Student, StudentAdapter.ViewHolder>(DIFF_CALLBACK) {
    inner class ViewHolder(private val binding: StudentLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(student: Student) {
            Glide.with(binding.root.context)
                .load(student.image)
                .into(binding.ivStudent)

            binding.tvNama.text = student.nama
            binding.tvNim.text = student.nim

            binding.root.setOnClickListener {
                val toStudentDetail = StudentsFragmentDirections.actionNavigationStudentsToStudentDetailFragment()
                toStudentDetail.image = student.image
                toStudentDetail.nama = student.nama
                toStudentDetail.nim = student.nim
                it.findNavController().navigate(toStudentDetail)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = StudentLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = getItem(position)
        holder.bind(student)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Student>(){
            override fun areItemsTheSame(
                oldItem: Student,
                newItem: Student
            ): Boolean {
                return oldItem == newItem
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(
                oldItem: Student,
                newItem: Student
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}