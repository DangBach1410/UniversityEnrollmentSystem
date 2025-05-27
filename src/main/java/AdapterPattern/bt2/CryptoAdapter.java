package AdapterPattern.bt2;

public class CryptoAdapter implements PaymentGateway {
    private CryptoAPI cryptoAPI;

    public CryptoAdapter() {
        this.cryptoAPI = new CryptoAPI();
    }

    @Override
    public void pay(double amount) {
        double btc = amount / 30000.0; // Ví dụ quy đổi USD -> BTC
        cryptoAPI.transferCrypto(btc);
    }
}
