package com.mehmetberkan.config;

public class RestApis {
    private static final String VERSION = "/v1";
    private static final String DEV = "/dev";
    private static final String BASE_URL = DEV + VERSION;

    public static final String USER = BASE_URL+"/user";
    public static final String CATEGORY = BASE_URL+"/category";
    public static final String PAYMENT= BASE_URL+"/payment";


    public static final String DO_REGISTER = "/register";
    public static final String LOGIN = "/login";
    public static final String ADD_ROLE = "/add-role";


    public static final String ADD_CATEGORY = "/add-category";
    public static final String GET_ALL_CATEGORY = "/get-category";
    public static final String DELETE_CATEGORY= "/delete-category";

    public static final String MAKE_PAYMENT = "/make-payment";
    public static final String GET_PAYMENT = "/get-payment";


}
