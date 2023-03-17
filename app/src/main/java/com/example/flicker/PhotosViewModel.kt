package com.example.flicker

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PhotosViewModel:ViewModel() {

    private val imagesLiveData = MutableLiveData<List<Image>>()
    var photosAdapter = PhotosAdapter()

    fun loadPhotos():LiveData<List<Image>>
    {
        viewModelScope.launch {
            val result:PhotoSearchResponse=ImageRepository.flickerApi.fetchPhotos()

            val imgList:List<Image> =result.photos.photo.map{photo->
                Image(id=photo.photoId,
                url="https://live.staticflickr.com/${photo.server}/${photo.photoId}_${photo.secret}.jpg",
                title = photo.title)
            }
            imagesLiveData.postValue(imgList)
        }
        return imagesLiveData
    }
}