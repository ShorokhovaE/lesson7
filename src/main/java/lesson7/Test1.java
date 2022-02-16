package lesson7;


public class Test1 {


    public static void test2(){
        System.out.println("Тест без аннотации @Test");
    }

    @Test (priority = 2)
    public static void test3(){
        System.out.println("Тест с приоритетом 2");
    }

    @Test (priority = 2)
    public static void test4(){
        System.out.println("Тест с приоритетом 2");
    }

    @Test (priority = 8)
    public static void test5(){
        System.out.println("Тест с приоритетом 8");
    }

    @AfterSuite
    public static void test6(){
        System.out.println("Тест с аннотацией @AfterSuite");
    }

    @Test (priority = 9)
    public static void test7(){
        System.out.println("Тест с приоритетом 9");
    }

    @Test (priority = 19)
    public static void test8(){
        System.out.println("Тест с приоритетом 19");
    }

    @BeforeSuite
    public static void test9(){
        System.out.println("Тест с аннотацией @BeforeSuite");
    }

    @Test (priority = 5)
    public static void test10(){
        System.out.println("Тест с приоритетом 5");
    }


    @Test(priority = 8)
    public static void test1(){
        System.out.println("Тест с приоритетом 8");
    }



}
