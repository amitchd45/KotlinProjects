package com.omninos.kotlinexample.modelClass
import com.google.gson.annotations.SerializedName


 class ResonseClass {
    @SerializedName("articles")
    var articles: List<Article>? = null
    @SerializedName("status")
    var status: String = ""
    @SerializedName("totalResults")
    var totalResults: Int = 0
}

 class Article{
     @SerializedName("author")
     var author: String? = null
     @SerializedName("content")
     var content: String? = null
     @SerializedName("description")
     var description: String? = null
     @SerializedName("publishedAt")
     var publishedAt: String = ""
     @SerializedName("source")
     var source: Source? = null
     @SerializedName("title")
     var title: String = ""
     @SerializedName("url")
     var url: String = ""
     @SerializedName("urlToImage")
     var urlToImage: String? = null
 }


 class Source{
    @SerializedName("id")
    var id: Any? = null
     @SerializedName("name")
    var name: String = ""
 }
