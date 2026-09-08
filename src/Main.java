import controller.AuthController;
import repository.InMemoryUserRepository;
import util.Menus;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() throws Exception {
/*
*
========================
* */
    Scanner scan = new Scanner(System.in);

    Menus.menuAuth(scan);
}
