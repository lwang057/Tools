package com.lwang.tools;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author lwang
 * @date 2018/8/2
 * @description presenter工厂类
 */

public class PresenterFactory {

    /**
     * 通过反射机制获取presenter的实例
     *
     * @param object
     * @return
     */
//  public static <T extends BasePresenter> T createPresenter(Object object) {
    public static <T> T createPresenter(Object object) {

        T t = null;

        // 通过getGenericSuperclass()方法，可以获取到父类泛型的类型（也就是BaseActivity的泛型类型），强转为参数化类型
        ParameterizedType type = (ParameterizedType) object.getClass().getGenericSuperclass();

        if (type != null) {

            // 获取参数化类型中，实际类型的定义，返回的是Type数组
            Type[] actualTypeArguments = type.getActualTypeArguments();

            // 获取数组中的第一个
            Class<T> tClass = (Class<T>) actualTypeArguments[0];

            try {
                // 通过反射机制得到其对象，Class.newInstance只能调用无参构造函数
                t = tClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return t;
    }


}
