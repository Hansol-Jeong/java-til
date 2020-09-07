package com.company;

public class LoadingView {
    String loadingView ="선공을 결정중입니다...ㅡ";
    String AILoading = "AI가 수를 고민하고있습니다...ㅡ";
    public void loadingView() throws InterruptedException {
        for(int i = 0; i<25; i++)
            System.out.println();
        System.out.println(loadingView);
        Thread.sleep(300);

        for(int i = 0; i<25; i++)
            System.out.println();
        System.out.println(loadingView.replace("ㅡ","\\"));
        Thread.sleep(300);

        for(int i = 0; i<25; i++)
            System.out.println();
        System.out.println(loadingView.replace("ㅡ","ㅣ"));
        Thread.sleep(300);

        for(int i = 0; i<25; i++)
            System.out.println();
        System.out.println(loadingView.replace("ㅡ","/"));
        Thread.sleep(300);

        for(int i = 0; i<25; i++)
            System.out.println();
        System.out.println(loadingView);
        Thread.sleep(300);

        for(int i = 0; i<25; i++)
            System.out.println();
        System.out.println(loadingView.replace("ㅡ","\\"));
        Thread.sleep(300);

        for(int i = 0; i<25; i++)
            System.out.println();
        System.out.println(loadingView.replace("ㅡ","ㅣ"));
        Thread.sleep(300);

        for(int i = 0; i<25; i++)
            System.out.println();
        System.out.println(loadingView.replace("ㅡ","/"));
        Thread.sleep(300);

        for(int i = 0; i<25; i++)
            System.out.println();
        System.out.println(loadingView);
        Thread.sleep(300);

        for(int i = 0; i<25; i++)
            System.out.println();

    }
    public void AILoadingView()throws InterruptedException {
        for(int i = 0; i<25; i++)
            System.out.println();
        System.out.println(AILoading);
        Thread.sleep(300);

        for(int i = 0; i<25; i++)
            System.out.println();
        System.out.println(AILoading.replace("ㅡ","\\"));
        Thread.sleep(300);

        for(int i = 0; i<25; i++)
            System.out.println();
        System.out.println(AILoading.replace("ㅡ","ㅣ"));
        Thread.sleep(300);

        for(int i = 0; i<25; i++)
            System.out.println();
        System.out.println(AILoading.replace("ㅡ","/"));
        Thread.sleep(300);
        for(int i = 0; i<25; i++)
            System.out.println();

        System.out.println(AILoading);
        Thread.sleep(300);
        for(int i = 0; i<25; i++)
            System.out.println();

        System.out.println(AILoading.replace("ㅡ","\\"));
        Thread.sleep(300);
        for(int i = 0; i<25; i++)
            System.out.println();

        for(int i = 0; i<25; i++)
            System.out.println();
        System.out.println(AILoading.replace("ㅡ","ㅣ"));
        Thread.sleep(300);

        for(int i = 0; i<25; i++)
            System.out.println();
        System.out.println(AILoading.replace("ㅡ","/"));
        Thread.sleep(300);

        for(int i = 0; i<25; i++)
            System.out.println();
        System.out.println(AILoading);
        Thread.sleep(300);

        for(int i = 0; i<25; i++)
            System.out.println();

    }
}
