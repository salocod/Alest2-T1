public class Main {
    public static void main(String[] args) {
        java.util.Arrays.asList("casoC50",
                                "casoC100",
                                "casoC200",
                                "casoC500",
                                "casoC750",
                                "casoC1000",
                                "casoC1500",
                                "casoC2000")
        .stream().map(text -> "./tests/" + text + ".txt")
        .forEach(text -> new Leitor(text));
    }
}