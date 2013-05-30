import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class ReplicatedCacheListener {

  public static void main(String[] args) throws Exception {

    CacheManager instance = new CacheManager("./src/main/resources/ehcache_listener.xml");
    Cache cache = instance.getCache("myCache");

    while (true) {
      Element element4 = cache.get(4);
      System.out.println("Cache is sized: " + cache.getSize() 
              + " element 4 in cache? " + (element4 != null && element4.getValue() != null));
      Thread.sleep(1000);
    }
  }
}
