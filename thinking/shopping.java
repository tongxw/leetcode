// member
public class Account {
  private String userName;
  private String password;
  private AccountStatus status;
  private String name;
  private Address shippingAddress;
  private String email;
  private String phone;
  private List<CreditCard> creditCards;
  private List<ElectronicBankTransfer> bankAccounts;

  public boolean addProduct(Product product);

  public boolean addProductReview(ProductReview review);

  public boolean resetPassword();
}

public abstract class Customer {
  private ShoppingCart cart;
  private Order order;

  public ShoppingCart getShoppingCart();

  public bool addItemToCart(Item item);

  public bool removeItemFromCart(Item item);
}

public class Guest extends Customer {
  public bool registerAccount();
}

public class Member extends Customer {
  private Account account;

  public OrderStatus placeOrder(Order order);
}

// product
public class ProductCategory {
  private String name;
  private String description;
}

public class ProductReview {
  private int rating;
  private String review;
  private Member reviewer;
}

public class Product {
  private String productID;
  private String name;
  private String description;
  private double price;
  private ProductCategory category;
  private int availableItemCount;
  private Account seller;

  public int getAvailableCount();

  public boolean updatePrice(double newPrice);
}

// shipment
public class ShipmentLog {
  private String shipmentNumber;
  private ShipmentStatus status;
  private Date creationDate;
}

public class Shipment {
  private String shipmentNumber;
  private Date shipmentDate;
  private Date estimatedArrival;
  private String shipmentMethod;
  private List<ShipmentLog> shipmentLogs;

  public boolean addShipmentLog(ShipmentLog shipmentLog);
}

public abstract class Notification {
  private int notificationId;
  private Date createdOn;
  private String content;

  public boolean sendNotification(Account account);
}

// search
public interface Search {
  public List<Product> searchProductsByName(String name);

  public List<Product> searchProductsByCategory(String category);
}

public class Catalog implements Search {
  HashMap<String, List<Product>> productNames;
  HashMap<String, List<Product>> productCategories;

  public List<Product> searchProductsByName(String name) {
    return productNames.get(name);
  }

  public List<Product> searchProductsByCategory(String category) {
    return productCategories.get(category);
  }
}