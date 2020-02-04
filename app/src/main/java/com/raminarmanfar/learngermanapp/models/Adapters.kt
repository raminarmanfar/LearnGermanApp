package com.raminarmanfar.learngermanapp.models

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raminarmanfar.learngermanapp.R
import kotlinx.android.synthetic.main.lo_herr_professor.view.*

class HerrProffessorAdapter(mCtx: Context?, val herrProfessors: ArrayList<HerrProfessorModel>) :
        RecyclerView.Adapter<HerrProffessorAdapter.ViewHolder>() {

    val mCtx = mCtx

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val lblHPCourseTitle = itemView.lblLoHpCourseTitleValue
        val lblHPTranslation = itemView.lblLoHpTranslationValue
        val btnUpdate = itemView.btnLoHpUpdate
        val btnDelete = itemView.btnLoHpDelete
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HerrProffessorAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.lo_herr_professor, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return herrProfessors.size
    }

    override fun onBindViewHolder(holder: HerrProffessorAdapter.ViewHolder, position: Int) {
        val hp: HerrProfessorModel = herrProfessors[position]
        holder.lblHPCourseTitle.text = hp.hpCourseTitle
        holder.lblHPTranslation.text = hp.hpTranslation
    }

}