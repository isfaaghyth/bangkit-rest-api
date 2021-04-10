package app.isfaaghyth.bangkitseven

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PersonAdapter(
    private val personList: List<RegresPerson> = mutableListOf()
) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    inner class PersonViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val ivAvatar: ImageView = itemView.findViewById(R.id.iv_avatar)
        private val tvFullName: TextView = itemView.findViewById(R.id.tv_fullname)

        fun bind(person: RegresPerson) {
            Glide.with(itemView.context)
                .asBitmap()
                .circleCrop()
                .load(person.avatar)
                .into(ivAvatar)

            tvFullName.text = person.firstName + person.lastName
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val layoutView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(layoutView)
    }

    override fun getItemCount(): Int = personList.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(personList[position])
    }

}