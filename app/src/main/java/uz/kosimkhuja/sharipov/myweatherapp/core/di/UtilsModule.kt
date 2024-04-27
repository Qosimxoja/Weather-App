package uz.kosimkhuja.sharipov.myweatherapp.core.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.kosimkhuja.sharipov.myweatherapp.core.utils.DateUtils
import uz.kosimkhuja.sharipov.myweatherapp.core.utils.ResUtil

@Module
@InstallIn(SingletonComponent::class)
class UtilsModule {

    @Provides
    fun provideResUtil(@ApplicationContext context: Context): ResUtil = ResUtil(context = context)

    @Provides
    fun provideDateUtils(): DateUtils = DateUtils()

}