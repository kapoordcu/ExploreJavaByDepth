package explore.topics.design.ocp;

public class OCPVoilate {


    public static void main(String[] args) {
        // 1
//        PlatformDescription description = new PlatformDescription();
//        System.out.println(description.describe(Platform.iOS));
//        System.out.println(description.describe(Platform.Android));
        // 2
        NewPlatform desc1 = new Android();
        NewPlatform desc2 = new iOS();
        desc1.description();
        desc2.description();
    }
}

enum Platform {
    iOS,
    Android
}

interface NewPlatform {
    void name();
    void description();
}

class PlatformDescription {
    String describe(Platform platform) {
        switch (platform) {
            case iOS:
                return "iPhone OS, v10.0.1";
            case Android:
                return "Android, v7.1";
        }
        return "Not a valid platform";
    }
}

interface PlatformDesc {
    void describe();
}

class iOS implements NewPlatform {
    @Override
    public void name() {
        System.out.println("iOS");
    }

    @Override
    public void description() {
        System.out.println("iPhone OS, v10.0.1");
    }
}

class Android implements NewPlatform {
    @Override
    public void name() {
        System.out.println("Android");
    }

    @Override
    public void description() {
        System.out.println("Android, v7.1");
    }
}