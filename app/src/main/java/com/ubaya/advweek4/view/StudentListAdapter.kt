package com.ubaya.advweek4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.advweek4.R
import com.ubaya.advweek4.databinding.StudentListItemBinding
import com.ubaya.advweek4.model.Student
import com.ubaya.advweek4.util.loadImage
import kotlinx.android.synthetic.main.student_list_item.view.*

class StudentListAdapter(val studenList:ArrayList<Student>):RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(),ButtonDetailClickListener{
    class StudentViewHolder(var view: StudentListItemBinding) : RecyclerView.ViewHolder(view.root)
    fun updateStudentList(newStudentList: List<Student>) {
        studenList.clear()
        studenList.addAll(newStudentList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
//        val v = inflater.inflate(R.layout.student_list_item, parent, false)
//        return StudentViewHolder(v)
        val view = DataBindingUtil.inflate<StudentListItemBinding>(inflater, R.layout.student_list_item, parent, false)

        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.view.student = studenList[position]
        holder.view.listener = this
//        holder.view.txtID.text = studenList[position].id
//        holder.view.txtName.text = studenList[position].name
//        holder.view.imageView.loadImage(studenList[position].photourl.toString(),
//            holder.view.progressBar)
//
//        holder.view.btnDetail.setOnClickListener {
//            val action = StudentListFragmentDirections.actionStudentDetail(studenList[position].id.toString())
//            Navigation.findNavController(it).navigate(action)
//        }

    }

    override fun getItemCount(): Int {
        return studenList.size
    }

    override fun onButtonDetailClick(v: View) {

        val action = StudentListFragmentDirections.actionStudentDetail(v.tag.toString())

        Navigation.findNavController(v).navigate(action)
    }
}
