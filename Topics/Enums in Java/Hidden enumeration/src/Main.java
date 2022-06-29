public class Main {

    public static void main(String[] args) {
        int counter = 0;

        // write your code here
        for (Secret scret: Secret.values()) {
            if (scret.toString().startsWith("STAR")) {
                counter += 1;
            }
        }

        System.out.println(counter);
    }
}

// sample enum for inspiration
/*enum Secret {
    STAR, CRASH, START, // ...
}*/
