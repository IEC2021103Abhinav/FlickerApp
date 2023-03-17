package com.example.flicker

data class PhotoResponse(val photoId:String ,
val owner:String,
val secret:String,
val server:String,
val title:String)


data class PhotosMetaData(val pageNo:Int,
                          val photo:List<PhotoResponse>)


//photoSearchResponse is an outermost response of PhotoResponse
data class PhotoSearchResponse(val photos:PhotosMetaData)
//upper three data class for the photo response not for communicate with our  app in kotlin those are for create url

data class Image(val id:String,
val url:String,
val title: String)
//image data is for show them between the  android ui and kotlin objects


