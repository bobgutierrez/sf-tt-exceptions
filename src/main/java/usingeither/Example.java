package usingeither;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

class Either<E> {
    private E data;
    private Throwable problem;

    private Either(){}
    public static <E> Either<E> success(E data) {
        Either<E> self = new Either<>();
        self.data = data;
        return self;
    }
    public static <E> Either<E> failure(Throwable t) {
        Either<E> self = new Either<>();
        self.problem = t;
        return self;
    }

    public boolean isSuccess() {
        return problem == null;
    }

    public void ifSuccess(Consumer<E> op) {
        if (problem == null) {
            op.accept(data);
        }
    }

    public void ifFailed(Consumer<Throwable> op) {
        if (problem != null) {
            op.accept(problem);
        }
    }
}

public class Example {

//    public static Optional<FileReader> openReader(String n) {
//        try {
//            return Optional.of(new FileReader(n));
//        } catch (FileNotFoundException fnfe) {
////            throw new RuntimeException(fnfe);
//            return Optional.empty();
//        }
//    }

    public static Either<FileReader> openReader(String n) {
        try {
            return Either.success(new FileReader(n));
        } catch (FileNotFoundException fnfe) {
//            throw new RuntimeException(fnfe);
            return Either.failure(fnfe);
        }
    }

    public static void main(String[] args) {
        Stream.of("a.txt", "b.txt", "c.txt")
                .map(n -> openReader(n))
                .forEach(e -> {
                    e.ifFailed(t -> System.out.println("It broke with the problem " + t.getMessage()));
                    e.ifSuccess(d -> System.out.println("Success!!!"));
                });
    }
}
