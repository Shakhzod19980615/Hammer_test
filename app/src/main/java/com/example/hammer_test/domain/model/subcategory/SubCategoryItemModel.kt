package uz.demo.dana.domain.model.subcategory

data class SubCategoryItemModel(
    val id : Int,
    val name : String,
    val image : String,
    val price : String,
    val rating: Double,
    val shopName: String,
    val status : String,
    val keyword : String,
    val isFavourite : Boolean = false

)