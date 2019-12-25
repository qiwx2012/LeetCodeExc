package qiwx.demo;

import sun.jvm.hotspot.utilities.BitMap;
import sun.misc.LRUCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageLoader {
    LRUCache<String, BitMap> mImageCache;
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public ImageLoader() {
        initImageCache();
    }

    private void initImageCache() {
        //计算可用最大内存
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        //取四分之一的可用内存作为缓存
        final int cacheSize = maxMemory / 4;
        mImageCache = new LRUCache<String, BitMap>(cacheSize) {
            @Override
            protected BitMap create(String s) {
                return null;
            }

            @Override
            protected boolean hasName(BitMap bitMap, String s) {
                return false;
            }
        };

    }

}
