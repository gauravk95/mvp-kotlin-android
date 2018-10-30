/*
    Copyright 2018 Gaurav Kumar

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/
package com.github.mvpbasearchitecture.di.module

import com.github.mvpbasearchitecture.data.source.db.AppDatabase
import com.github.mvpbasearchitecture.data.source.db.AppDbOpenHelper
import com.github.mvpbasearchitecture.data.source.repository.local.AppLocalDataSource
import com.github.mvpbasearchitecture.data.source.prefs.AppPreferences
import com.github.mvpbasearchitecture.data.source.prefs.Preferences
import com.github.mvpbasearchitecture.data.source.repository.remote.AppRemoteDataSource
import com.github.mvpbasearchitecture.data.source.repository.AppDataRepository
import com.github.mvpbasearchitecture.data.source.repository.AppDataSource
import com.github.mvpbasearchitecture.data.source.repository.AppRepository
import com.github.mvpbasearchitecture.di.DatabaseInfo
import com.github.mvpbasearchitecture.di.Local
import com.github.mvpbasearchitecture.di.PreferenceInfo
import com.github.mvpbasearchitecture.di.Remote
import com.github.mvpbasearchitecture.utils.AppConstants

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

/**
 * Modules related to data and repository
 *
 * Created by gk.
 */

@Module
class DataModule {

    @Provides
    @Singleton
    @DatabaseInfo
    fun provideDatabaseName(): String {
        return AppConstants.DB_NAME
    }

    @Provides
    @Singleton
    @PreferenceInfo
    fun providePreferenceName(): String {
        return AppConstants.PREF_NAME
    }

    @Provides
    @Singleton
    @Local
    fun provideAppLocalDataSource(appLocalDataSource: AppLocalDataSource): AppDataSource {
        return appLocalDataSource
    }

    @Provides
    @Singleton
    @Remote
    fun provideAppRemoteDataSource(appRemoteDataSource: AppRemoteDataSource): AppDataSource {
        return appRemoteDataSource
    }

    @Provides
    @Singleton
    fun provideAppRepository(dataRepository: AppDataRepository): AppRepository {
        return dataRepository
    }

    @Provides
    @Singleton
    fun provideAppDb(appDbOpenHelper: AppDbOpenHelper): AppDatabase {
        return appDbOpenHelper.database
    }

    @Provides
    @Singleton
    fun providePreferencesHelper(appPreferences: AppPreferences): Preferences {
        return appPreferences
    }

}
