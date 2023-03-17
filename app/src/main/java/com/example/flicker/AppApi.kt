package com.example.flicker

import retrofit2.http.GET
private const val FlickerAPiKey="47d8a8614117d5cedc008a0e93320dd2"
//https://www.flickr.com/services/rest/
// ?method=flickr.photos.getRecent&api_key=3dfe064966e1e4379d0758af57cd5676&format=rest
interface AppApi
{
    @GET("?method=flickr.photos.getRecent&format=rest&api_key=$FlickerAPiKey")
    suspend fun fetchPhotos():PhotoSearchResponse


}