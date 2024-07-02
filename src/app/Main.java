package app;

public class Main {

    public static void main(String[] args) {
        SaleProduct saleProduct1 = new SaleProduct();
        SaleProduct saleProduct2 = new SaleProduct();

        saleProduct1.setNumbProduct(SaleProduct.getNumbProduct());
        saleProduct1.setProduct("smartphone");
        saleProduct1.setPrice(2430.682);
        saleProduct1.setQuantityDays(5);
        saleProduct2.setProduct("laptop");
        saleProduct2.setPrice(1498.121);
        saleProduct2.setQuantityDays(7);

        SaleProduct.print(saleProduct1);
        saleProduct2.setNumbProduct(SaleProduct.getNumbProduct());
        SaleProduct.print(saleProduct2);

    }
}

class SaleProduct {

    private static final String PRODUCT = "Product";
    private static final String TOTAL = "total";
    private static final String SALES = "sales";

    private static int numbProduct = 1;
    private String product;
    private double price;
    private int quantityDays;
    private double totalSales;


    public void setNumbProduct(int numbProduct) {
        SaleProduct.numbProduct = numbProduct;
    }
    public static int getNumbProduct() {
        return numbProduct++;
    }

    public void setProduct(String product) {
        this.product = product;
    }
    public String getProduct() {
        return product;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setQuantityDays(int quantityDays) {
        this.quantityDays = quantityDays;
    }
    public int getQuantityDays() {
        return quantityDays;
    }

    private double countTotal() {
        totalSales = quantityDays * price;
        return totalSales;
    }
    private double countAvg() {
        return totalSales / quantityDays;
    }

    public static void print(SaleProduct saleProduct) {
        System.out.printf("%n%s No %d: %s" +
                        "%n%s sales for %d days is EUR %.2f" +
                        "%n%s by day is EUR %.2f %n", PRODUCT, getNumbProduct(),
               saleProduct.getProduct(), TOTAL, saleProduct.getQuantityDays(),
                saleProduct.countTotal(), SALES, saleProduct.countAvg());
    }
}

