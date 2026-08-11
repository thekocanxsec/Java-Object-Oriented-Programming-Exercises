@FunctionalInterface
interface Calculator{
    int apply(int a, int b);
}


class TestMain{
    static void main() {
        Calculator sum = (int a, int b) -> a + b;
        Calculator sub = (int a, int b) -> a - b;

        System.out.println("Addition: " + calculate(1,2,sum));
        System.out.println("Subtraction: " + calculate(4,2,sub));

    }


    public static int calculate(int a, int b, Calculator op){
        return op.apply(a,b);
    }
}