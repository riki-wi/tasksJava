// научиться обращаться к папке ресурсов
public class Main {
    public static void main(String[] args) {
        String in = "src\\main\\resources\\example.bmp";
        String out = "src\\main\\resources\\out.bmp";
        new UserInterface(in, out, "toGREY");
    }
}
