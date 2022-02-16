package lesson7;

public class Test2 {

    @Test(priority = 1)
    public static void test1(){
        System.out.println("Тест с приоритетом 1");
    }

    @Test(priority = 2)
    public static void test2(){
        System.out.println("Тест с приоритетом 2");
    }

    @Test(priority = 2)
    public static void test3(){
        System.out.println("Тест с приоритетом 2");
    }

    @Test(priority = 3)
    public static void test4(){
        System.out.println("Тест с приоритетом 3");
    }

    @Test(priority = 4)
    public static void test5(){
        System.out.println("Тест с приоритетом 4");
    }

    @Test(priority = 6)
    public static void test6(){
        System.out.println("Тест с приоритетом 6");
    }


    public static void test7(){
        System.out.println("Тест без аннотации");
    }

    @BeforeSuite
    public static void test8(){
        System.out.println("Тест с аннотацией @BeforeSuite");
    }
}
