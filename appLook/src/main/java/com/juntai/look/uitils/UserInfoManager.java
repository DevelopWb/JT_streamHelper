package com.juntai.look.uitils;

import com.juntai.look.bean.LoginBean;
import com.orhanobut.hawk.Hawk;

/**
 * @Author: tobato
 * @Description: 作用描述   用户信息管理类
 * @CreateDate: 2020/7/9 10:05
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/9 10:05
 */
public class UserInfoManager {


    /**
     * 获取用户信息
     * @return
     */
    public static LoginBean.UserBean  getUserBean(){
        LoginBean.UserBean userBean = Hawk.get(HawkProperty.USER_INFO);
        return userBean==null?new LoginBean.UserBean():userBean;
    }
    /**
     * 获取用户信息
     * @return
     */
    public static int  getUserId(){
        return getUserBean().getId();
    }
    /**
     * 获取用户状态  （0有效；1无效）
     * @return
     */
    public static int  getUserStatus(){
        return getUserBean().getStatusX();
    }
    /**
     * 获取账号的性质 是否是测试号
     * @return
     */
    public static boolean  isTest(){
        return getUserBean().isTest();
    }


    /**
     * 获取用户信息 token
     * @return
     */
    public static String  getUserToken(){
        return getUserBean().getToken();
    }
    /**
     * 获取用户信息 pwd
     * @return
     */
    public static String  getUserPwd(){
        return getUserBean().getPassword();
    }
    /**
     * 获取用户信息 Account
     * @return
     */
    public static String  getUserAccount(){
        return getUserBean().getAccount();
    }


}
