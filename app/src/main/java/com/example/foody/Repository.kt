package com.example.foody

import com.example.foody.data.RemoteDataSource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(remoteDataSource: RemoteDataSource){
    val remote = remoteDataSource
}