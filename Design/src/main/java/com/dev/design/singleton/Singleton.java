package com.dev.design.singleton;

public class Singleton {
    private volatile static Singleton singleton = null;
    private  Singleton(){}

    /**
     * 有延时加载式的单例模式
     * @return
     */
    public static Singleton getInstance(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
