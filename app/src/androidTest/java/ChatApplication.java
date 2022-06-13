import com.parse.Parse;

import okhttp3.OkHttpClient;

public class ChatApplication extends android.app.Application{

    private final String applicationId = "BgMeRhXN4Mfsr4iu7cg2PJPITPJgn9T4meopyWPG";
    private final String clientKey = "r6fZMD0BL8dZx0pVlYemVJbHwqaBtIRqO19SX40c";
    private final String server = "https://parseapi.back4app.com/";

    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
// ...
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(applicationId) // provided in Lab instructions
                .clientKey(clientKey) // provided in Lab instructions
                .clientBuilder(builder)
                .server(server).build());  // provided in Lab instructions
    }
}
