package app;

import dao.Connect;

public class Main {

	private static Connect bd;
    private static MainWindow window;
            
    public static void main(String[] args){
        bd = new Connect();
        window = new MainWindow();
        window.setVisible( true );
    }
    
    public static Connect getBD(){
        return bd;
    }
    
    public static void showMainWindow(){
        window.setVisible( true );
    }

}
