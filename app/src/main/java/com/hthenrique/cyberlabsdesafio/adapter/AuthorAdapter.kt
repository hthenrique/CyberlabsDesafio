package com.hthenrique.cyberlabsdesafio.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hthenrique.cyberlabsdesafio.databinding.AuthorsListItemBinding
import com.hthenrique.cyberlabsdesafio.model.Author
import com.squareup.picasso.Picasso

class AuthorAdapter(var authors: List<Author>):
    RecyclerView.Adapter<AuthorAdapter.AuthorViewHolder>() {

    private fun setList(listAuthors: List<Author>){
        authors = listAuthors
    }

    fun replaceList(listAuthors: List<Author>){
        val moreAuthors = ArrayList<Author>()
        moreAuthors.addAll(listAuthors)
        setList(moreAuthors)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorViewHolder {
        val binding = AuthorsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AuthorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AuthorViewHolder, position: Int) {
        val currentAuthor: Author = authors.get(position)
        holder.bind(currentAuthor)
    }

    override fun getItemCount(): Int {
        return authors.size
    }



    class AuthorViewHolder(private val binding: AuthorsListItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(author: Author){
            binding.apply {
                authorNameItemList.text = author.author
                Picasso.get()
                    .load(author.url)
                    .fit().centerCrop()
                    .into(authorImageItemList)
                authorTimestampItemList.text = author.timestamp.toString()
            }
        }
    }



}