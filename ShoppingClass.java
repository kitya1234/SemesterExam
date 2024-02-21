interface DiscountRate {
    double getDiscount(String getDiscount);
}



class Sale {
    private String itemType;
    private DiscountRate customer;

    public Sale(String itemType, DiscountRate customer) {
        this.itemType = itemType;
        this.customer = customer;
    }

    public double calculateDiscount() {
        return customer.getDiscount(itemType);  
    }
}

interface DiscountRate {
    double getDiscount(String itemType); 
}

class Customer implements DiscountRate {
    private String customerType;

    public Customer(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public double getDiscount(String itemType) {
        if ("Premium".equals(customerType)) {
            return itemType.equals("Service") ? 0.2 : 0.1;
        } else if ("Gold".equals(customerType)) {
            return itemType.equals("Service") ? 0.15 : 0.1;
        } else if ("Silver".equals(customerType)) {
            return 0.1;
        } else if ("Normal".equals(customerType)) {
            return 0.0;
        }
        return 0.0;
    }
}

public class ShoppingClass {
    public static void main(String[] args) {
        Customer premiumCustomer = new Customer("Premium");
        Customer goldCustomer = new Customer("Gold");
        Customer silverCustomer = new Customer("Silver");
        Customer normalCustomer = new Customer("Normal");

        Sale serviceSalePremium = new Sale("Service", premiumCustomer);
        double serviceDiscountPremium = serviceSalePremium.calculateDiscount();
        System.out.println("Premium Customer - Service Discount: " + serviceDiscountPremium);

        Sale productSaleGold = new Sale("Product", goldCustomer);
        double productDiscountGold = productSaleGold.calculateDiscount();
        System.out.println("Gold Customer - Product Discount: " + productDiscountGold);
    }
}