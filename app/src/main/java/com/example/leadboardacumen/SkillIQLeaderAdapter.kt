package com.example.leadboardacumen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class SkillIQLeaderAdapter(val names: Array<String>, val scores: Array<String>, val countries: Array<String>,val itemClickListener: View.OnClickListener)
        : RecyclerView.Adapter<SkillIQLeaderAdapter.ViewHolder>() {

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            fun bindItem(name: String,score: String,country: String, position: Int, itemClickListener: View.OnClickListener) {
                val cardView = itemView.findViewById(R.id.card_view_skill) as CardView
                val iconImageView = itemView.findViewById(R.id.icon_skill) as ImageView
                val nameTextView = itemView.findViewById(R.id.name_skill) as TextView
                val ScoreTextView = itemView.findViewById(R.id.tv_skill_score) as TextView
                val countryTextView = itemView.findViewById(R.id.tv_country_skill) as TextView

                iconImageView.setImageResource(R.drawable.top_learner)
                nameTextView.text = name
                ScoreTextView.text = score
                countryTextView.text = country
                cardView.tag = position

                cardView.setOnClickListener(itemClickListener)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val viewItem = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_still_iq_leaders, parent, false)
            return ViewHolder(viewItem)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val name = names[position]
            val score = scores[position]
            val country = countries[position]

            holder.bindItem(name,score,country, position,itemClickListener)
        }

        override fun getItemCount(): Int {
            return names.size
        }

    }
