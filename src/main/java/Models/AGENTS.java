package Models;

import DriverConfig.BaseClass;

public class AGENTS {
    public static void AgentType(UserAgents agents){
        switch (agents){
            case IPHONE:
                setUserIphone();
                break;
            case NEXUS:
                initNexus();
                break;
        }
    }

    private static void initNexus() {
    }

    public static void setUserIphone(){
        BaseClass.server.addRequestFilter((request, contents, messageInfo) -> {
            request.headers().remove("user-agent");
            request.headers().remove("Accept-Language");
            request.headers().remove("Content-Language");

            request.headers().add("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_3 like Mac OS X) " +
                    "AppleWebKit/602.1.50 (KHTML, like Gecko) CriOS/56.0.2924.75 Mobile/14E5239e Safari/602.1");
            request.headers().add("Accept-Language", "ru");
            request.headers().add("Content-Language", "ru_RU");

            request.headers().remove("Referer");

            return null;
        });
    }
}
