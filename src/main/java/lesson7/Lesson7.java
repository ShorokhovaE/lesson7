package lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Lesson7 {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Class myTest1 = Test1.class;
        start(myTest1);

        Class myTest2 = Test2.class;
        start(myTest2);
    }


    public static void start(Class testClass) throws InvocationTargetException, IllegalAccessException {

        Method[] methods = testClass.getDeclaredMethods();

        List<Method> listOfMethods = createListOfMethods(methods);

        int checkSuite = checkBeforeAndAfterSuite(methods);

        if(checkSuite <= 0){
            for (Method m : listOfMethods) {
                m.invoke(testClass);
            }
        } else {
            List<Method> beforeAndAfterSuiteList = new ArrayList<>();
            for (int i = 0; i < methods.length; i++) {
                if (methods[i].isAnnotationPresent(BeforeSuite.class)) {
                    beforeAndAfterSuiteList.add(methods[i]);
                }
                if (methods[i].isAnnotationPresent(AfterSuite.class)) {
                    beforeAndAfterSuiteList.add(methods[i]);
                }
            }
            for (Method m : beforeAndAfterSuiteList) {
                if (m.isAnnotationPresent(BeforeSuite.class)) {
                    m.invoke(testClass);
                }
            }
            for (Method m : listOfMethods) {
                m.invoke(testClass);
            }
            for (Method m : beforeAndAfterSuiteList) {
                if (m.isAnnotationPresent(AfterSuite.class)) {
                    m.invoke(testClass);
                }
            }
        }
    }

    public static int checkBeforeAndAfterSuite(Method[] methods){

        int checkBeforeSuite = 0;
        int checkAfterSuite = 0;

        for (Method m : methods) {
            if(m.isAnnotationPresent(BeforeSuite.class)){
                checkBeforeSuite += 1;
            }
            if(m.isAnnotationPresent(AfterSuite.class)){
                checkAfterSuite += 1;
            }
            if(checkAfterSuite > 1 || checkBeforeSuite > 1){
                throw new RuntimeException("В этом классе больше 1 метода с аннотацией @AfterSuite или @BeforeSuite");
            }
        }
        return checkBeforeSuite + checkAfterSuite;
    }

    public static List<Method> createListOfMethods(Method[] methods){

        List<Method> listOfMethods = new ArrayList<>();
        Collections.addAll(listOfMethods, methods);

        Iterator<Method> mIterator = listOfMethods.iterator();

        while (mIterator.hasNext()){
            Method nextMethod = mIterator.next();
            if(!nextMethod.isAnnotationPresent(Test.class)){
                mIterator.remove();
            }
        }

        Collections.sort(listOfMethods, new Comparator<Method>() {
            @Override
            public int compare(Method m1, Method m2) {
                return m1.getAnnotation(Test.class).priority() - m2.getAnnotation(Test.class).priority() ;
            }
        });

        return listOfMethods;

    }

}
