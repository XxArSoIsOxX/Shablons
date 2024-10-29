package Modul9;

interface IPaymentProcessor{
    void ProcessPayment(double amount);
}

// доп интерфейс
interface PaymentinKZ{
    void Payment(double tenge);
}

class KaspiBank{
    public void PayKaspi(double tenge){
        System.out.println("Переведен : " + tenge + "tg");
    }
}

class HalykBank implements PaymentinKZ{
    @Override
    public void Payment(double tenge) {
        System.out.println("Переведен : " + tenge + "tg");
    }
}

class AdapterHalykKaspi implements PaymentinKZ{
    private KaspiBank kaspi;

    public AdapterHalykKaspi(KaspiBank kaspiBank){
        this.kaspi = kaspiBank;
    }

    @Override
    public void Payment(double tenge) {
        kaspi.PayKaspi(tenge);
    }
}
//доп интерфейс

class PayPalPaymentProcessor implements IPaymentProcessor{
    @Override
    public void ProcessPayment(double amount){
        System.out.println("Транзакция прошло успешно на сумму : " + amount);
    }
}

class StripePaymentService{
    void MakeTransation(double totalAmount){
        System.out.println("Транзакция прошло успешно на сумму : " + totalAmount);
    } 
}

class StripPaymentAdapter implements IPaymentProcessor{
    private StripePaymentService stripeService;

    public StripPaymentAdapter (StripePaymentService stripeService){
        this.stripeService = stripeService;
    }

    @Override
    public void ProcessPayment(double amount) {
        stripeService.MakeTransation(amount);
    }
}

public class homework2 {
    public static void main(String[] args) {
        IPaymentProcessor payPalPaymebtProcessor = new PayPalPaymentProcessor();
        StripePaymentService stripePaymentService = new StripePaymentService();
        IPaymentProcessor stripPaymentAdapter = new StripPaymentAdapter(stripePaymentService);
        payPalPaymebtProcessor.ProcessPayment(1500);
        stripPaymentAdapter.ProcessPayment(1800);

        PaymentinKZ halykBank = new HalykBank();
        KaspiBank kaspiBank = new KaspiBank();
        PaymentinKZ adapter = new AdapterHalykKaspi(kaspiBank);

        adapter.Payment(1400);
        halykBank.Payment(1800);
    }
}
