package com.hthenrique.cyberlabsdesafio.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hthenrique.cyberlabsdesafio.databinding.GroupListBinding
import com.hthenrique.cyberlabsdesafio.model.Author

class AuthorGroupAdapter(var authors: List<Author>):
    RecyclerView.Adapter<AuthorGroupAdapter.GroupViewHolder>() {



    private fun setList(listAuthors: List<Author>){
        authors = listAuthors
    }

    fun replaceGroupList(listAuthors: List<Author>){
        val moreAuthors = ArrayList<Author>()
        moreAuthors.addAll(listAuthors)
        setList(moreAuthors)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val binding = GroupListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GroupViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        val currentAuthor: Author = authors.get(position)
        holder.bind(currentAuthor.author)

    }

    override fun getItemCount(): Int {
        return authors.size
    }

    class GroupViewHolder(private val binding: GroupListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(author: String?){
            binding.groupTitleName.text = author
        }
    }

}