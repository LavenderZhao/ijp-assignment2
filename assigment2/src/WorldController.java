

import javax.xml.ws.AsyncHandler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class WorldController {

	@FXML
	private ImageView imageView;

	@FXML
	private ImageView basketView;
	
	@FXML
	private Button pickButton;
	
	@FXML
	private Button putButton;
	
	@FXML
	private ImageView item1View;
	
	//if the item is on, flag is true
	private boolean flag=false;
	
	private Item item;
	
	public void Initialise() {
        Image image = new Image("image.jpg");
        imageView.setImage(image);
        pickButton.setDisable(true);
	}
	
    public void putButton(ActionEvent event) {
    	//if the item is not on the page, put the item on and set flag = true
    	// and set visible = true.  		
        item.putItem();
        flag = true;           
        pickButton.setDisable(false);
        putButton.setDisable(true);
    }
    
    public void pickButton(ActionEvent event) {
    	if (flag) {
    		item.pickItem();
    		flag = false;
    		putButton.setDisable(false);
    		pickButton.setDisable(true);
    	}
     }
}
