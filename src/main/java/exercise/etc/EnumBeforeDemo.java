package exercise.etc;

public class EnumBeforeDemo {

    public static final int americano = 0;
    public static final int latte = 1;
    public static final int strawberryAde = 2;
    public static final int espresso = 3;
    int menu;

    EnumBeforeDemo(int menu) {
        this.menu = menu;
    }



    public void selectMenu() {
        switch(menu) {
            case americano: // 0:
                System.out.println("아메리카노");
                break;
            case latte: // 1:
                System.out.println("라떼");
                break;
            case strawberryAde: // 2:
                System.out.println("딸기에이드");
                break;
            case espresso: // 3:
                System.out.println("에스프레소");
                break;
        }
    }
}
