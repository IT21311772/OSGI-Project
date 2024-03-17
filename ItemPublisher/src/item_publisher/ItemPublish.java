package item_publisher;

public interface ItemPublish {
	public String getRole();
	public void itemMain();
	public boolean validate(String username, String password);
	public void displayItems();
	public void displaySuppliers();
	public void assignOrders();
}
