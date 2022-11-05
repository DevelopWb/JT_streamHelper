package com.juntai.wisdom.basecomponent.utils;

/**
 * Author:wang_sir
 * Time:2019/2/12 17:50
 * Description:This is RxTask
 */
public abstract class RxTask<T> {

    private T t;


    public abstract T doOnIoThread();

    public abstract void doOnUIThread(T t);

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
