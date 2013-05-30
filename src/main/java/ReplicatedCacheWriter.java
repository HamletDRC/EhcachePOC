import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.util.Date;

public class ReplicatedCacheWriter {

  public static void main(String[] args) throws Exception {

    CacheManager instance = new CacheManager("./src/main/resources/ehcache_writer.xml");
    Cache cache = instance.getCache("myCache");

    int counter = 0; 
    while (true) {
      cache.put(new Element(counter++, new Date()));
      System.out.println("Writing element " + cache.getSize() 
              + " total size: " + cache.getSize());
      Thread.sleep(1000);
    }

  }
}
