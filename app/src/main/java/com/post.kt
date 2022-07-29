package com

data class post(
    var userId:String,
    var id:String,
    var title:String,
    var body:String
)

data class Comment(
    var postId:Int,
    var id:Int,
    var name:String,
    var email:String
)
