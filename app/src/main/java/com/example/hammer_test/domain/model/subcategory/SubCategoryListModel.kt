package uz.demo.dana.domain.model.subcategory

data class SubCategoryListModel(
    val id: Int,
    val keyword : String,
    val title: String,
    val items: List<SubCategoryItemModel>
)