package hu.unideb.inf;

import hu.unideb.inf.businesslogic.BusinessData;
import hu.unideb.inf.businesslogic.Enums.BookingState;
import hu.unideb.inf.businesslogic.RequestModels.AddBookingRequest;
import hu.unideb.inf.businesslogic.RequestModels.SetBookingRequest;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/view/PizzaScene.fxml"));
        BusinessData bsd = new BusinessData();
        bsd.SetBooking(new SetBookingRequest(1, BookingState.Free));
        bsd.SetBooking(new SetBookingRequest(2, BookingState.Free));
        bsd.SetBooking(new SetBookingRequest(4, BookingState.Free));
        bsd.SetBooking(new SetBookingRequest(6, BookingState.Free));
        Parent root= FXMLLoader.load(getClass().getResource("/view/PizzaScene.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Pizza Planet");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
