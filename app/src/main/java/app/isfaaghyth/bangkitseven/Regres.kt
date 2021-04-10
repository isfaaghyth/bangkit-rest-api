package app.isfaaghyth.bangkitseven

import com.google.gson.annotations.SerializedName

data class Regres(
    @field:SerializedName("total")
    val total: Int,

    @field:SerializedName("data")
    val data: List<RegresPerson>
)

data class RegresPerson(
    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("first_name")
    val firstName: String,

    @field:SerializedName("last_name")
    val lastName: String,

    @field:SerializedName("avatar")
    val avatar: String
)