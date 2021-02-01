package com.arhiser.nasa_sample;

import android.app.Application;

import com.arhiser.nasa_sample.api.NasaService;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class App extends Application {

    private NasaService nasaService;

    @Override
    public void onCreate() {
        super.onCreate();

        nasaService = new NasaService(); //инициализируем сетевой сервис

        //  конфигурация для загрузчика картинок
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(defaultOptions)
                // задаем размер кэша
                .memoryCache(new LruMemoryCache(20 * 1024 * 1024))
                .memoryCacheSize(20 * 1024 * 1024)
                .build();

        ImageLoader.getInstance().init(config); // инициализируем загрузчик картинок
    }

    public NasaService getNasaService() {
        return nasaService;
    }
}
