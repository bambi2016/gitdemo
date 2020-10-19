package a;

import sun.security.util.Cache;

public class AdminCache {
    //第一个参数表示cache对象中允许添加的键值对数量，第二个参数表示缓存的时间，单位是秒
    private static Cache cache = Cache.newHardMemoryCache(3,5);

    public static Admin get(String key){
        return (Admin)cache.get(key);
    }
    public static void set(String key,Admin admin){
        AdminCache.cache.put(key,admin);
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Admin admin = new Admin();
            admin.setUserId(i);
            set(String.valueOf(i),admin);
        }

        while (true){
            for (int i = 0; i < 5; i++) {
                Object o = cache.get(String.valueOf(i));
                System.out.println(o);
                if (o instanceof Admin){
                    Admin admin = (Admin) o;
                    System.out.println(admin.toString());
                }
            }
            Thread.sleep(1000);
        }
    }
}
