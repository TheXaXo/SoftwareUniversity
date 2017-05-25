package reflection;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class reflectionClass = Reflection.class;
        System.out.println(reflectionClass);

        Class reflectionSuperClass = reflectionClass.getSuperclass();
        System.out.println(reflectionSuperClass);

        Class[] reflectionClassInterfaces = reflectionClass.getInterfaces();

        for (Class currentInterface : reflectionClassInterfaces) {
            System.out.println(currentInterface);
        }

        Object object = reflectionClass.newInstance();
        System.out.println(object);
    }
}