package com.example.leadboardacumen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class LearningLeaderAdapter(val names: Array<String>, val hours: Array<String>, val countries: Array<String>,val itemClickListener: View.OnClickListener)
        : RecyclerView.Adapter<LearningLeaderAdapter.ViewHolder>() {

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            fun bindItem(name: String,hour: String,country: String, position: Int, itemClickListener: View.OnClickListener) {
                val cardView = itemView.findViewById(R.id.card_view_learning) as CardView
                val iconImageView = itemView.findViewById(R.id.icon_learning) as ImageView
                val nameTextView = itemView.findViewById(R.id.name_learning) as TextView
                val hoursTextView = itemView.findViewById(R.id.tv_learning_hours) as TextView
                val countryTextView = itemView.findViewById(R.id.tv_learning_hours) as TextView

                iconImageView.setImageResource(R.drawable.top_learner)
                nameTextView.text = name
                hoursTextView.text = hour
                countryTextView.text = country
                cardView.tag = position

                cardView.setOnClickListener(itemClickListener)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val viewItem = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_leaning_leaders, parent, false)
            return ViewHolder(viewItem)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val name = names[position]
            val hour = hours[position]
            val country = countries[position]

            holder.bindItem(name,hour,country, position,itemClickListener)
        }

        override fun getItemCount(): Int {
            return names.size
        }

    }



