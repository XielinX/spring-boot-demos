package com.demo.basic.service;

/**
 * 函数式接口
 *
 * @author xielx at 2019/10/21 21:04
 */
@FunctionalInterface
public interface IFunInterface {
    
        static void foo(){
            System.out.println("foo类方法");
        }
        
        
        default void bar(){
            System.out.println("bar默认方法");
        }
        
        /**
         * 只定义一个抽象方法
         */
        void test();
    
    
}
