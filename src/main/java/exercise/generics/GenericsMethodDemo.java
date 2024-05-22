package exercise.generics;

public class GenericsMethodDemo {
    public static void main(String[] args) {

    }
}

class GenericsMethod {
    static <T> GenericsClass<T> returnGenericsObject() {
        return new GenericsClass<T>();
    }
}

class GenericsClass<T> {
    T field;
}
