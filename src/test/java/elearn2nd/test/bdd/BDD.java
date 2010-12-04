package elearn2nd.test.bdd;

public class BDD {
    public static void Scenario(String message){
        System.err.println();
        System.err.println("********************************************");
        System.err.println("SCENARIO: "+message);
        System.err.println();
        System.err.flush();
    }

    public static void Given(String message){
        log("given", message);
    }

    public static void When(String message){
        log("when",message);
    }

    public static void Then(String message){
        log("then",message);
    }

    public static void And(String message){
        log("and",message);
    }

    private static void log(String keyword, String message) {
        System.err.println();
        System.err.println("---------------------------------------------");
        System.err.println(keyword.toUpperCase()+": " +message);
        System.err.println("");
        System.err.flush();
    }

    public static void Before(String msg) {
        log("before", msg);
    }

    public static void After(String msg) {
        log("after", msg);
    }
}
