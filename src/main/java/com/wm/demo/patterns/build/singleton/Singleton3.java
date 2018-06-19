package com.wm.demo.patterns.build.singleton;

public class Singleton3 {
    private static volatile Singleton3 _instance;

    /**
     * Double checked locking code on Singleton
     * @return Singelton instance
     */
    public static Singleton3 getInstance() {
        if (_instance == null) {
            synchronized (Singleton3.class) {
                if (_instance == null) {
                    _instance = new Singleton3();
                }
            }
        }
        return _instance;
    }
}
