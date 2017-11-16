package model;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Item {
	@FXML
	private ImageView item1View;
	
	@FXML
	private ImageView item2View;
	
	@FXML
	private ImageView basketView;
	
	private Image basket = new Image("basket.png");
	private int itemNum = 0;
	
	public void putItem() {
		
		basketView.setImage(basket);        
        basketView.setVisible(true);
        item1View.setVisible(false);
        itemNum--;
        
	}
	
	public void pickItem() {
		basketView.setVisible(false);
		if (itemNum == 0) {
			item1View.setImage(basket);                
	        item1View.setVisible(true);
	        itemNum++;
		} else {
			item2View.setImage(basket);                
	        item2View.setVisible(true);
		}
		
	}
}
